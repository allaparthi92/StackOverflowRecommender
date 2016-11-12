package edu.asu.dv.model.response;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * This class holds the response entities for a user.
 *
 */
public class UserResponse {

	private List<DetailMap> similarUsers = new ArrayList<>();

	private List<DetailMap> tags = new ArrayList<>();

	private List<DetailMap> categories = new ArrayList<>();

	public List<DetailMap> getSimilarUsers() {
		return similarUsers;
	}

	public void setSimilarUsers(List<DetailMap> similarUsers) {
		this.similarUsers = similarUsers;
	}

	public List<DetailMap> getTags() {
		return tags;
	}

	public void setTags(List<DetailMap> tags) {
		this.tags = tags;
	}

	public List<DetailMap> getCategories() {
		return categories;
	}

	public void setCategories(List<DetailMap> categories) {
		this.categories = categories;
	}

	@Override
	public String toString() {
		return "UserResponse [similarUsers=" + similarUsers + ", tags=" + tags + ", categories=" + categories + "]";
	}

}
