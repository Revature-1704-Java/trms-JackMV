package com.revature.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.revature.beans.Employee;
import com.revature.beans.Reimbursement;
import com.revature.dao.EmployeeDAO;
import com.revature.dao.EventTypeDAO;
import com.revature.dao.GradeFormatDAO;
import com.revature.dao.ReimbursementDAO;


public class RequestProcessor {
	private static RequestProcessor rp;
	private EmployeeDAO empDao;
	private ReimbursementDAO reimDao;
	private EventTypeDAO eventTypeDao;
	private GradeFormatDAO gradeFmtDao;
	
	private HashMap<String, Integer> gradeFormats = null;
	private HashMap<Integer, Double> reimbursementPercentages = null;
	
	private RequestProcessor() {
		empDao = new EmployeeDAO();
		reimDao = new ReimbursementDAO();
		eventTypeDao = new EventTypeDAO();
		gradeFmtDao = new GradeFormatDAO();
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
	
	public void submitNewReimbursementRequest(String requesterInfo, Date startDate, String location, String description, String justification, double cost, String gradeFormat, String eventType) {
		//first lets get the info from the json object
		int eventTypeId;
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
		
		switch (eventType) {
			case "University Course" :
				eventTypeId = 1;
				break;
			case "Seminar" :
				eventTypeId = 2;
				break;
			case "Certification Prep" :
				eventTypeId = 3;
				break;
			case "Certification" :
				eventTypeId = 4;
				break;
			case "Technical Training" :
				eventTypeId = 5;
				break;
			case "Other" :
				eventTypeId = 6;
				break;
			default:
				eventTypeId = 0;
				break;
		}
		//calculate amount reimbursed here. ignore the reimbursement cap for now
		
		if (reimbursementPercentages == null) {
			reimbursementPercentages = eventTypeDao.getReimbursementPercentages();
		}
		
		if (gradeFormats == null) {
			gradeFormats = gradeFmtDao.getGradeFormats();
		}
		
		int rowsAdded = reimDao.newReimbursementRequest(user.getEmpId(), eventTypeId, description, location, justification, new java.sql.Date(startDate.getTime()), gradeFormats.get(gradeFormat), cost, cost * reimbursementPercentages.get(eventTypeId), 0);
		System.out.println(rowsAdded);
	}
	
	public ArrayNode viewSubmittedReimbursementRequests(String employeeInfo) throws JsonProcessingException {
		
		ObjectMapper mapper = new ObjectMapper();
		ArrayNode jsonReimbursements = mapper.createArrayNode();
		Employee user = null;
		try {
			user = mapper.readValue(employeeInfo, Employee.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<Employee> allSubordinates = new ArrayList<Employee>();
		switch (user.getEmpType()) {
		case 1:
			//supervisor
			allSubordinates.addAll(empDao.getSubordinates(user.getEmpId() + ""));
			allSubordinates.add(user);
			break;
		case 2:
			//dept head
			allSubordinates.addAll(empDao.getDepartment(user.getEmpId() + ""));
			allSubordinates.add(user);
			break;
		case 3:
			//benco
			allSubordinates.addAll(empDao.getAll());
			break;
		}
		
		ArrayList<Reimbursement> reimbursements;
		JsonNode jsonReimbursement;
		
		//Get all of the user's reimbursement requests
		for(int i = 0; i < allSubordinates.size(); i++) {
			reimbursements = reimDao.getUsersReimbursements(allSubordinates.get(i).getEmpId());
			for (int j = 0; j < reimbursements.size(); j++) {
				jsonReimbursement = mapper.valueToTree(reimbursements.get(j));
				jsonReimbursements.add(jsonReimbursement);
			}
		}
		
		return jsonReimbursements;
	
	}
	
	public int handleApproveOrDenyRequest(int requestId, String userInfo, String reason, boolean approvalRequest) {
		ObjectMapper mapper = new ObjectMapper();
		int approvalLevel = -1;
		if (approvalRequest) {
			try {
				approvalLevel = mapper.readValue(userInfo, Employee.class).getEmpType();
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
		}
		
		return reimDao.updateApproval(requestId, approvalLevel, reason);
	}
	
}
