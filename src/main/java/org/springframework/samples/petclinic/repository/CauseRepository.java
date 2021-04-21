package org.springframework.samples.petclinic.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.samples.petclinic.model.Cause;
import org.springframework.stereotype.Repository;

@Repository
public interface CauseRepository extends CrudRepository<Cause, String> {

    @Query("SELECT cause FROM Cause cause WHERE cause.id =:id")
    Cause findById(@Param("id") int id); 
}
