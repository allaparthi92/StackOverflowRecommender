package edu.asu.dv.model;

import java.util.ArrayList;
import java.util.List;

public class RecommendationJson {

	private String name;

	private List<Recommendation> recommendations = new ArrayList<>();

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
		return "RecommendationJson [name=" + name + ", recommendations="
				+ recommendations + "]";
	}

}
