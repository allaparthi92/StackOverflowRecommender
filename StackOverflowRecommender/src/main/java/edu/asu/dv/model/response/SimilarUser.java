package edu.asu.dv.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties("uid")
public class SimilarUser {

	private String uid;
	private String name;
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
		return name;
	}

	public void setUserName(String userName) {
		this.name = userName;
	}

	@Override
	public String toString() {
		return "SimilarUser [userName=" + name + ",uid=" + uid + ", value=" + value + "]";
	}

	

}
