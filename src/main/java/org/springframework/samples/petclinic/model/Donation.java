package org.springframework.samples.petclinic.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.springframework.format.annotation.DateTimeFormat;



@Entity
@Table(name ="donations")
public class Donation extends BaseEntity{
    
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    @NotNull
    private LocalDate date;

    @Positive
    @NotNull
    private Double amount;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "username")
    private User client;

    @ManyToOne
    @JoinColumn(name = "cause_id")
    @NotNull
    private Cause cause;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public Cause getCause() {
        return cause;
    }

    public void setCause(Cause cause) {
        this.cause = cause;
    }

    
}
