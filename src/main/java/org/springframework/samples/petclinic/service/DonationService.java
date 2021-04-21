package org.springframework.samples.petclinic.service;

import java.time.LocalDate;
import java.util.Optional;


import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.model.Cause;
import org.springframework.samples.petclinic.model.Donation;
import org.springframework.samples.petclinic.repository.DonationRepository;
import org.springframework.stereotype.Service;

@Service
public class DonationService {

    private DonationRepository donationRepo;
    private UserService userService;

    @Autowired
    public DonationService(DonationRepository donationRepo){
        this.donationRepo = donationRepo;
    }

    @Transactional
    public <S extends Donation> S save(S entity) throws DataAccessException {
        return donationRepo.save(entity);
    }
    @Transactional
    public <S extends Donation> Iterable<S> saveAll(Iterable<S> entities) throws DataAccessException {
        return donationRepo.saveAll(entities);
    }
    @Transactional(readOnly=true)
    public Optional<Donation> findById(String id) {
        return donationRepo.findById(id);
    }
    @Transactional(readOnly=true)
    public boolean existsById(String id) {
        return donationRepo.existsById(id);
    }
    @Transactional(readOnly=true)
    public Iterable<Donation> findAll() {
        return donationRepo.findAll();
    }

    @Transactional(readOnly=true)
    public long count() {
        return donationRepo.count();
    }
    @Transactional
    public void delete(Donation entity) throws DataAccessException {
        donationRepo.delete(entity);
    }

    public Donation createDonation(Cause cause){
        Donation donation = new Donation();
        donation.setClient(this.userService.getLoggedUser());
        donation.setDate(LocalDate.now());
        donation.setCause(cause);
        return donation;
    }
    
}
