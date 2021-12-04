package com.teamfour.capstoneprojectdbs.beans;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Getter
@Setter
@ToString
public class Instrument {
    @Id
    String instrumentId;
    
    @NotNull
    String instrumentName;

    Double faceValue;

    @Temporal(TemporalType.TIMESTAMP)
    Date expiryDate;

    @NotNull
    Integer minQuantity;
    public Instrument() {
    	
    }
    public Instrument(String instrumentId, @NotNull String instrumentName, Double faceValue, Date expiryDate,
			@NotNull Integer minQuantity) {
		super();
		this.instrumentId = instrumentId;
		this.instrumentName = instrumentName;
		this.faceValue = faceValue;
		this.expiryDate = expiryDate;
		this.minQuantity = minQuantity;
	}

	public String getInstrumentId() {
		return instrumentId;
	}

	public void setInstrumentId(String instrumentId) {
		this.instrumentId = instrumentId;
	}

	public String getInstrumentName() {
		return instrumentName;
	}

	public void setInstrumentName(String instrumentName) {
		this.instrumentName = instrumentName;
	}

	public Double getFaceValue() {
		return faceValue;
	}

	public void setFaceValue(Double faceValue) {
		this.faceValue = faceValue;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public Integer getMinQuantity() {
		return minQuantity;
	}

	public void setMinQuantity(Integer minQuantity) {
		this.minQuantity = minQuantity;
	}

	
}
