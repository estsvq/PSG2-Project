package org.springframework.samples.petclinic.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.AdoptionApplication;
import org.springframework.samples.petclinic.model.User;
import org.springframework.samples.petclinic.service.AdoptionApplicationService;
import org.springframework.samples.petclinic.service.AdoptionRequestService;
import org.springframework.samples.petclinic.service.UserService;
import org.springframework.samples.petclinic.service.exceptions.DuplicatedAdoptionApplicationException;
import org.springframework.samples.petclinic.service.exceptions.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdoptionApplicationController {

    static final String VIEWS_CREATE_ADOPTION_APPLICATION = "adoptionApplications/createOrUpdateAdoptionApplicationForm";

    static final String VIEWS_LIST_ADOPTION_APPLICATION = "adoptionApplications/petApplications";

    AdoptionApplicationService adoptionApplicationService;

    AdoptionRequestService adoptionRequestService;

    UserService userService;

    @Autowired
    public AdoptionApplicationController(AdoptionApplicationService adoptionApplicationService,
            AdoptionRequestService adoptionRequestService, UserService userService) {
        this.adoptionApplicationService = adoptionApplicationService;
        this.adoptionRequestService = adoptionRequestService;
        this.userService = userService;
    }

    @GetMapping("/adoptions/{adoptionId}")
    public String getAdoptionApplicationCreateView(@PathVariable("adoptionId") Integer adoptionId,
            Map<String, Object> model) {
        User user = userService.getLoggedUser();

        if (user == null) {
            return "redirect:/";
        }

        String username = user.getUsername();

        try {
            AdoptionApplication adoptionApplication = adoptionApplicationService
                    .instantiateAdoptionApplication(adoptionId, username);

            model.put("adoptionApplication", adoptionApplication);
            return VIEWS_CREATE_ADOPTION_APPLICATION;
        } catch (NotFoundException e) {

        }

        return "redirect:/";
    }

    @PostMapping("/adoptions/{adoptionId}")
    public String createAdoptionApplication(@PathVariable("adoptionId") int adoptionId,
            AdoptionApplication adoptionApplication, BindingResult result, Map<String, Object> model) {

        if (result.hasErrors()) {
            model.put("adoptionApplication", adoptionApplication);
            return VIEWS_CREATE_ADOPTION_APPLICATION;
        }
        try {
            this.adoptionApplicationService.saveAdoptionApplication(adoptionApplication);
        } catch (DuplicatedAdoptionApplicationException e) {

        }
        return "redirect:/adoptions";
    }

    @GetMapping("/adoptions/{adoptionId}/applications")
    public String listPetApplications(@PathVariable("adoptionId") int adoptionId, ModelMap model){
        if(!adoptionRequestService.checkIfIsOwner(adoptionId)){
            return "redirect:/";
        }
        List<AdoptionApplication> lista = adoptionApplicationService.findAdoptionApplicationByAdoptionRequest(adoptionId);
        model.addAttribute("applications", lista);
        return VIEWS_LIST_ADOPTION_APPLICATION;
    }

    @GetMapping("/adoptions/{adoptionId}/applications/{applicationId}/approve")
    public String approveApplications(@PathVariable("adoptionId") int adoptionId,@PathVariable("applicationId") int applicationId){
        if(!adoptionRequestService.checkIfIsOwner(adoptionId)){
            return "redirect:/";
        }
        this.adoptionApplicationService.approveAdoption(applicationId, adoptionId);
        return "redirect:/adoptions/myAdoptions";
    }
}
