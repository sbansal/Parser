package com.parser.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Dto object for storing a list of <code>ServiceInformationDto</code>
 * @author shubhambansal
 *
 */
@XmlRootElement
public class ListOfServiceInformationsDto {
	
	private List<ServiceInformationDto> serviceInformations;

	protected ListOfServiceInformationsDto() {
	}
	
	public ListOfServiceInformationsDto(List<ServiceInformationDto> serviceInformations) {
		this.serviceInformations = serviceInformations;
	}

	public List<ServiceInformationDto> getServiceInformations() {
		return serviceInformations;
	}

	public void setServiceInformations(
			List<ServiceInformationDto> serviceInformations) {
		this.serviceInformations = serviceInformations;
	}
	
}
