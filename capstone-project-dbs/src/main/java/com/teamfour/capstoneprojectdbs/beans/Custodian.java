package com.teamfour.capstoneprojectdbs.beans;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@ToString
public class Custodian {
    @Id
    @NotNull
    String custodianId;

    
	@NotNull
    String custodianName;
    public Custodian() {
    	
    }
	public Custodian(@NotNull String custodianId, @NotNull String custodianName) {
		super();
		this.custodianId = custodianId;
		this.custodianName = custodianName;
	}
	public String getCustodianId() {
		return custodianId;
	}
	public void setCustodianId(String custodianId) {
		this.custodianId = custodianId;
	}
	public String getCustodianName() {
		return custodianName;
	}
	public void setCustodianName(String custodianName) {
		this.custodianName = custodianName;
	}
}
