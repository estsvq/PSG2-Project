package org.springframework.samples.petclinic.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.AdoptionApplication;
import org.springframework.samples.petclinic.model.AdoptionRequest;
import org.springframework.samples.petclinic.model.Owner;
import org.springframework.samples.petclinic.model.Pet;
import org.springframework.samples.petclinic.repository.AdoptionApplicationRepository;
import org.springframework.samples.petclinic.service.exceptions.DuplicatedAdoptionApplicationException;
import org.springframework.samples.petclinic.service.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AdoptionApplicationService {

    AdoptionApplicationRepository adoptionApplicationRepository;

    AdoptionRequestService adoptionRequestService;

    OwnerService ownerService;

    PetService petService;

    @Autowired
    public AdoptionApplicationService(AdoptionApplicationRepository adoptionApplicationRepository,
            AdoptionRequestService adoptionRequestService, OwnerService ownerService,PetService petService) {
        this.adoptionApplicationRepository = adoptionApplicationRepository;
        this.adoptionRequestService = adoptionRequestService;
        this.ownerService = ownerService;
        this.petService = petService;
    }

    public AdoptionApplication saveAdoptionApplication(AdoptionApplication adoptionApplication) throws DuplicatedAdoptionApplicationException {
        Integer ownerId = adoptionApplication.getApplicant().getId();
        Integer adoptionId = adoptionApplication.getAdoptionRequest().getId();
        AdoptionApplication application = this.adoptionApplicationRepository.findAdoptionApplicationByOwnerAndRequest(ownerId, adoptionId);
        if(application != null) {
            throw new DuplicatedAdoptionApplicationException();
        }
        return this.adoptionApplicationRepository.save(adoptionApplication);
    }

    public Optional<AdoptionApplication> getAdoptionApplicationById(int id) {
        return this.adoptionApplicationRepository.findById(id);
    }

    public AdoptionApplication instantiateAdoptionApplication(Integer adoptionId, String username)
            throws NotFoundException {
        AdoptionApplication adoptionApplication = new AdoptionApplication();
        AdoptionRequest adoptionRequest = this.adoptionRequestService.findById(adoptionId);
        Owner owner = this.ownerService.findOwnerByUsername(username);

        if (owner == null || adoptionRequest == null) {
            throw new NotFoundException();
        }

        adoptionApplication.setApplicant(owner);
        adoptionApplication.setAdoptionRequest(adoptionRequest);
        return adoptionApplication;
    }

    public List<AdoptionApplication> findAdoptionApplicationByAdoptionRequest(Integer adRequestId){
        return this.adoptionApplicationRepository.findAdoptionApplicationByAdoptionRequest(adRequestId);
    }

    public void approveAdoption(Integer applicationId, Integer adoptionId){
        AdoptionApplication adop = this.adoptionApplicationRepository.findById(applicationId).get();
        List<AdoptionApplication> lista = this.findAdoptionApplicationByAdoptionRequest(adoptionId);
        this.adoptionApplicationRepository.deleteAll(lista);
        AdoptionRequest adoptionRequest = adop.getAdoptionRequest();
        Pet pet = adoptionRequest.getPet();
        pet.setOwner(adop.getApplicant());
        pet.setAdoptionRequest(null);
        adoptionRequest.setPet(null);
        try{
            this.petService.savePet(pet);
        }catch(Exception e){
            e.printStackTrace();
        }
        this.adoptionRequestService.delete(adoptionRequest.getId());


    }
}
