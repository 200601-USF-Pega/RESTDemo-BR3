package com.revature.restdemobr3.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.restdemobr3.model.Student;
import com.revature.restdemobr3.web.ConnectionService;

public class StudentsRepoDB {
	
	public List<Student> getAllStudents() {
		
		List<Student> result = new ArrayList<Student>();
		
		try {
			
			Statement s = ConnectionService.getConnection().createStatement();
			s.executeQuery("SELECT * FROM student;");
			
			ResultSet rs = s.getResultSet();
			while (rs.next()) {
				
				// Fix correct column names
				Student se = new Student();
				se.setId(rs.getInt("studentid"));
				se.setName(rs.getString("name"));
				se.setBatchID(rs.getInt("currentbatchid"));
				se.setFavoriteLesson(rs.getInt("favoritelesson"));
				//se.setFavoriteLesson(null);
				if (!result.contains(se)) result.add(se);
			}
			
			return result;
			
		} catch (SQLException e) {
			
			System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	
	public Student getStudentByName(String name) {
		
		Student result = new Student();
		
		try {
			
			Statement s = ConnectionService.getConnection().createStatement();
			s.executeQuery("SELECT * FROM student WHERE id = '" + name + "';");
			
			ResultSet rs = s.getResultSet();
			
			if (rs.next()) {
				
				result.setId(rs.getInt("studentid"));
				result.setName(rs.getString("name"));
				result.setBatchID(rs.getInt("currentbatchid"));
				result.setFavoriteLesson(rs.getInt("favoritelesson"));
			}
			
			return result;
			
		} catch (SQLException e) {
			
			System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
			return null;
		}
		
	}
	
	public void addNewStudent(Student student) {
		
		try {
			
			PreparedStatement newStudent = ConnectionService.getConnection()
					.prepareStatement("INSERT INTO student VALUES (?,?,?,?)");
			
			newStudent.setString(1,  student.getName());
			newStudent.setInt(2,  student.getId());
			newStudent.setInt(3,  student.getBatchID());
			newStudent.setInt(4,  student.getFavoriteLesson());
			
		} catch (SQLException e) {
			
			System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	
	
}
