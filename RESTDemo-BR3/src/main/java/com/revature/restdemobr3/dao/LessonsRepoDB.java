package com.revature.restdemobr3.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.restdemobr3.model.Lesson;
import com.revature.restdemobr3.web.ConnectionService;

public class LessonsRepoDB {

	public List<Lesson> getAllLessons() {
		try {
			List<Lesson> result = new ArrayList<Lesson>();
			
			try {
				Statement s = ConnectionService.getConnection().createStatement();
				s.executeQuery("SELECT * FROM lessons;");
				
				ResultSet rs = s.getResultSet();
				while (rs.next()) {
					Lesson l = new Lesson();
					l.setId(rs.getInt("lessonid"));
					l.setTopic(rs.getString("topic"));
					l.setTrainer(rs.getInt("trainer"));
					result.add(l);
				}

				return result;
				
			} catch (SQLException e) {
				System.out.println("Exception: " + e.getMessage());
				e.printStackTrace();
			}
			
			return null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void addLessons() {

	}
}
