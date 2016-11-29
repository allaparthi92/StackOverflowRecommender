package edu.asu.dv.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties("uid")
public class SimilarUser {

	private String uid;
	private String userName;
	private Integer value;
	

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public Integer getvalue() {
		return value;
	}

	public void setvalue(Integer value) {
		this.value = value;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "SimilarUser [userName=" + userName + ",uid=" + uid + ", value=" + value + "]";
	}

	

}
