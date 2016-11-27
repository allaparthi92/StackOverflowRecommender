package edu.asu.dv.model.response;

import java.util.ArrayList;
import java.util.List;

import edu.asu.dv.model.Course;

/**
 * 
 * This class holds the response entities for a user.
 *
 */
public class UserResponse {

	private String userName;

	private List<SimilarUser> similarUsers = new ArrayList<>();

	private List<Tag> tags = new ArrayList<>();

	private List<Category> categories = new ArrayList<>();

	private List<Course> courses = new ArrayList<>();

	public List<SimilarUser> getSimilarUsers() {
		return similarUsers;
	}

	public void setSimilarUsers(List<SimilarUser> similarUsers) {
		this.similarUsers = similarUsers;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "UserResponse [userName=" + userName + ", similarUsers="
				+ similarUsers + ", tags=" + tags + ", categories="
				+ categories + ", courses=" + courses + "]";
	}

}
