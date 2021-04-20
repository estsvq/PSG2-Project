package org.springframework.samples.petclinic.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.AdoptionApplication;
import org.springframework.samples.petclinic.repository.AdoptionApplicationRepository;
import org.springframework.samples.petclinic.service.exceptions.DuplicatedAdoptionApplicationException;
import org.springframework.samples.petclinic.service.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AdoptionApplicationService {

    AdoptionApplicationRepository adoptionApplicationRepository;

    @Autowired
    public AdoptionApplicationService(AdoptionApplicationRepository adoptionApplicationRepository) {
        this.adoptionApplicationRepository = adoptionApplicationRepository;
    }

    public AdoptionApplication saveAdoptionApplication(int adoptionId, AdoptionApplication adoptionApplication)
            throws NotFoundException, DuplicatedAdoptionApplicationException {
        return this.adoptionApplicationRepository.save(adoptionApplication);
    }

    public Optional<AdoptionApplication> getAdoptionApplicationById(int id) {
        return this.adoptionApplicationRepository.findById(id);
    }
}
