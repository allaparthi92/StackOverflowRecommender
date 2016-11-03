package edu.asu.dv.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "items")
public class UserList {

	private List<User> userList = new ArrayList<User>();

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	@Override
	public String toString() {
		return "UserList [userList=" + userList + "]";
	}

}
