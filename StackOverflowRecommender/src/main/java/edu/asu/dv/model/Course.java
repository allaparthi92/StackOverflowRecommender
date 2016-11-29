package edu.asu.dv.model;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class Course {

	private String name;

	private LinkedHashSet<Recommendation> recommendations = new LinkedHashSet<>();

	private List<String> users;

	public Course() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LinkedHashSet<Recommendation> getRecommendations() {
		return recommendations;
	}

	public void setRecommendations(LinkedHashSet<Recommendation> recommendations) {
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
