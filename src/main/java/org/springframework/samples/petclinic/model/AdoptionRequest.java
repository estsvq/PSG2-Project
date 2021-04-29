package org.springframework.samples.petclinic.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "adoption_request")
public class AdoptionRequest extends BaseEntity {

    @NotNull
    @OneToOne(mappedBy = "adoptionRequest", cascade = CascadeType.ALL, fetch = FetchType.EAGER ,optional = false)
    private Pet pet;

    @NotNull
    private String description;

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Pet getPet() {
        return this.pet;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

}
