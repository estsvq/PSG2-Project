package org.springframework.samples.petclinic.service;

import java.util.Collection;
import java.util.stream.StreamSupport;

import javax.transaction.Transactional;

import com.sun.tools.javac.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.model.AdoptionRequest;
import org.springframework.samples.petclinic.model.Pet;
import org.springframework.samples.petclinic.repository.AdoptionRequestRepository;
import org.springframework.samples.petclinic.service.exceptions.DuplicatedPetNameException;
import org.springframework.stereotype.Service;

@Service
public class AdoptionRequestService {

    private AdoptionRequestRepository adoptionRequestRepository;

    private PetService petService;

    @Autowired
    public AdoptionRequestService(AdoptionRequestRepository adoptionRequestRepository, PetService petService) {
        this.adoptionRequestRepository = adoptionRequestRepository;
        this.petService = petService;
    }

    @Transactional
    public AdoptionRequest createAdoptionRequest(AdoptionRequest adoptionRequest)
            throws DataAccessException, DuplicatedPetNameException {
        adoptionRequest = this.adoptionRequestRepository.save(adoptionRequest);
        Pet pet = adoptionRequest.getPet();
        pet.setAdoptionRequest(adoptionRequest);
        petService.savePet(pet);
        return adoptionRequest;
    }

    @Transactional
    public Iterable<AdoptionRequest> findAllAdoptionRequests() {
        return this.adoptionRequestRepository.findAll();
    }

}
