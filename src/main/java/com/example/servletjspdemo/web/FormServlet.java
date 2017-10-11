package com.example.servletjspdemo.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/form")
public class FormServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		out.println("<html><body><h2>Introduce yourself</h2>" +
				"<form action='data'>" +
				"First name: <input type='text' name='firstName' /> <br />" +

				"Last name: <input type='text' name='lastName' /> <br />" +

				"Birth date: <input type='date' name='birthDate'/> <br />" +

				"Phone number: <input type='text' name='phoneNumber''/> <br />" +

				"Sex: <select name='sex'>" +
				"	<option value='male'>Male</option>" +
				"	<option value='female'>Female</option>" +
				"</select> <br /><br />" +

				"What is your hobby?<br /><input type='checkbox' name='hobby' value='bicycle'>I like riding a bicycle<br />" +
				"<input type='checkbox' name='hobby' value='tv'>I like watching TV<br />" +
				"<input type='checkbox' name='hobby' value='beer'>I like dringking beer<br />" +
				"<input type='checkbox' name='hobby' value='books'>I like reading books<br /><br />" +
				
				"<input type='textarea' name='info' value='Tell something about you'><br /><br />" +
				
				"Choose programming languages which you know:<br /><select name='language' multiple>" +
				"    <option value='java'>Java</option>" +
				"    <option value='c'>C</option>" +
				"    <option value='c#'>C#</option>" +
				"    <option value='python'>Python</option>" +
				"</select><br /><br />" +
				
				"<input type='radio' name='acc' value='radio'>I agree to the Terms and Conditions<br />" +
				
				"<input type='submit' value=' OK ' />" +
				"</form>" +
				"</body></html>");
		out.close();
	}

}
