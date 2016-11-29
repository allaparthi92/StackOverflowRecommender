package edu.asu.dv.model;

import java.util.ArrayList;
import java.util.List;

public class Course {

	private String name;

	private List<Recommendation> recommendations = new ArrayList<>();

	private List<String> users;

	public Course() {
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

	public List<String> getUsers() {
		return users;
	}

	public void setUsers(List<String> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "Course [name=" + name + ", recommendations=" + recommendations
				+ ", users=" + users + "]";
	}

}
