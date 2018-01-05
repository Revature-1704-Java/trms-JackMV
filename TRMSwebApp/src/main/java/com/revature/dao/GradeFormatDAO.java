package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import com.revature.util.ConnectionUtil;

public class GradeFormatDAO {
	
	public GradeFormatDAO() {}

	public HashMap<String, Integer> getGradeFormats() {
		PreparedStatement ps = null;
		ResultSet rs = null;
		HashMap<String, Integer> gradeFormats = new HashMap<String,Integer>();
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM GRADINGFORMATS";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				gradeFormats.put(rs.getString("FORMATDESC"), rs.getInt("FORMATID"));
			}
			
			return gradeFormats;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return gradeFormats;
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return gradeFormats;
		}
	}

}
