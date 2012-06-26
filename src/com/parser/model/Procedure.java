package com.parser.model;


public class Procedure {
	
	private String name;
	private String serviceDate;
	private String amountBilled;
	private String amountCovered;
	private String amountNotCovered;
	
	public Procedure(String procedureName, String serviceDate,String amountBilled,
			String amountNotCovered, String amountCovered) {
		this.name = procedureName;
		this.serviceDate = serviceDate;
		this.amountBilled = amountBilled;
		this.amountNotCovered = amountNotCovered;
		this.amountCovered = amountCovered;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("\n");
		builder.append("Procedure Name : ");
		builder.append(name);
		builder.append(", Service Date : ");
		builder.append(serviceDate);
		builder.append(", Amount Billed : ");
		builder.append(amountBilled);
		builder.append(", Amount Covered : ");
		builder.append(amountCovered);
		builder.append(", Amount Not Covered : ");
		builder.append(amountNotCovered);
		return builder.toString();
	}

	

}
