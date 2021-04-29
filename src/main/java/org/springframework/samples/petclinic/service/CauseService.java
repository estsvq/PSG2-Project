package org.springframework.samples.petclinic.service;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.model.Cause;
import org.springframework.samples.petclinic.model.Donation;
import org.springframework.samples.petclinic.repository.CauseRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CauseService {
	
	private CauseRepository causeRepository;	

	@Autowired
	public CauseService(CauseRepository causeRepository) {
		this.causeRepository = causeRepository;
	}
	@Transactional
	public void saveCause(Cause cause) throws DataAccessException {
		//creating owner
		causeRepository.save(cause);		
		
	}

	@Transactional(readOnly = true)
	public Optional<Cause> findById(int id) {
		return causeRepository.findById(id);
	}

	@Transactional(readOnly = true)
	public Iterable<Cause> findAll() {
		return causeRepository.findAll();
	}

	@Transactional(readOnly = true)
	public Double calculateCauseTotalBudget(Cause cause) {
		Set<Donation> donations = cause.getDonations();
		Double totalBudget = 0.0;
		for(Donation donation: donations) {
			totalBudget += donation.getAmount();
		}
		return totalBudget;
	}
}
