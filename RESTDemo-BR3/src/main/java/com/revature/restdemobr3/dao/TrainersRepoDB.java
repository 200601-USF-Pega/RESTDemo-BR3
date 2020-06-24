package com.revature.restdemobr3.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.revature.restdemobr3.model.Student;
import com.revature.restdemobr3.model.Trainer;

public class TrainerRepoDB {


	@Override
	public List<Trainer> getAllTrainers() {
		
		List<Trainer> result = new ArrayList<Trainer>();
		Map<String, ArrayList<String>> specialMoves = new HashMap<String, ArrayList<String>>();
		
		try {
			Statement s = ConnectionService.getConnection().createStatement();
			s.executeQuery("SELECT * FROM trainer");
			
			ResultSet rs = s.getResultSet();
			while (rs.next()) {
				Trainer h = new Trainer();
				h.setName(rs.getString("name"));
				h.setId(rs.getInt("UID"));
				h.setFavoriteStudent(rs.getInt("favoritestudent"));
				h.setCurrentBatchID(rs.getInt("currentbatchid"));
				if (!result.contains(h)) {
					result.add(h);
				}
			}
			return result;
			
		} catch (SQLException e) {
			System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<Student> getFavoriteStudent() {
		// TODO Auto-generated method stub
		return null;
	}

}

