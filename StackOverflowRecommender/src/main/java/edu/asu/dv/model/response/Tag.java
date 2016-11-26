package edu.asu.dv.model.response;

public class Tag {

	private String name;
	private int count;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "Tag [name=" + name + ", count=" + count + "]";
	}

}
