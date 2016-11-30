package edu.asu.dv.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CourseInput {

	Set<String> tags ;

	List<String> users;

	public Set<String> getTags() {
		return tags;
	}

	public void setTags(Set<String> tags) {
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
