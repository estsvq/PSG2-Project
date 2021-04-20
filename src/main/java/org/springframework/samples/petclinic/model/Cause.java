package org.springframework.samples.petclinic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "causes")
public class Cause {

	@Column(name = "name")
	@NotEmpty
	@Id
	private String name;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "budget_target")	
	private Double budgetTarget;
	
	@Column(name = "act_non_prof_org")	
	private String actNonProfOrg;
	
	@Column(name = "is_open")	
	private Boolean isOpen;

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

	@Override
	public String toString() {
		return "Cause [name=" + name + ", description=" + description + ", budgetTarget=" + budgetTarget
				+ ", actNonProfOrg=" + actNonProfOrg + ", isOpen=" + isOpen + "]";
	}
	

	
	
	
}
