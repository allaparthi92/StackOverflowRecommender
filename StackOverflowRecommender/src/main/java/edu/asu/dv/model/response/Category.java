package edu.asu.dv.model.response;

import java.util.HashSet;
import java.util.Set;

public class Category {

	private String name;
	private Double percentage;
	private Set<String> tags = new HashSet<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPercentage() {
		return percentage;
	}

	public void setPercentage(Double percentage) {
		this.percentage = percentage;
	}

	public Set<String> getTags() {
		return tags;
	}

	public void setTags(Set<String> tags) {
		this.tags = tags;
	}

	@Override
	public String toString() {
		return "Category [name=" + name + ", percentage=" + percentage + ", tags=" + tags + "]";
	}

}
