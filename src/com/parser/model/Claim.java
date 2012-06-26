package com.parser.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shubhambansal
 * The model object for storing a claim information
 *
 */
public class Claim {
	
	private String insuranceProvider;
	private List<ServiceInformation> serviceInformations = new ArrayList<ServiceInformation>();
	
	public Claim() {}
	
	public Claim(String insuranceProvider) {
		this.insuranceProvider = insuranceProvider;
	}

	public String getInsuranceProvider() {
		return insuranceProvider;
	}

	public void setInsuranceProvider(String insuranceProvider) {
		this.insuranceProvider = insuranceProvider;
	}

	public List<ServiceInformation> getServiceInformations() {
		return serviceInformations;
	}

	public void setServiceInformations(List<ServiceInformation> serviceInformations) {
		this.serviceInformations = serviceInformations;
	}

	@Override
	public String toString() {
		return "Claim [insuranceProvider=" + insuranceProvider
				+ ", serviceInformations=" + serviceInformations + "]";
	}

	public String printSummary() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("Insurance - " + insuranceProvider).append("\n");
		for (ServiceInformation info : serviceInformations) {
			buffer.append(info.toString());
		}
		return buffer.toString();
	}
	
}
