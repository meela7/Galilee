package org.galilee.dms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Methods")
public class Methods {
	@Id 
	@Column(name="MethodID")
	@GeneratedValue
	private int MethodID ;
	
	private String Method;
	private String Tool;
	private String MethodLink;
	private String Description;
	public int getMethodID() {
		return MethodID;
	}
	public void setMethodID(int methodID) {
		MethodID = methodID;
	}
	public String getMethod() {
		return Method;
	}
	public void setMethod(String method) {
		Method = method;
	}
	public String getTool() {
		return Tool;
	}
	public void setTool(String tool) {
		Tool = tool;
	}
	public String getMethodLink() {
		return MethodLink;
	}
	public void setMethodLink(String methodLink) {
		MethodLink = methodLink;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	@Override
	public String toString() {
		return "Methods [MethodID=" + MethodID + ", Method=" + Method
				+ ", Tool=" + Tool + ", MethodLink=" + MethodLink + "]";
	}
	
}
