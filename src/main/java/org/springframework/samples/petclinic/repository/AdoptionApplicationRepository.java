package org.springframework.samples.petclinic.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.samples.petclinic.model.AdoptionApplication;

public interface AdoptionApplicationRepository extends CrudRepository<AdoptionApplication, Integer> {

    @Query("SELECT a FROM AdoptionApplication a JOIN a.applicant ap JOIN a.adoptionRequest ar WHERE ap.id = :ownerId AND ar.id = :adoptionId")
    AdoptionApplication findAdoptionApplicationByOwnerAndRequest(@Param("ownerId") Integer ownerId,
            @Param("adoptionId") Integer adoptionId);
}
