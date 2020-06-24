package com.revature.restdemobr3.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.restdemobr3.model.Student;
import com.revature.restdemobr3.model.Trainer;
import com.revature.restdemobr3.web.ConnectionService;

public class TrainersRepoDB {

	public List<Trainer> getAllTrainers() {

		try {
			List<Trainer> result = new ArrayList<Trainer>();
			
			try {
				Statement s = ConnectionService.getConnection().createStatement();
				s.executeQuery("SELECT * FROM trainer");

				ResultSet rs = s.getResultSet();
				while (rs.next()) {
					Trainer h = new Trainer();
					h.setName(rs.getString("name"));
					h.setId(rs.getInt("trainerid"));
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
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	public List<Student> getFavoriteStudent() {
		// TODO Auto-generated method stub
		return null;
	}

}
