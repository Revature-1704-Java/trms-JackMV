package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;

import com.revature.beans.Reimbursement;
import com.revature.util.ConnectionUtil;

public class ReimbursementDAO {
	public ArrayList<Reimbursement> getUsersReimbursements(int employeeId) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
		
		int reimbId;
		int empId;
		int eventTypeId;
		String description;
		String location;
		String justification;
		Date eventStartDate;
		int gradeFmtId;
		double eventCost;
		double reimbursementAmount;
		Date requestSubmissionDate;
		int workTimeMissed;
		int approvalStatus;
		String additionalComments;
		
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM REIMBURSEMENT WHERE EMPLOYEE_ID = ?";
			ps= conn.prepareStatement(sql);
			ps.setInt(1, employeeId);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				reimbId = rs.getInt("REIMBURSEMENT_ID");
				empId = rs.getInt("EMPLOYEE_ID");
				eventTypeId = rs.getInt("EVENTTYPE_ID");
				description = rs.getString("DESCRIPTION");
				location = rs.getString("LOCATION");
				justification = rs.getString("JUSTIFICATION");
				eventStartDate = rs.getDate("EVENT_START_DATE");
				gradeFmtId = rs.getInt("GRADE_FMT_ID");
				eventCost = rs.getDouble("COST");
				reimbursementAmount = rs.getDouble("AMT_REIMBURSED");
				requestSubmissionDate = rs.getDate("DATE_SUBMITTED");
				workTimeMissed = rs.getInt("WORK_DAYS_MISSED");
				approvalStatus = rs.getInt("APPROVAL_STATUS");
				additionalComments = rs.getString("ADDITIONAL_NOTES");
				
				reimbursements.add(new Reimbursement(reimbId, empId, eventTypeId, description, location, justification, eventStartDate, gradeFmtId, eventCost, reimbursementAmount, requestSubmissionDate, workTimeMissed, approvalStatus, additionalComments));
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
	
	public int newReimbursementRequest(int employeeId, int eventType, String desc, String loc, String justi, Date startDate, int gradeFmt, double cost, double amtReimbursed, int daysMissed) {
		int rowsInserted = 0;
		PreparedStatement ps = null;
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "INSERT INTO REIMBURSEMENT (EMPLOYEE_ID, EVENTTYPE_ID, DESCRIPTION, "
					+ "LOCATION, JUSTIFICATION, EVENT_START_DATE, GRADE_FMT_ID, COST, AMT_REIMBURSED, "
					+ "DATE_SUBMITTED, WORK_DAYS_MISSED, APPROVAL_STATUS) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
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
			rowsInserted = ps.executeUpdate();
			
			return rowsInserted;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return rowsInserted;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return rowsInserted;
		}
	}
	
	private static Date getSqlTimestamp() {
		java.util.Date today = new java.util.Date();
		return new Date(today.getTime());
	}

	public int updateApproval(int requestId, int approvalLevel, String reason) {
		int rowsUpdated = 0;
		PreparedStatement ps = null;
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "UPDATE REIMBURSEMENT SET APPROVAL_STATUS = ?, ADDITIONAL_NOTES = ? WHERE REIMBURSEMENT_ID = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, approvalLevel);
			ps.setString(2, reason);
			ps.setInt(3, requestId);
			System.out.println(sql);
			
			rowsUpdated = ps.executeUpdate();
			
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rowsUpdated;
	}

}
