package com.revature.restdemobr3.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.revature.restdemobr3.model.Student;

public class StudentsRepoDB {
	
	ConnectionService connectionService;
	
	public StudentsRepoDB(ConnectionService connectionService) {
		this.connectionService = connectionService;
	}
	
	@Override
	public List<Student> getAllStudents() {
		
		List<Student> result = new ArrayList<Student>();
		
		try {
			
			Statement s = connectionService.getConnection().createStatement();
			s.executeQuery("SELECT * FROM students;");
			
			ResultSet rs = s.getResultSet();
			while (rs.next()) {
				
				// Fix correct column names
				Student se = new Student();
				se.setId(rs.getString("id"));
				se.setName(rs.getString("name"));
				se.setBatchID(rs.getString("batchid"));
				se.setFavoriteLesson(rs.getString("favlesson"));
				if (!result.contains(se)) result.add(se);
			}
			
			return result;
			
		} catch (SQLException e) {
			
			System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public void addNewStudent(Student student) {
		
		try {
			
			PreparedStatement newStudent = connectionService.getConnection()
					.preparedStatement("INSERT INTO students VALUES (?,?,?,?)");
			
			newStudent.setString(1,  student.getName());
			newStudent.setString(2,  student.getId());
			newStudent.setString(3,  student.getBatchID());
			newStudent.setString(4,  student.getFavoriteLesson());
			
		} catch (SQLException e) {
			
			System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	
	
}
