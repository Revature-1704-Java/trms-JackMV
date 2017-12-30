package com.revature.util;

import java.io.IOException;
import java.util.Date;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Employee;
import com.revature.dao.EmployeeDAO;
import com.revature.dao.ReimbursementDAO;


public class RequestProcessor {
	private static RequestProcessor rp;
	private EmployeeDAO empDao;
	private ReimbursementDAO reimDao;
	
	private RequestProcessor() {
		empDao = new EmployeeDAO();
		reimDao = new ReimbursementDAO();
	}
	
	public static RequestProcessor getInstance() {
		if (rp == null) {
			rp = new RequestProcessor();
		} 
		return rp;
	}
	
	public String processLoginRequest(String username, String password) throws JsonProcessingException {
		//maybe parse the employee into a JSON object here to pass back to the web side of things
		ObjectMapper mapper = new ObjectMapper();
		Employee currentUser = empDao.verifyLogin(username, password);
		return mapper.writeValueAsString(currentUser);
		
	}
	
	public void submitNewReimbursementRequest(String requesterInfo, Date startDate, String location, String description, String justification, double cost, int gradeFormat, int eventType, String reason) {
		//first lets get the info from the json object
		ObjectMapper mapper = new ObjectMapper();
		Employee user = null;
		try {
			user = mapper.readValue(requesterInfo, Employee.class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//calculate amount reimbursed here. ignore the reimbursment cap for now
		reimDao.newReimbursementRequest(user.getEmpId(), eventType, description, location, justification, startDate, gradeFormat, cost, amtReimbursed, 0, "");
	}
}
