package com.parser.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ServiceInformation {

	private String providerName;
	private List<Procedure> procedures = new ArrayList<Procedure>();
	
	private BigDecimal totalAmountBilled;
	private BigDecimal totalNotCovered;
	private BigDecimal totalCovered;
	private BigDecimal ppoReduction;
	
	private BigDecimal coinsuranceAmount;
	private BigDecimal totalDeductions;
	private BigDecimal totalBenefitsApproved;
	private BigDecimal amountOwedToProvider;
	
	public ServiceInformation() {}
	
	public ServiceInformation(String provider) {
		this.providerName = provider;
	}

	public String getProviderName() {
		return providerName;
	}

	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}

	public List<Procedure> getProcedures() {
		return procedures;
	}

	public void setProcedures(List<Procedure> procedures) {
		this.procedures = procedures;
	}

	public void addProcedure(Procedure p) {
		procedures.add(p);
	}

	public BigDecimal getTotalAmountBilled() {
		return totalAmountBilled;
	}

	public void setTotalAmountBilled(BigDecimal totalAmountBilled) {
		this.totalAmountBilled = totalAmountBilled;
	}

	public BigDecimal getTotalNotCovered() {
		return totalNotCovered;
	}

	public void setTotalNotCovered(BigDecimal totalNotCovered) {
		this.totalNotCovered = totalNotCovered;
	}

	public BigDecimal getTotalCovered() {
		return totalCovered;
	}

	public void setTotalCovered(BigDecimal totalCovered) {
		this.totalCovered = totalCovered;
	}

	public BigDecimal getPpoReduction() {
		return ppoReduction;
	}

	public void setPpoReduction(BigDecimal ppoReduction) {
		this.ppoReduction = ppoReduction;
	}

	public BigDecimal getCoinsuranceAmount() {
		return coinsuranceAmount;
	}

	public void setCoinsuranceAmount(BigDecimal coinsuranceAmount) {
		this.coinsuranceAmount = coinsuranceAmount;
	}

	public BigDecimal getTotalDeductions() {
		return totalDeductions;
	}

	public void setTotalDeductions(BigDecimal totalDeductions) {
		this.totalDeductions = totalDeductions;
	}

	public BigDecimal getTotalBenefitsApproved() {
		return totalBenefitsApproved;
	}

	public void setTotalBenefitsApproved(BigDecimal totalBenefitsApproved) {
		this.totalBenefitsApproved = totalBenefitsApproved;
	}

	public BigDecimal getAmountOwedToProvider() {
		return amountOwedToProvider;
	}

	public void setAmountOwedToProvider(BigDecimal amountOwedToProvider) {
		this.amountOwedToProvider = amountOwedToProvider;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(providerName).append("\n");
		builder.append(", Total Procedures : ");
		builder.append(procedures.size()).append("\n");
		builder.append(procedures).append("\n");
		builder.append(", Total Amount Billed : ");
		builder.append(totalAmountBilled).append("\n");
		builder.append(", Total Not Covered : ");
		builder.append(totalNotCovered).append("\n");
		builder.append(", Total Covered : ");
		builder.append(totalCovered).append("\n");
		builder.append(", PPO Reduction : ");
		builder.append(ppoReduction).append("\n");
		builder.append(", Coinsurance Amount : ");
		builder.append(coinsuranceAmount).append("\n");
		builder.append(", Total Deductions : ");
		builder.append(totalDeductions).append("\n");
		builder.append(", Total Benefits Approved : ");
		builder.append(totalBenefitsApproved).append("\n");
		builder.append(", Amount Owed To Provider : ");
		builder.append(amountOwedToProvider).append("\n");
		return builder.toString();
	}

	

	
}
