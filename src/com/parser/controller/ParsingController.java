package com.parser.controller;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;

import com.parser.model.Claim;
import com.parser.model.Procedure;
import com.parser.model.ServiceInformation;

public class ParsingController {

	private static final String SERVICE_DATE_TOKEN = "Service Date";
	private static final String PPO_TOKEN = "Participating Provider Option (PPO Reduction)";
	public static final String SPACER = " ";
	private static final String TOTALS_TOKEN = "Totals";
//	private static final String DEDUCTIONS_TOKEN = "Deductions";
	private static final String COINSURANCE_TOKEN = "Your Coinsurance Amount";
	private static final String TOTAL_DEDUCTIONS_TOKEN = "Total Deductions";
	private static final String APPROVED_BENEFITS_TOKEN = "Total Benefits Approved";
	private static final String AMOUNT_OWED_TOKEN = "Amount You May Owe Provider";
	
	private static final String DATE_REGEX = "(\\d{2}-\\d{2}-\\d{2})";
	public static final String PRICE_REGEX = "($\\d+\\.\\d)";
	private static Pattern DATE_PATTERN = Pattern.compile(DATE_REGEX);
	public static Pattern PRICE_PATTERN = Pattern.compile(PRICE_REGEX);
	
	private static String[] unnecessaryStrings = new String[] {"(1) ", "$"};
	
	private Claim claim = new Claim();
	
	public void parse(String fileName) throws IOException, NoSuchElementException {
		PDDocument document = PDDocument.load(new File(fileName));
		PDFTextStripper parser = new PDFTextStripper();
		String text = parser.getText(document);
		System.out.println(text);
		List<ServiceInformation> serviceInformations = new ArrayList<ServiceInformation>();
		String insuranceName = null;
		
		StringTokenizer t = new StringTokenizer(text, parser.getLineSeparator());
		ServiceInformation service = null;
		while (t.hasMoreTokens()) {
			if(insuranceName == null) {
				insuranceName = t.nextToken().concat(SPACER).concat(t.nextToken());
				claim.setInsuranceProvider(insuranceName);
			}
			String nextToken = t.nextToken();
			if(nextToken.startsWith(SERVICE_DATE_TOKEN)) {
				service = new ServiceInformation();
				serviceInformations.add(service);
			} else if(service != null && service.getProviderName() == null) {
				service.setProviderName(nextToken);
			} else if(nextToken.startsWith(TOTALS_TOKEN)) {
				processTotals(nextToken, service);
			} else if(nextToken.startsWith(PPO_TOKEN)) {
				String ppoReduction = sanitizeString(nextToken.substring(PPO_TOKEN.length()).trim());
				service.setPpoReduction(new BigDecimal(ppoReduction));
			} else if(nextToken.startsWith(COINSURANCE_TOKEN)) {
				service.setCoinsuranceAmount(processAmount(nextToken, COINSURANCE_TOKEN));
			} else if(nextToken.startsWith(TOTAL_DEDUCTIONS_TOKEN)) {
				service.setTotalDeductions(processAmount(nextToken, TOTAL_DEDUCTIONS_TOKEN));
			} else if(nextToken.startsWith(APPROVED_BENEFITS_TOKEN)) {
				service.setTotalBenefitsApproved(processAmount(nextToken, APPROVED_BENEFITS_TOKEN));
			} else if(nextToken.startsWith(AMOUNT_OWED_TOKEN)) {
				service.setAmountOwedToProvider(processAmount(nextToken, AMOUNT_OWED_TOKEN));
			} else if(service != null && service.getTotalAmountBilled() == null) {
				//This needs to be the last loop
				Procedure p = addProcedure(nextToken);
				service.addProcedure(p);
			} 
		}
		claim.setServiceInformations(serviceInformations);
		System.out.println("Claim data - " + claim.printSummary());
	}
	
	private void processTotals(String nextToken, ServiceInformation service) {
		String priceString = nextToken.substring(TOTALS_TOKEN.length()); 
		String[] prices = priceString.trim().split(SPACER);
		if(prices.length > 2) {
			service.setTotalAmountBilled(new BigDecimal(sanitizeString(prices[0])));
			service.setTotalNotCovered(new BigDecimal(sanitizeString(prices[1])));
			service.setTotalCovered(new BigDecimal(sanitizeString(prices[2])));
		} else {
			service.setTotalAmountBilled(new BigDecimal(sanitizeString(prices[0])));
			service.setTotalCovered(new BigDecimal(sanitizeString(prices[1])));
		}
	}
	
	private BigDecimal processAmount(String lineItem, String token) {
		String priceString = lineItem.trim().substring(token.length());
		return new BigDecimal(sanitizeString(priceString));
	}

	private Procedure addProcedure(String lineItem) {
		String serviceDate = null;
		String procedureName = null;
		Procedure p = null;
		Matcher dateMatcher = DATE_PATTERN.matcher(lineItem);
		if(dateMatcher.find()) {
			serviceDate = dateMatcher.group();
		}
		if( serviceDate != null ) {
			procedureName = lineItem.substring(0, lineItem.indexOf(serviceDate));
			String priceString = lineItem.substring(lineItem.indexOf(serviceDate) + serviceDate.length()).trim();
			priceString = sanitizeString(priceString);
			StringTokenizer t = new StringTokenizer(priceString, SPACER);
			if(t.countTokens() > 2) {
				p  = new Procedure(procedureName, serviceDate, t.nextToken(), t.nextToken(), t.nextToken());
			} else {
				p = new Procedure(procedureName, serviceDate, t.nextToken(), null, t.nextToken());
			}
		}
		return p;
	}

	private String sanitizeString(String priceString) {
		for (String s : unnecessaryStrings) {
			priceString = priceString.replace(s, "");
		}
		return priceString.trim();
	}

	public Claim getClaim() {
		return claim;
	}
}
