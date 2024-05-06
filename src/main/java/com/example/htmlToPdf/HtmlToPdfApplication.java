package com.example.htmlToPdf;

import com.example.htmlToPdf.dto.PersonDTO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.*;
import java.util.Base64;

@SpringBootApplication
@RestController
public class HtmlToPdfApplication {

	public static void main(String[] args) {
		SpringApplication.run(HtmlToPdfApplication.class, args);
	}

	@PostMapping("/convert")
	public String convertHtmlToPdf(@RequestBody PersonDTO personDTO) {
		try {
			String htmlContent = loadHtmlContent("C:/Users/HP/Desktop/AMBLAPROJECt/hellocar/VelocityhtmlTemplateToPdf/src/main/resources/templates/invoice.html").trim();
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			htmlContent = replacePlaceholders(htmlContent,personDTO);

			// Generate PDF using Flying Saucer
			ITextRenderer renderer = new ITextRenderer();
			renderer.setDocumentFromString(htmlContent);
			renderer.layout();
			renderer.createPDF(outputStream);

			byte[] pdfBytes = outputStream.toByteArray();
			outputStream.close();

			return Base64.getEncoder().encodeToString(pdfBytes);
		} catch (Exception e) {
			e.printStackTrace();
			return "Error occurred during PDF generation: " + e.getMessage();
		}
	}

	private String loadHtmlContent(String htmlContentPath) throws IOException {
		// Read HTML content from file
		StringBuilder contentBuilder = new StringBuilder();
		try (BufferedReader br = new BufferedReader(new FileReader(htmlContentPath))) {
			String line;
			while ((line = br.readLine()) != null) {
				contentBuilder.append(line);
			}
		}
		return contentBuilder.toString();
	}

	private String replacePlaceholders(String htmlContent, PersonDTO person) {
		// Replace placeholders in the HTML content with data from the PersonDTO object
		htmlContent = htmlContent.replace("${name}", person.getName());
		htmlContent = htmlContent.replace("${phoneNumber}", person.getPhoneNumber());
		htmlContent = htmlContent.replace("${address}", person.getAddress());
		htmlContent = htmlContent.replace("${Date}", person.getEmail());
		htmlContent = htmlContent.replace("${sex}", person.getSex());
		htmlContent = htmlContent.replace("${doctorName}", person.getDoctorName());
		htmlContent = htmlContent.replace("${specialization}", person.getSpecialization());
		htmlContent = htmlContent.replace("${profession}", person.getProfession());

		return htmlContent;
	}
}
