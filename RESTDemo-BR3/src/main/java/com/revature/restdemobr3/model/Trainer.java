package com.revature.restdemobr3.model;

public class Trainer {
	private String name;
	private int id;
	private Student favoriteStudent;
	private int currentBatchID;
	
	public Trainer() {}
	public Trainer(String name, int id, Student favoriteStudent, int currentBatchID) {
		super();
		this.name = name;
		this.id = id;
		this.favoriteStudent = favoriteStudent;
		this.currentBatchID = currentBatchID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + currentBatchID;
		result = prime * result + ((favoriteStudent == null) ? 0 : favoriteStudent.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Trainer other = (Trainer) obj;
		if (currentBatchID != other.currentBatchID)
			return false;
		if (favoriteStudent == null) {
			if (other.favoriteStudent != null)
				return false;
		} else if (!favoriteStudent.equals(other.favoriteStudent))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Student getFavoriteStudent() {
		return favoriteStudent;
	}

	public void setFavoriteStudent(Student favoriteStudent) {
		this.favoriteStudent = favoriteStudent;
	}

	public int getCurrentBatchID() {
		return currentBatchID;
	}

	public void setCurrentBatchID(int currentBatchID) {
		this.currentBatchID = currentBatchID;
	}
	
	
}
