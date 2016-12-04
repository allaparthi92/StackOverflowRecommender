package edu.asu.dv.model;

public class NetworkNode {

	private String node;

	private String value;

	public String getNode() {
		return node;
	}

	public void setNode(String node) {
		this.node = node;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "NetworkNode [node=" + node + ", value=" + value + "]";
	}

}
