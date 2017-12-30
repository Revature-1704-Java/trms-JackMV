package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.sql.Date;

import com.revature.beans.Reimbursement;
import com.revature.util.ConnectionUtil;

public class ReimbursementDAO {
	public ArrayList<Reimbursement> getAllReimbursements(String employeeId) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
		
		int empId;
		int eventTypeId;
		String description;
		String location;
		String justification;
		Time eventStartDate;
		int gradeFmtId;
		double eventCost;
		double reimbursementAmount;
		Time requestSubmissionDate;
		int workTimeMissed;
		int approvalStatus;
		String additionalComments;
		
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM REIMBURSMENT WHERE EMPLOYEE_ID = ?";
			ps= conn.prepareStatement(sql);
			ps.setString(1, employeeId);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				empId = rs.getInt("EMPLOYEE_ID");
				eventTypeId = rs.getInt("EVENTTYPE_ID");
				description = rs.getString("DESCRIPTION");
				location = rs.getString("LOCATION");
				justification = rs.getString("JUSTIFICATION");
				eventStartDate = rs.getTime("EVENT_START_DATE");
				gradeFmtId = rs.getInt("GRADE_FMT_ID");
				eventCost = rs.getDouble("COST");
				reimbursementAmount = rs.getDouble("AMT_REIMBURSED");
				requestSubmissionDate = rs.getTime("DATE_SUBMITTED");
				workTimeMissed = rs.getInt("WORK_DAYS_MISSED");
				approvalStatus = rs.getInt("APPROVAL_STATUS");
				additionalComments = rs.getString("ADDITIONAL_NOTES");
				
				reimbursements.add(new Reimbursement(empId, eventTypeId, description, location, justification, eventStartDate, gradeFmtId, eventCost, reimbursementAmount, requestSubmissionDate, workTimeMissed, approvalStatus, additionalComments));
			}
			
			return reimbursements;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return reimbursements;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return reimbursements;
		}
	}
	
	public void newReimbursementRequest(int employeeId, int eventType, String desc, String loc, String justi, Date startDate, int gradeFmt, double cost, double amtReimbursed, int daysMissed, String comments) {
		PreparedStatement ps = null;
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "INSERT INTO REIMBURSEMENT (EMPLOYEE_ID, EVENTTYPE_ID, DESCRIPTION, "
					+ "LOCATION, JUSTIFICATION, EVENT_START_DATE, GRADE_FMT_ID, COST, AMT_REIMBURSED, "
					+ "DATE_SUBMITTED, WORK_DAYS_MISSED, APPROVAL_STATUS, ADDITIONAL_NOTES) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, employeeId);
			ps.setInt(2, eventType);
			ps.setString(3, desc);
			ps.setString(4, loc);
			ps.setString(5, justi);
			ps.setDate(6, startDate);
			ps.setInt(7, gradeFmt);
			ps.setDouble(8, cost);
			ps.setDouble(9, amtReimbursed);
			ps.setDate(10, getSqlTimestamp());
			ps.setInt(11, daysMissed);
			ps.setInt(12, 0);
			ps.setString(13, comments);
			ps.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static Date getSqlTimestamp() {
		java.util.Date today = new java.util.Date();
		return new Date(today.getTime());
	}
}
