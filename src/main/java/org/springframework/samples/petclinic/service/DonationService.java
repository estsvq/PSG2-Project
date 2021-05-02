package org.springframework.samples.petclinic.service;

import java.time.LocalDate;
import java.util.Optional;


import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.model.Cause;
import org.springframework.samples.petclinic.model.Donation;
import org.springframework.samples.petclinic.repository.DonationRepository;
import org.springframework.samples.petclinic.service.exceptions.CauseCloseException;
import org.springframework.stereotype.Service;

@Service
public class DonationService {

    private DonationRepository donationRepo;
    private UserService userService;
    private CauseService causeService;

    @Autowired
    public DonationService(DonationRepository donationRepo, UserService userService, CauseService causeService){
        this.donationRepo = donationRepo;
        this.userService = userService;
        this.causeService = causeService;
    }

    @Transactional
    public void save(Donation donation) throws DataAccessException, CauseCloseException {
        if(!donation.getCause().getIsOpen()){
            throw new CauseCloseException();
        }
        donationRepo.save(donation);
        Cause cause = causeService.findById(donation.getCause().getId()).get();
        cause.getDonations().add(donation);
 
        if(causeService.calculateCauseTotalBudget(cause)>=cause.getBudgetTarget()){
            cause.setIsOpen(false);
        }
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
