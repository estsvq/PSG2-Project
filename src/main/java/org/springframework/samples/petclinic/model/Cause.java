package org.springframework.samples.petclinic.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Entity
@Table(name = "causes")
public class Cause extends BaseEntity{

	@Column(name = "name")
	@NotEmpty
	private String name;
	
	@Column(name = "description")
	@NotEmpty
	@Size(max = 200, min = 10)
	private String description;
	
	@Column(name = "budget_target")	
	@Positive
    @NotNull
	private Double budgetTarget;
	
	@Column(name = "act_non_prof_org")	
	@NotEmpty
	private String actNonProfOrg;
	
	@Column(name = "is_open")	
	private Boolean isOpen;

	@OneToMany(mappedBy = "cause", fetch = FetchType.EAGER)
    private Set<Donation> donations;

	@Transient
	private Double totalBudget; 
	
	public Double getTotalBudget() {
		return totalBudget;
	}

	public void setTotalBudget(Double totalBudget) {
		this.totalBudget = totalBudget;
	}

	public Cause() {
		super();
		this.setIsOpen(true);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getBudgetTarget() {
		return budgetTarget;
	}

	public void setBudgetTarget(Double budgetTarget) {
		this.budgetTarget = budgetTarget;
	}

	public String getActNonProfOrg() {
		return actNonProfOrg;
	}

	public void setActNonProfOrg(String actNonProfOrg) {
		this.actNonProfOrg = actNonProfOrg;
	}

	public Boolean getIsOpen() {
		return isOpen;
	}

	public void setIsOpen(Boolean isOpen) {
		this.isOpen = isOpen;
	}

	public Set<Donation> getDonations() {
		return donations;
	}

	public void setDonations(Set<Donation> donations) {
		this.donations = donations;
	}
	
	@Override
	public String toString() {
		return "Cause [name=" + name + ", description=" + description + ", budgetTarget=" + budgetTarget
				+ ", actNonProfOrg=" + actNonProfOrg + ", isOpen=" + isOpen + "]";
	}
	

	
	
	
}
