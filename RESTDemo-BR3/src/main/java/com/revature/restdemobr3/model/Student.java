package com.revature.restdemobr3.model;

public class Student {
	private String name;
	private String id;
	private String batchID;
	private Lesson favoriteLesson;
	
	public Student();
	
	public Student(String name, String id, String batchID, Lesson favoriteLesson) {
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
		result = prime * result + ((batchID == null) ? 0 : batchID.hashCode());
		result = prime * result + ((favoriteLesson == null) ? 0 : favoriteLesson.hashCode());
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
		Student other = (Student) obj;
		if (batchID == null) {
			if (other.batchID != null)
				return false;
		} else if (!batchID.equals(other.batchID))
			return false;
		if (favoriteLesson == null) {
			if (other.favoriteLesson != null)
				return false;
		} else if (!favoriteLesson.equals(other.favoriteLesson))
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

	public String getBatchID() {
		return batchID;
	}

	public void setBatchID(String batchID) {
		this.batchID = batchID;
	}

	public Lesson getFavoriteLesson() {
		return favoriteLesson;
	}

	public void setFavoriteLesson(Lesson favoriteLesson) {
		this.favoriteLesson = favoriteLesson;
	}
	
}
