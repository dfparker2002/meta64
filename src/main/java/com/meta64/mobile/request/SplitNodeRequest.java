package com.meta64.mobile.request;


public class SplitNodeRequest {

	private String nodeId;
	private String nodeBelowId;
	private String delimiter;

	public String getNodeId() {
		return nodeId;
	}

	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}

	public String getDelimiter() {
		return delimiter;
	}

	public void setDelimiter(String delimiter) {
		this.delimiter = delimiter;
	}

	public String getNodeBelowId() {
		return nodeBelowId;
	}

	public void setNodeBelowId(String nodeBelowId) {
		this.nodeBelowId = nodeBelowId;
	}
}
