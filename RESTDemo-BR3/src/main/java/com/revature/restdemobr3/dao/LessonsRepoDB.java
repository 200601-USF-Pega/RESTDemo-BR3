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
	
	public Lesson getLesson(int lessonId) {
		try {
			Lesson lesson = new Lesson();
			
			try {
				Statement s = ConnectionService.getConnection().createStatement();
				s.executeQuery("SELECT * FROM lessons where lessonid=" + lessonId + ";");
				
				ResultSet rs = s.getResultSet();
				while (rs.next()) {
					lesson.setId(rs.getInt("lessonid"));
					lesson.setTopic(rs.getString("topic"));
					lesson.setTrainer(rs.getInt("trainer"));
				}

				return lesson;
				
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
	
	public List<Lesson> getFavLessons() {
		try {
			List<Lesson> result = new ArrayList<Lesson>();
			
			try {
				Statement s = ConnectionService.getConnection().createStatement();
				s.executeQuery("SELECT topic, count(lessonid) as num FROM lessons GROUP BY topic ORDER BY num desc;");
				
				ResultSet rs = s.getResultSet();
				while (rs.next()) {
					Lesson l = new Lesson();
					l.setTopic(rs.getString("topic"));
					l.setLessonCount(rs.getInt("num"));
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
	
	public void addLessons(Lesson lesson) {
		try {
			PreparedStatement s = ConnectionService.getConnection().prepareStatement("INSERT INTO public.lessons (topic, trainer) VALUES (?, ?);");
			s.setString(1, lesson.getTopic());
			s.setInt(2, lesson.getTrainer().getId()); 
			s.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Exception: " + e.getMessage());
		}
	}
	
}
