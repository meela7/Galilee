package org.galilee.dms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "Sites")
public class Sites {
	
	@Id
	@GeneratedValue
	@Column (name = "SiteID")
	private int SiteID;
	
	private String SiteName;
	
//	@JoinColumn(name="RiverID")
//	private Rivers River;	
	private int RiverID;
	private String Latitute;
	private String Longitude;
	private int StreamOrder;
	private String StreamGrade;
	private String Address;
	@Column (name = "StandardStructure")
	private String Structure;
	private String WQMN;
	private String Image;
	private String Description;
	
	public Sites(){}
	
	public int getSiteID() {
		return SiteID;
	}
	public void setSiteID(int siteID) {
		SiteID = siteID;
	}

	public String getSiteName() {
		return SiteName;
	}
	public void setSiteName(String siteName) {
		SiteName = siteName;
	}
	public int getRiver() {
//		return River;
		return RiverID;
	}
	public void setRiver(int rid) {
//		River = river;
		RiverID = rid;
	}
	public String getLatitute() {
		return Latitute;
	}
	public void setLatitute(String latitute) {
		Latitute = latitute;
	}
	public String getLongtitude() {
		return Longitude;
	}
	public void setLongitude(String longitude) {
		Longitude = longitude;
	}
	public int getStreamOrder() {
		return StreamOrder;
	}
	public void setStreamOrder(int streamOrder) {
		StreamOrder = streamOrder;
	}
	public String getStreamGrade() {
		return StreamGrade;
	}
	public void setStreamGrade(String streamGrade) {
		StreamGrade = streamGrade;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String add) {
		Address = add;
	}
	public String getStructure() {
		return Structure;
	}
	public void setStructure(String structure) {
		Structure = structure;
	}
	public String getWQMN() {
		return WQMN;
	}
	public void setWQMN(String wQMN) {
		WQMN = wQMN;
	}
	public String getImage() {
		return Image;
	}
	public void setImage(String image) {
		Image = image;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	@Override
	public String toString() {
		return "Sites [SiteID=" + SiteID + ", SiteName=" + SiteName + ", River=" + RiverID
				+ ", Latitute=" + Latitute + ", Longitude=" + Longitude
				+ ", StreamOrder="
				+ StreamOrder + ", StreamGrade=" + StreamGrade + ", AdminArea="
				+ Address + ", Structure=" + Structure + ", WQMN=" + WQMN
				+ "]";
	}	
}
