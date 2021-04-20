package org.springframework.samples.petclinic.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "adoption_applications")
public class AdoptionApplication extends BaseEntity {

    // TODO Add relation @ManyToOne AdoptionRequest

    @ManyToOne
    @JoinColumn(name = "owner_id")
    Owner applicant;

    String description;
}
