package org.springframework.samples.petclinic.service;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.model.AdoptionRequest;
import org.springframework.samples.petclinic.model.Owner;
import org.springframework.samples.petclinic.model.Pet;
import org.springframework.samples.petclinic.repository.AdoptionRequestRepository;
import org.springframework.samples.petclinic.service.exceptions.DuplicatedPetNameException;
import org.springframework.stereotype.Service;

@Service
public class AdoptionRequestService {

    private AdoptionRequestRepository adoptionRequestRepository;

    private PetService petService;

    private OwnerService ownerService;

    private UserService userService;

    @Autowired
    public AdoptionRequestService(AdoptionRequestRepository adoptionRequestRepository, 
    PetService petService, OwnerService ownerService, UserService userService) {
        this.adoptionRequestRepository = adoptionRequestRepository;
        this.petService = petService;
        this.ownerService= ownerService;
        this.userService= userService;
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

    @Transactional(readOnly = true)
    public AdoptionRequest findById(Integer id) {
        return this.adoptionRequestRepository.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    public List<AdoptionRequest> findAdoptionsRequestByOwner(Integer id){
        return this.adoptionRequestRepository.findAdoptionsRequestByOwner(id);
    }

    @Transactional
    public Boolean checkIfIsOwner(Integer adoptionId){
        Owner owner = ownerService.findOwnerByUsername(userService.getLoggedUser().getUsername());
        AdoptionRequest adoptionRequest = adoptionRequestRepository.findById(adoptionId).get();
        return owner.getId().equals(adoptionRequest.getPet().getOwner().getId());
    }

    @Transactional
    public void delete(Integer id){
        adoptionRequestRepository.deleteById(id);
    }

}
