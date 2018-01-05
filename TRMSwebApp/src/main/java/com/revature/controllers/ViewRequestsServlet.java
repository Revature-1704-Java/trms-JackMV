package com.revature.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.revature.util.RequestProcessor;

/**
 * Servlet implementation class ViewRequestsServlet
 */
public class ViewRequestsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesh = request.getSession();
		RequestProcessor rp = RequestProcessor.getInstance();
		String userInfo = (String) sesh.getAttribute("user");

		ArrayNode myReimbursements = rp.viewSubmittedReimbursementRequests(userInfo);
		System.out.println(myReimbursements.toString());

		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		PrintWriter data = response.getWriter();
		data.print(myReimbursements.toString());
		data.flush();
		data.close();

	}

}
