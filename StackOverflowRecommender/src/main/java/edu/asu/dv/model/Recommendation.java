package edu.asu.dv.model;

import java.util.ArrayList;
import java.util.List;

public class Recommendation {

	private String id;

	private String language;

	private List<String> links = new ArrayList<String>();

	private String name;

	private String previewLink;

	private String shortName;

	public Recommendation() {

	}

	public Recommendation(String id, String language, List<String> links,
			String name, String previewLink, String shortName) {
		super();
		this.id = id;
		this.language = language;
		this.links = links;
		this.name = name;
		this.previewLink = previewLink;
		this.shortName = shortName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public List<String> getLinks() {
		return links;
	}

	public void setLinks(List<String> links) {
		this.links = links;
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

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	@Override
	public String toString() {
		return "Recommendation [id=" + id + ", language=" + language
				+ ", links=" + links + ", name=" + name + ", previewLink="
				+ previewLink + ", shortName=" + shortName + "]";
	}

}
