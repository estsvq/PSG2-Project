package org.springframework.samples.petclinic.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "reservations")
public class Reservation extends BaseEntity{
    
    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;

    @Column(name = "start_date")
    @FutureOrPresent
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private LocalDate startDate;

    @Column(name = "finnish_date")
    @Future
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private LocalDate finnishDate;


    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getFinnishDate() {
        return finnishDate;
    }

    public void setFinnishDate(LocalDate finnishDate) {
        this.finnishDate = finnishDate;
    }

    

}
