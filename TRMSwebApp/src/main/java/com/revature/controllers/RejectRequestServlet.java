package com.revature.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.util.RequestProcessor;

public class RejectRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesh = request.getSession();
		String user = (String)sesh.getAttribute("user");
		String reason = request.getParameter("reason");
		int requestId = Integer.parseInt(request.getParameter("reimbId"));
		
		System.out.println(reason);
		RequestProcessor rp = RequestProcessor.getInstance();
		rp.handleApproveOrDenyRequest(requestId, user, reason, false);
		
	}
}
