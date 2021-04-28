package org.springframework.samples.petclinic.web;

import java.util.Collection;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.model.AdoptionRequest;
import org.springframework.samples.petclinic.model.Pet;
import org.springframework.samples.petclinic.service.AdoptionRequestService;
import org.springframework.samples.petclinic.service.OwnerService;
import org.springframework.samples.petclinic.service.UserService;
import org.springframework.samples.petclinic.service.exceptions.DuplicatedPetNameException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.samples.petclinic.model.User;

@Controller
public class AdoptionRequestController {

    private static final String VIEWS_CREATE_ADOPTION_REQUEST = "adoptionRequests/createOrUpdateAdoptionRequestForm";

    private static final String VIEWS_LIST_ADOPTION_REQUEST = "adoptionRequests/AdoptionRequestList";

    private final OwnerService ownerService;

    private final AdoptionRequestService adoptionRequestService;

    private final UserService userService;

    @Autowired
    public AdoptionRequestController(OwnerService ownerService, UserService userService,
            AdoptionRequestService adoptionRequestService) {
        this.ownerService = ownerService;
        this.adoptionRequestService = adoptionRequestService;
        this.userService = userService;
    }

    @GetMapping(value = "/adoptions/new")
    public String getAdoptionRequestCreateView(Map<String, Object> model) {

        User user = userService.getLoggedUser();
        if (user == null) {
            return "redirect:/";
        }

        Collection<Pet> pets = ownerService.findPetsByUser(user);

        AdoptionRequest adoptionRequest = new AdoptionRequest();

        model.put("pets", pets);
        model.put("adoptionRequest", adoptionRequest);
        return VIEWS_CREATE_ADOPTION_REQUEST;
    }

    @PostMapping(value = "/adoptions/new")
    public String createAdoptionRequest(@Valid AdoptionRequest adoptionRequest, BindingResult result,
            Map<String, Object> model) throws DataAccessException, DuplicatedPetNameException {
        User user = userService.getLoggedUser();
        if (user == null) {
            return "redirect:/";
        }

        if (result.hasErrors()) {
            return VIEWS_CREATE_ADOPTION_REQUEST;
        }

        this.adoptionRequestService.createAdoptionRequest(adoptionRequest);

        return "redirect:/adoptions";
    }

    @GetMapping("/adoptions")
    public String listAdoptionRequests(Map<String, Object> model) {
        Iterable<AdoptionRequest> adoptions = adoptionRequestService.findAllAdoptionRequests();
        model.put("adoptions", adoptions);
        return VIEWS_LIST_ADOPTION_REQUEST;
    }

}
