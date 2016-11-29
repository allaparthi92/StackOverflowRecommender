package edu.asu.dv.model;

public class RecommendationCourse {

	private String value;
	private String id;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "RecommendationCourse [value=" + value + ", id=" + id + "]";
	}

}
