package com.revature.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.util.RequestProcessor;

public class RequestProcessorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RequestProcessorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String reqType = (String) request.getAttribute("requestType");
		switch (reqType) {
		case "login":
			String username = request.getParameter("employeeID");
			String password = request.getParameter("employeePassword");
			RequestProcessor rp = RequestProcessor.getInstance();
			String json = rp.processLoginRequest(username, password);
			System.out.println(json);
			response.addHeader("user", json);
			
		}
	}
}
