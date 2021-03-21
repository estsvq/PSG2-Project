package org.springframework.samples.petclinic.service;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Reservation;
import org.springframework.samples.petclinic.repository.ReservationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReservationService {
    private ReservationRepository resRepository;

    @Autowired
    public ReservationService(ReservationRepository resRepository){
        this.resRepository = resRepository;
    }

    @Transactional
    public <S extends Reservation> S saveReservation(S entity) {
        return resRepository.save(entity);
    }
    
    @Transactional(readOnly = true)
    public Optional<Reservation> findReservationById(String id) {
        return resRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public Iterable<Reservation> findAllReservations() {
        return resRepository.findAll();
    }

    @Transactional(readOnly = true)
    public long countReservations() {
        return resRepository.count();
    }

    @Transactional
    public void deleteReservation(Reservation entity) {
        resRepository.delete(entity);
    }

    
}
