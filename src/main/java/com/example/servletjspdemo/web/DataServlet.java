package com.example.servletjspdemo.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/data")
public class DataServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();

		String firstName = "";
		if(request.getParameter("firstName").matches("[A-Z]?[a-z]+$")){
			firstName = request.getParameter("firstName");
		} else {
			firstName = "ERROR";
		}

		String lastName = "";
		if(request.getParameter("lastName").matches("[A-Z]?[a-z]+$")){
			lastName = request.getParameter("lastName");
		} else {
			lastName = "ERROR";
		}

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
		LocalDate localDate = LocalDate.now();
		LocalDate birthDate = LocalDate.parse(request.getParameter("birthDate"));
		String age = "";
		if ( birthDate.isBefore(localDate)){
			Period period = Period.between(LocalDate.parse(request.getParameter("birthDate")),localDate);
			age = String.valueOf(period.getYears());
		} else {
			age = "ERROR";
		}

		String phoneNumber = "";
		if (request.getParameter("phoneNumber").matches("^[0-9]+$")) {
			phoneNumber = request.getParameter("phoneNumber");
		} else {
			phoneNumber = "ERROR";
		}

		String selectedHobby = "";
		for (String hobby : request.getParameterValues("hobby")) {
			selectedHobby += hobby + " ";
		}

		String selectedLanguages = "";
		for (String language : request.getParameterValues("language")) {
			selectedLanguages += language + " ";
		}


		if (request.getParameter("acc") != null) {
			out.println("<html><body><h2>Your data</h2>" +
					"<p>First name: " + firstName + "<br />" +
					"<p>Last name: " + lastName + "<br />" +
					"<p>Age: " + age + "<br />" +
					"<p>Sex: " + request.getParameter("sex") + "<br />" +
					"<p>Phone number: " + phoneNumber + "<br />" +
					"<p>Your hobby: " + selectedHobby + "<br />" +
					"<p>Your description: " + request.getParameter("info") + "<br />" +
					"<p>Languages: " + selectedLanguages + "<br />" +
					"</body></html>");
		} else {
			out.println("<html><body><h2>You did not accept to the Terms and Conditions</h2></body></html>");
		}
		out.close();
	}

}
