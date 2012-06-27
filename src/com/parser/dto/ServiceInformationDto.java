package com.parser.dto;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.parser.model.Procedure;
import com.parser.model.ServiceInformation;

@XmlRootElement
@XmlAccessorType(XmlAccessType.PROPERTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ServiceInformationDto {
	
	private String totalAmountBilled;
	private String totalNotCovered;
	private String totalCovered;
	private String ppoReduction;
	private String coinsuranceAmount;
	private String totalDeductions;
	private String totalBenefitsApproved;
	private String amountOwedToProvider;
	
	private List<ProcedureDto> procedures = new ArrayList<ProcedureDto>();
	
	protected ServiceInformationDto() {
	}
	
	public ServiceInformationDto(ServiceInformation serviceInformation) {
		this.totalAmountBilled = checkString(serviceInformation.getTotalAmountBilled());
		this.totalNotCovered = checkString(serviceInformation.getTotalNotCovered());
		this.totalCovered = checkString(serviceInformation.getTotalCovered());
		this.ppoReduction = checkString(serviceInformation.getPpoReduction());
		this.coinsuranceAmount = checkString(serviceInformation.getPpoReduction());
		this.totalDeductions = checkString(serviceInformation.getTotalDeductions());
		this.totalBenefitsApproved = checkString(serviceInformation.getTotalBenefitsApproved());
		this.amountOwedToProvider = checkString(serviceInformation.getAmountOwedToProvider());
		
		for (Procedure procedure : serviceInformation.getProcedures()) {
			ProcedureDto procedureDto = new ProcedureDto(procedure);
			procedures.add(procedureDto);
		}
	}
	
	private String checkString(Object value) {
		if(value == null) {
			return null;
		}
		return value.toString();
	}

	public String getTotalAmountBilled() {
		return totalAmountBilled;
	}

	public void setTotalAmountBilled(String totalAmountBilled) {
		this.totalAmountBilled = totalAmountBilled;
	}

	public String getTotalNotCovered() {
		return totalNotCovered;
	}

	public void setTotalNotCovered(String totalNotCovered) {
		this.totalNotCovered = totalNotCovered;
	}

	public String getTotalCovered() {
		return totalCovered;
	}

	public void setTotalCovered(String totalCovered) {
		this.totalCovered = totalCovered;
	}

	public String getPpoReduction() {
		return ppoReduction;
	}

	public void setPpoReduction(String ppoReduction) {
		this.ppoReduction = ppoReduction;
	}

	public String getCoinsuranceAmount() {
		return coinsuranceAmount;
	}

	public void setCoinsuranceAmount(String coinsuranceAmount) {
		this.coinsuranceAmount = coinsuranceAmount;
	}

	public String getTotalDeductions() {
		return totalDeductions;
	}

	public void setTotalDeductions(String totalDeductions) {
		this.totalDeductions = totalDeductions;
	}

	public String getTotalBenefitsApproved() {
		return totalBenefitsApproved;
	}

	public void setTotalBenefitsApproved(String totalBenefitsApproved) {
		this.totalBenefitsApproved = totalBenefitsApproved;
	}

	public String getAmountOwedToProvider() {
		return amountOwedToProvider;
	}

	public void setAmountOwedToProvider(String amountOwedToProvider) {
		this.amountOwedToProvider = amountOwedToProvider;
	}

	public List<ProcedureDto> getProcedures() {
		return procedures;
	}

	public void setProcedures(List<ProcedureDto> procedures) {
		this.procedures = procedures;
	}

}
