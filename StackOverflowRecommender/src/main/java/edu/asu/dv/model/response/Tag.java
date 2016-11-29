package edu.asu.dv.model.response;

public class Tag {

	private String name;
	private int value;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getvalue() {
		return value;
	}

	public void setvalue(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Tag [name=" + name + ", value=" + value + "]";
	}

}
