package edu.asu.dv.model;

public class NetworkEdge {

	private String node1;

	private String node2;

	private String value;

	public String getNode1() {
		return node1;
	}

	public void setNode1(String node1) {
		this.node1 = node1;
	}

	public String getNode2() {
		return node2;
	}

	public void setNode2(String node2) {
		this.node2 = node2;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "NetworkEdge [node1=" + node1 + ", node2=" + node2 + ", value="
				+ value + "]";
	}

}
