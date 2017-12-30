package com.revature.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.util.RequestProcessor;

/**
 * Servlet implementation class LoginRequestServlet
 */
public class LoginRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginRequestServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("requestType", "login");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesh = request.getSession();
		String username = request.getParameter("employeeID");
		String password = request.getParameter("employeePassword");

		RequestProcessor rp = RequestProcessor.getInstance();
		String userJson = rp.processLoginRequest(username, password);
		if (!userJson.equals("null")) {
			sesh.setAttribute("user", userJson);
			response.sendRedirect("index.html");
		} else {
			response.sendRedirect("login.html");
		}
	}

}
