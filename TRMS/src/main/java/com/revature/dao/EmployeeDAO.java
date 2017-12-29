package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.beans.Employee;
import com.revature.util.ConnectionUtil;

public class EmployeeDAO {
	
	public EmployeeDAO() {
		super();
	}
	
	public Employee verifyLogin(String employeeLogin, String password) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Employee emp = null;
		String actualPassword = null;
		String firstName = null;
		String lastName = null;
		int employeeType = 0;
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM EMPLOYEE WHERE EMPLOYEEID = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, employeeLogin);
//			ps.setString(2, employeeLogin);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				actualPassword = rs.getString("PASSWORD");
				firstName = rs.getString("FIRSTNAME");
				lastName = rs.getString("LASTNAME");
				employeeType = rs.getInt("EMPLOYEETYPEID");
				emp = new Employee(firstName, lastName, employeeType);
			}			
			if (password.equals(actualPassword)) {
				return emp;
			} else {
				return null;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			return emp;
		} catch (IOException ex) {
			ex.printStackTrace();
			return emp;
		}
		
	}
}
