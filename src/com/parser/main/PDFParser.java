package com.parser.main;

import com.parser.controller.ParsingController;

public class PDFParser {
	public static void main(String[] args) {
		try {
			String fileName = "/Users/shubhambansal/Downloads/cancer.pdf";
//			String fileName = "/Users/shubhambansal/Downloads/mammogram.pdf";
//			String fileName = "/Users/shubhambansal/Downloads/physical.pdf";
			long time = System.currentTimeMillis();
			ParsingController controller = new ParsingController();
			controller.parse(fileName);
			System.out.println("Time taken - " + (System.currentTimeMillis() - time) + " ms");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}