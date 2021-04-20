package org.springframework.samples.petclinic.service;

import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.model.Cause;
import org.springframework.samples.petclinic.repository.CauseRepository;
import org.springframework.stereotype.Service;

@Service
public class CauseService {
	
	private CauseRepository causeRepository;	
	
	public void saveCause(Cause cause) throws DataAccessException {
		//creating owner
		causeRepository.save(cause);		
		
	}

}
