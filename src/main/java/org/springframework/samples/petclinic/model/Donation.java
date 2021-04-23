package org.springframework.samples.petclinic.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;



@Entity
@Table(name ="donations")
public class Donation extends BaseEntity{
    
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate date;

    private Double amount;

    @ManyToOne
    @JoinColumn(name = "username")
    private User client;

    @ManyToOne
    @JoinColumn(name = "name")
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
