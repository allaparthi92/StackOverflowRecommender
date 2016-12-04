package edu.asu.dv.model;

public class Recommendation {

	private String id;

	private String name;

	private String previewLink;

	public Recommendation() {

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPreviewLink() {
		return previewLink;
	}

	public void setPreviewLink(String previewLink) {
		this.previewLink = previewLink;
	}

	@Override
	public String toString() {
		return "Recommendation [id=" + id + ", name=" + name + ", previewLink=" + previewLink + "]";
	}

}
