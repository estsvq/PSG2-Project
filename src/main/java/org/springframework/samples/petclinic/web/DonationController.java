package org.springframework.samples.petclinic.web;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Donation;
import org.springframework.samples.petclinic.model.User;
import org.springframework.samples.petclinic.service.DonationService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("causes/{causeId}/donations")
public class DonationController {
    
    private static final String VIEWS_CREATE_DONATION = "donations/donationForm";
    
    private final DonationService donationService;
    // private final CauseService causeService;

    @Autowired
    public DonationController(DonationService donationService/*, CauseService causeService*/ ){
        this.donationService = donationService;
        // this.causeService = causeService;

    }

    // @ModelAttribute("cause")
	// public Cause findCause(@PathVariable("causeId") int causeId) {
	// 	return this.causeService.findCauseById(causeId);
	// }


    @GetMapping("/new")
    public String newDonation(/*Cause cause,*/Map<String, Object> model){

        // Donation donation = donationService.createDonation(cause);
        model.put("donation", new Donation());
        return VIEWS_CREATE_DONATION;
    }

    @GetMapping("/new")
    public String saveDonation(/*Cause cause,*/@Valid Donation donation, BindingResult result,  Map<String, Object> model){
        if(result.hasErrors()){
            // Donation donation = donationService.createDonation(cause);
            model.put("donation", new Donation());
            return VIEWS_CREATE_DONATION;
        }else{
            donationService.save(donation);
            return "redirect:/causes/{causeId}/donations";
        } 
    }


}
