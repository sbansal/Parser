package com.parser.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ListOfProceduresDto {
	
	private List<ProcedureDto> procedures;
	
	protected ListOfProceduresDto() {
	}
	
	public ListOfProceduresDto(List<ProcedureDto> procedures) {
		this.procedures = procedures;
	}

	public List<ProcedureDto> getProcedures() {
		return procedures;
	}

	public void setProcedures(List<ProcedureDto> procedures) {
		this.procedures = procedures;
	}
	
	
}
