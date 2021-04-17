package org.springframework.samples.petclinic.service;

import java.util.Optional;

import org.springframework.samples.petclinic.model.Cause;
import org.springframework.stereotype.Service;

@Service
public class CauseService {
    
    public Optional<Cause> getCauseById(int id) {
        //TODO Implement read operation when Cause repository is done
        return Optional.empty();
    }
}
