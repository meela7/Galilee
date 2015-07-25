package org.galilee.dms.model;

import java.io.Serializable;

public class Sources implements Serializable{
	
	private static final long SerialVersionUID = 1L;  
	private int SourceID;
	
	private String Organization;
	private String ContactName;
	private String Phone;
	private String Email;
	private String Description;
	
	public Sources(){}
	
	public int getSourceID() {
		return SourceID;
	}
	public void setSourceID(int sourceID) {
		SourceID = sourceID;
	}
	public String getOrganization() {
		return Organization;
	}
	public void setOrganization(String organization) {
		Organization = organization;
	}
	public String getContactName() {
		return ContactName;
	}
	public void setContactName(String contactName) {
		ContactName = contactName;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	@Override
	public String toString() {
		return "Sources [SourceID=" + SourceID + ", Organization="
				+ Organization + ", ContactName=" + ContactName + ", Phone="
				+ Phone + ", Email=" + Email + "]";
	}
}
