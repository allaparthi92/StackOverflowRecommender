package edu.asu.dv.model.response;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * This class holds the response entities for a user.
 *
 */
public class UserResponse {

	private List<SimilarUser> similarUsers = new ArrayList<>();

	private List<Tag> tags = new ArrayList<>();

	private List<Category> categories = new ArrayList<>();

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

	@Override
	public String toString() {
		return "UserResponse [similarUsers=" + similarUsers + ", tags=" + tags + ", categories=" + categories + "]";
	}

}
