package org.springframework.samples.petclinic.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.samples.petclinic.model.Cause;


public interface CauseRepository extends CrudRepository<Cause, Integer> {
    
    @Query("SELECT cause FROM Cause cause WHERE cause.id =:id")
	public Cause findById(@Param("id") int id);

}
