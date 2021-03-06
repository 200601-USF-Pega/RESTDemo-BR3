package com.revature.restdemobr3.model;

public class Student {
	private String name;
	private int id;
	private int favoriteLesson;
	private int batchID;	

	public Student() {
		super();
	}

	public Student(String name, int id, int batchID, int favoriteLesson) {
		super();
		this.name = name;
		this.id = id;
		this.batchID = batchID;
		this.favoriteLesson = favoriteLesson;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + batchID;
		result = prime * result + favoriteLesson;
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
		Student other = (Student) obj;
		if (batchID != other.batchID)
			return false;
		if (favoriteLesson != other.favoriteLesson)
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

	public int getBatchID() {
		return batchID;
	}

	public void setBatchID(int batchID) {
		this.batchID = batchID;
	}

	public int getFavoriteLesson() {
		return favoriteLesson;
	}

	public void setFavoriteLesson(int favoriteLesson) {
		this.favoriteLesson = favoriteLesson;
	}
	
}
