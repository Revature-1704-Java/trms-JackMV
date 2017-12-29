package com.revature.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Employee;
import com.revature.dao.EmployeeDAO;


public class RequestProcessor {
	private static RequestProcessor rp;
	private EmployeeDAO empDao;
	
	private RequestProcessor() {
		empDao = new EmployeeDAO();
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
}
