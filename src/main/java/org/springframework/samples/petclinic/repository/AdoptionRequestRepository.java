package org.springframework.samples.petclinic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.samples.petclinic.model.AdoptionRequest;
import org.springframework.stereotype.Repository;

@Repository
public interface AdoptionRequestRepository extends CrudRepository<AdoptionRequest, Integer> {

    @Query("SELECT a FROM AdoptionRequest a JOIN a.pet pet JOIN pet.owner owner WHERE owner.id = :ownerId")
    List<AdoptionRequest> findAdoptionsRequestByOwner(@Param("ownerId") Integer ownerId);



}
