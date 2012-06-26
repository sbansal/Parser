package com.parser.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ClaimDto {

	private String providerName;
	
	public ClaimDto() {}
	
	public ClaimDto(String provider) {
		this.providerName = provider;
	}

	public String getProviderName() {
		return providerName;
	}

	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}
	
}
