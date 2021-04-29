package org.springframework.samples.petclinic.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "adoption_applications")
public class AdoptionApplication extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "adoption_request_id")
    AdoptionRequest adoptionRequest;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    Owner applicant;

    String description;

    public AdoptionRequest getAdoptionRequest() {
        return adoptionRequest;
    }

    public void setAdoptionRequest(AdoptionRequest adoptionRequest) {
        this.adoptionRequest = adoptionRequest;
    }

    public Owner getApplicant() {
        return applicant;
    }

    public void setApplicant(Owner applicant) {
        this.applicant = applicant;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    
}
