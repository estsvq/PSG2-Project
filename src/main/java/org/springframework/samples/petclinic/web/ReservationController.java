package org.springframework.samples.petclinic.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Reservation;
import org.springframework.samples.petclinic.service.ReservationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReservationController {
    
    private static final String VIEWS_CREATE_RESERVATION = "reservations/reservationForm";

    private final ReservationService resService;

    @Autowired
    public ReservationController(ReservationService resService){
        this.resService = resService;
    }

    @GetMapping(value = "/reservations/new")
	public String initCreationForm(Map<String, Object> model) {
		Reservation res = new Reservation();
		model.put("reservation", res);
		return VIEWS_CREATE_RESERVATION;
	}
}
