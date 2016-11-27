package edu.asu.dv.model;

import java.util.ArrayList;
import java.util.List;

public class Course {
	
	private String name;
	
	private List<Recommendation> recommendations = new ArrayList<>();
	
	
	public Course() {
	}

	public Course(String name, List<Recommendation> recommendations) {
		super();
		this.name = name;
		this.recommendations = recommendations;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Recommendation> getRecommendations() {
		return recommendations;
	}

	public void setRecommendations(List<Recommendation> recommendations) {
		this.recommendations = recommendations;
	}

	@Override
	public String toString() {
		return "Course [name=" + name + ", recommendations=" + recommendations
				+ "]";
	}
	
	
	
}
