package org.springframework.samples.petclinic.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "reservations")
public class Reservation extends BaseEntity{
    
	@NotNull
    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;

	@NotNull
    @Column(name = "start_date")
    @FutureOrPresent(message = "La fecha debe ser presente o futura")
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private LocalDate startDate;

	@NotNull
    @Column(name = "finnish_date")
    @Future(message = "La fecha debe ser futura")
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
