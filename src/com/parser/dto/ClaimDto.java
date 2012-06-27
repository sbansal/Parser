package com.parser.dto;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.parser.model.Claim;
import com.parser.model.ServiceInformation;

@XmlRootElement
@XmlAccessorType(XmlAccessType.PROPERTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ClaimDto {

	private String insuranceProvider;
	private List<ServiceInformationDto> serviceInformations = new ArrayList<ServiceInformationDto>();
	
	public ClaimDto() {}
	
	public ClaimDto(Claim claim) {
		this.insuranceProvider = claim.getInsuranceProvider();
		for (ServiceInformation serviceInformation : claim.getServiceInformations()) {
			ServiceInformationDto serviceDto = new ServiceInformationDto(serviceInformation);
			serviceInformations.add(serviceDto);
		}
	}

	public String getInsuranceProvider() {
		return insuranceProvider;
	}

	public void setInsuranceProvider(String insuranceProvider) {
		this.insuranceProvider = insuranceProvider;
	}

	public List<ServiceInformationDto> getServiceInformations() {
		return serviceInformations;
	}

	public void setServiceInformations(List<ServiceInformationDto> serviceInformations) {
		this.serviceInformations = serviceInformations;
	}
	
}
