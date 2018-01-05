package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import com.revature.util.ConnectionUtil;

public class EventTypeDAO {
	
	public EventTypeDAO() {
		super();
	}
	
	public HashMap<Integer, Double> getReimbursementPercentages() {
		PreparedStatement ps = null;
		ResultSet rs = null;
		HashMap<Integer, Double> reimbursementPercentages = new HashMap<Integer,Double>();
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM EVENTTYPE";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				reimbursementPercentages.put(rs.getInt("EVENTTYPEID"), rs.getDouble("REIMBURSEPCT"));
			}
			return reimbursementPercentages;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return reimbursementPercentages;
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return reimbursementPercentages;
		}
		
	}
}
