package edu.asu.dv.model.response;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * This class holds the response entities for a user.
 *
 */
public class UserResponse {

	private List<String> similarUsers = new ArrayList<>();

	private List<String> courses = new ArrayList<>();

	private List<String> tags = new ArrayList<>();

	private List<String> categories = new ArrayList<>();

	public List<String> getSimilarUsers() {
		return similarUsers;
	}

	public void setSimilarUsers(List<String> similarUsers) {
		this.similarUsers = similarUsers;
	}

	public List<String> getCourses() {
		return courses;
	}

	public void setCourses(List<String> courses) {
		this.courses = courses;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public List<String> getCategories() {
		return categories;
	}

	public void setCategories(List<String> categories) {
		this.categories = categories;
	}

	@Override
	public String toString() {
		return "UserResponse [similarUsers=" + similarUsers + ", courses=" + courses + ", tags=" + tags
				+ ", categories=" + categories + "]";
	}

}
