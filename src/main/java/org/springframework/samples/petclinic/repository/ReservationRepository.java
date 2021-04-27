package org.springframework.samples.petclinic.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.samples.petclinic.model.Reservation;

public interface ReservationRepository extends CrudRepository<Reservation,String> {
    
	List<Reservation> findByPetId(Integer petId);
}
