package org.springframework.samples.petclinic.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.AdoptionApplication;
import org.springframework.samples.petclinic.service.AdoptionApplicationService;
import org.springframework.samples.petclinic.service.exceptions.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdoptionApplicationController {

    AdoptionApplicationService adoptionApplicationService;

    @Autowired
    public AdoptionApplicationController(AdoptionApplicationService adoptionApplicationService) {
        this.adoptionApplicationService = adoptionApplicationService;
    }

    @GetMapping("/adoptions/{adoptionId}/application")
    public String getAdoptionApplicationCreateView(Map<String, Object> model) {

        AdoptionApplication adoptionApplication = new AdoptionApplication();
        model.put("adoptionApplication", adoptionApplication);

        // TODO Add AdoptionRequest to view
        return "adoptions/adoptionApplication";
    }

    @PostMapping("/adoptions/{adoptionId}/application")
    public String createAdoptionApplication(@PathVariable("adoptionId") int adoptionId,
            AdoptionApplication adoptionApplication, BindingResult result, Map<String, Object> model) {

        if (result.hasErrors()) {
            model.put("adoptionApplication", adoptionApplication);
            return "adoptions/adoptionApplication";
        }

        try {
            this.adoptionApplicationService.saveAdoptionApplication(adoptionId, adoptionApplication);
        } catch (NotFoundException e) {
            result.rejectValue("adoptionApplication", "duplicate", "already exists");
            return "adoptions/adoptionApplication";
        } catch (Exception e) {
            result.rejectValue("adoptionApplication", "duplicate", "already exists");
            return "adoptions/adoptionApplication";
        }

        return "adoptions/adoptionList";
    }
}
