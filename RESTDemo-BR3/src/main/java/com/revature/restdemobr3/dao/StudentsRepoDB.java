package com.revature.restdemobr3.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.restdemobr3.model.Lesson;
import com.revature.restdemobr3.model.Student;
import com.revature.restdemobr3.web.ConnectionService;

public class StudentsRepoDB {
	
	ConnectionService connectionService;
	
	public StudentsRepoDB(ConnectionService connectionService) {
		this.connectionService = connectionService;
	}
	
	
	public List<Student> getAllStudents() {
		
		List<Student> result = new ArrayList<Student>();
		
		try {
			
			Statement s = connectionService.getConnection().createStatement();
			s.executeQuery("SELECT * FROM student;");
			
			ResultSet rs = s.getResultSet();
			while (rs.next()) {
				
				// Fix correct column names
				Student se = new Student();
				se.setId(rs.getInt("studentid"));
				se.setName(rs.getString("name"));
				se.setBatchID(rs.getString("currentbatchid"));
//				se.setFavoriteLesson(new Lesson(rs.getString("favoritelesson")));
				se.setFavoriteLesson(null);
				if (!result.contains(se)) result.add(se);
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
			
			PreparedStatement newStudent = connectionService.getConnection()
					.prepareStatement("INSERT INTO student VALUES (?,?,?,?)");
			
			newStudent.setString(1,  student.getName());
			newStudent.setInt(2,  student.getId());
			newStudent.setString(3,  student.getBatchID());
			newStudent.setString(4,  student.getFavoriteLesson().getTopic());
			
		} catch (SQLException e) {
			
			System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	
	
}
