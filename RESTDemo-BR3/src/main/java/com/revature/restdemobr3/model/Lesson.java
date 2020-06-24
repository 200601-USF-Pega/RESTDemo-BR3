package com.revature.restdemobr3.model;

public class Lesson {
	private int id;
	private String topic;
	private int trainerID;
	
	public Lesson() {}
	public Lesson(int id, String topic, int trainer) {
		super();
		this.id = id;
		this.topic = topic;
		this.trainerID = trainer;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((topic == null) ? 0 : topic.hashCode());
		result = prime * result + trainerID;
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
		Lesson other = (Lesson) obj;
		if (id != other.id)
			return false;
		if (topic == null) {
			if (other.topic != null)
				return false;
		} else if (!topic.equals(other.topic))
			return false;
		if (trainerID != other.trainerID)
			return false;
		return true;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public int getTrainer() {
		return trainerID;
	}
	public void setTrainer(int trainer) {
		this.trainerID = trainer;
	}
		
}
