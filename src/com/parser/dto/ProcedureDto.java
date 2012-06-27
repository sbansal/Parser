package com.parser.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.parser.model.Procedure;

@XmlRootElement
@XmlAccessorType(XmlAccessType.PROPERTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProcedureDto {
	
	private String procedureName;
	private String serviceDate;
	private String amountBilled;
	private String amountCovered;
	private String amountNotCovered;
	
	public ProcedureDto() {
	}
	
	public ProcedureDto(Procedure procedure) {
		this.procedureName = procedure.getName();
		this.serviceDate = procedure.getServiceDate();
		this.amountBilled = procedure.getAmountBilled();
		this.amountCovered = procedure.getAmountCovered();
		this.amountNotCovered = procedure.getAmountNotCovered();
	}

	public String getProcedureName() {
		return procedureName;
	}

	public void setProcedureName(String procedureName) {
		this.procedureName = procedureName;
	}

	public String getServiceDate() {
		return serviceDate;
	}

	public void setServiceDate(String serviceDate) {
		this.serviceDate = serviceDate;
	}

	public String getAmountBilled() {
		return amountBilled;
	}

	public void setAmountBilled(String amountBilled) {
		this.amountBilled = amountBilled;
	}

	public String getAmountCovered() {
		return amountCovered;
	}

	public void setAmountCovered(String amountCovered) {
		this.amountCovered = amountCovered;
	}

	public String getAmountNotCovered() {
		return amountNotCovered;
	}

	public void setAmountNotCovered(String amountNotCovered) {
		this.amountNotCovered = amountNotCovered;
	}
	
	
}
