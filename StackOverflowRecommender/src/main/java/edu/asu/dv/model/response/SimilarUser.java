package edu.asu.dv.model.response;

public class SimilarUser {

	private String uid;
	private Integer weight;

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "SimilarUser [uid=" + uid + ", weight=" + weight + "]";
	}

}
