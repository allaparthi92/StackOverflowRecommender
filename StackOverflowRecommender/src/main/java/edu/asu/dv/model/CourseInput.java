package edu.asu.dv.model;

import java.util.ArrayList;
import java.util.List;

public class CourseInput {

	List<String> tags ;

	List<String> users;

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public List<String> getUsers() {
		return users;
	}

	public void setUsers(List<String> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "CourseInput [tags=" + tags + ", users=" + users + "]";
	}

}
