package edu.asu.dv.model;

import java.util.List;

public class NetworkGraph {

	private List<NetworkNode> nodes;

	private List<NetworkEdge> edges;

	public List<NetworkNode> getNodes() {
		return nodes;
	}

	public void setNodes(List<NetworkNode> nodes) {
		this.nodes = nodes;
	}

	public List<NetworkEdge> getEdges() {
		return edges;
	}

	public void setEdges(List<NetworkEdge> edges) {
		this.edges = edges;
	}

	@Override
	public String toString() {
		return "NetworkGraph [nodes=" + nodes + ", edges=" + edges + "]";
	}

}
