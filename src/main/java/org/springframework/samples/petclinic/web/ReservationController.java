package org.springframework.samples.petclinic.web;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Owner;
import org.springframework.samples.petclinic.model.Reservation;
import org.springframework.samples.petclinic.service.OwnerService;
import org.springframework.samples.petclinic.service.ReservationService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/owners/{ownerId}")
public class ReservationController {
    
    private static final String VIEWS_CREATE_RESERVATION = "reservations/reservationForm";

    private final ReservationService resService;
    private final OwnerService ownerService;
    
    @Autowired
    public ReservationController(ReservationService resService, OwnerService ownerService){
        this.resService = resService;
        this.ownerService = ownerService;
    }

    @ModelAttribute("owner")
	public Owner findOwner(@PathVariable("ownerId") int ownerId) {
		return this.ownerService.findOwnerById(ownerId);
	}

    @GetMapping(value = "/reservations/new")
	public String nuevaReserva(Owner owner,Map<String, Object> model) {

        Reservation res = resService.creaNuevaReserva(new Reservation());
        model.put("userPets", owner.getPets());
		model.put("reservation", res);
		return VIEWS_CREATE_RESERVATION;
	}

    @PostMapping(value= "/reservations/new")
    public String saveReserva(Owner owner, @Valid Reservation res, BindingResult result, Map<String, Object> model) {
        if (result.hasErrors()) {
            Reservation reservation = resService.creaNuevaReserva(res);
            model.put("userPets", owner.getPets());
            model.put("reservation", reservation);
            return VIEWS_CREATE_RESERVATION;
		}
        else{
            try {
				resService.saveReservation(res);
			} catch (BusyReservationException e) {
				e.printStackTrace();
				// model.put("errMessage", );
				return "redirect:/owners/{ownerId}";
			}
            return "redirect:/owners/{ownerId}";
        }

    }
    

    public String hotelOcupado() {
    	return VIEWS_CREATE_RESERVATION;
    }
    
}
