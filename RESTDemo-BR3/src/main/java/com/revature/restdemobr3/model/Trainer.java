package com.revature.restdemobr3.model;

public class Trainer {
	private String name;
	private String id;
	private Student favoriteStudent;
	private String currentBatchID;
	
	public Trainer(String name, String id, Student favoriteStudent, String currentBatchID) {
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
		result = prime * result + ((currentBatchID == null) ? 0 : currentBatchID.hashCode());
		result = prime * result + ((favoriteStudent == null) ? 0 : favoriteStudent.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		if (currentBatchID == null) {
			if (other.currentBatchID != null)
				return false;
		} else if (!currentBatchID.equals(other.currentBatchID))
			return false;
		if (favoriteStudent == null) {
			if (other.favoriteStudent != null)
				return false;
		} else if (!favoriteStudent.equals(other.favoriteStudent))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Student getFavoriteStudent() {
		return favoriteStudent;
	}

	public void setFavoriteStudent(Student favoriteStudent) {
		this.favoriteStudent = favoriteStudent;
	}

	public String getCurrentBatchID() {
		return currentBatchID;
	}

	public void setCurrentBatchID(String currentBatchID) {
		this.currentBatchID = currentBatchID;
	}
	
	
}
