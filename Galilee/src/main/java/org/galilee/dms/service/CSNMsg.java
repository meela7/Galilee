package org.galilee.dms.service;

public class CSNMsg {
	private String id;
	private String timestamp;
	private String value;
	
	public CSNMsg(){
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "CSNMsg [id=" + id + ", timestamp=" + timestamp + ", value="
				+ value + "]";
	}
	
	
}
