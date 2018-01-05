package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
			
			rs = ps.executeQuery();
			while(rs.next()) {
				actualPassword = rs.getString("PASSWORD");
				firstName = rs.getString("FIRSTNAME");
				lastName = rs.getString("LASTNAME");
				employeeType = rs.getInt("EMPLOYEETYPEID");
				emp = new Employee(Integer.parseInt(employeeLogin), firstName, lastName, employeeType);
			}
			if (actualPassword == null) {
				return null;
			} else if (password.equals(actualPassword)) {
				return emp;
			} else {
				return null;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			return null;
		} catch (IOException ex) {
			ex.printStackTrace();
			return null;
		}
		
	}
	
	public ArrayList<Employee> getSubordinates(String employeeId) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Employee emp = null;
		int id = 0;
		String firstName = null;
		String lastName = null;
		ArrayList<Employee> subordinates = new ArrayList<>();
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM EMPLOYEE WHERE SUPERVISORID = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, employeeId);
			rs = ps.executeQuery();
			while(rs.next()) {
				id = rs.getInt("EMPLOYEEID");
				firstName = rs.getString("FIRSTNAME");
				lastName = rs.getString("LASTNAME");
				emp = new Employee(id, firstName, lastName, 0);
				if (emp != null) {
					subordinates.add(emp);
				}
			}
			return subordinates;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return subordinates;
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return subordinates;
		}
	}
	
	public ArrayList<Employee> getDepartment(String employeeId) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Employee emp = null;
		int id = 0;
		String firstName = null;
		String lastName = null;
		ArrayList<Employee> subordinates = new ArrayList<>();
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM EMPLOYEE WHERE DEPTHEADID = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, employeeId);
			rs = ps.executeQuery();
			while(rs.next()) {
				id = rs.getInt("EMPLOYEEID");
				firstName = rs.getString("FIRSTNAME");
				lastName = rs.getString("LASTNAME");
				emp = new Employee(id, firstName, lastName, 0);
				if (emp != null) {
					subordinates.add(emp);
				}
			}
			return subordinates;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return subordinates;
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return subordinates;
		}
	}
	
	public ArrayList<Employee> getAll(){
		PreparedStatement ps = null;
		ResultSet rs = null;
		Employee emp = null;
		int id = 0;
		String firstName = null;
		String lastName = null;
		ArrayList<Employee> subordinates = new ArrayList<>();
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM EMPLOYEE";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				id = rs.getInt("EMPLOYEEID");
				firstName = rs.getString("FIRSTNAME");
				lastName = rs.getString("LASTNAME");
				emp = new Employee(id, firstName, lastName, 0);
				if (emp != null) {
					subordinates.add(emp);
				}
			}
			return subordinates;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return subordinates;
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return subordinates;
		}
	}
}

