package com.revature.controllers;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SubmitReimbursementRequestServlet
 */
public class SubmitReimbursementRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesh = request.getSession();
		
		
		double decimalCost;
		int gradeFormatId;
		int eventTypeId;
		String requesterInfo = (String) sesh.getAttribute("user");
		
		
		String eventStartDate = request.getParameter("eventStartDate");
		String eventStartTime = request.getParameter("eventStartTime");
		String eventLocation = request.getParameter("eventLocation");
		String eventDescription = request.getParameter("eventDescription");
		String eventCost = request.getParameter("eventCost");
		String gradeFormat = request.getParameter("gradeFormat");
		String eventType = request.getParameter("eventType");
		String workReason = request.getParameter("workReason");
		//TODO: handle attachments + time missed (the optional info)
		
		//May have to add seconds depending on if jdbc makes my life easier or not
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date startDateAndTime = null;
		try {
			startDateAndTime = df.parse(eventStartDate + " " + eventStartTime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		decimalCost = Integer.parseInt(eventCost);
		
		
		
	}

}
