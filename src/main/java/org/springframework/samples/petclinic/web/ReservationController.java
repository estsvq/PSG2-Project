package org.springframework.samples.petclinic.web;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.model.Pet;
import org.springframework.samples.petclinic.model.Reservation;
import org.springframework.samples.petclinic.model.User;
import org.springframework.samples.petclinic.service.OwnerService;
import org.springframework.samples.petclinic.service.PetService;
import org.springframework.samples.petclinic.service.ReservationService;
import org.springframework.samples.petclinic.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ReservationController {
    
    private static final String VIEWS_CREATE_RESERVATION = "reservations/reservationForm";

    private final ReservationService resService;
    private final UserService userService;
    private final OwnerService ownerService;
    private final PetService petService;
    @Autowired
    public ReservationController(ReservationService resService, UserService userService,
     OwnerService ownerService, PetService petService){
        this.resService = resService;
        this.userService = userService;
        this.ownerService = ownerService;
        this.petService = petService;
    }

    @GetMapping(value = "/reservations/new")
	public String nuevaReserva(Map<String, Object> model) {
		Reservation res = new Reservation();
        res.setStartDate(LocalDate.now());
        res.setFinnishDate(LocalDate.now().plusDays(1));
        User userlog = userService.getLoggedUser();
        Collection<Pet> pets = ownerService.findPetsByUser(userlog);
        model.put("userPets", pets);
		model.put("reservation", res);
		return VIEWS_CREATE_RESERVATION;
	}

    @PostMapping(value= "/reservations/new")
    public String saveReserva(@Valid Reservation res, BindingResult result, Map<String, Object> model) {
        if (result.hasErrors()) {
            res.setStartDate(LocalDate.now());
            res.setFinnishDate(LocalDate.now().plusDays(1));
            User userlog = userService.getLoggedUser();
            Collection<Pet> pets = ownerService.findPetsByUser(userlog);
            model.put("userPets", pets);
            model.put("reservation", res);
            return VIEWS_CREATE_RESERVATION;
		}
        else{
            resService.saveReservation(res);
            return "welcome";
        }

    }
}
