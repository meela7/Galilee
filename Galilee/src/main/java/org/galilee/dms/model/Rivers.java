package org.galilee.dms.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Rivers")
public class Rivers {
	
	public Rivers(){}
	
	private int riverID;
	private String RiverName;
	private String Basin;
	private String WaterSystem;
	private String MidWatershed;
	private String SubWatershed;
	private String Classification;
	private String Image;
	private String Description;
	 
	private List<Sites> sites = new ArrayList<Sites>();

	@Id
	@GeneratedValue
	@Column (name = "RiverID")
	public int getRiverID() {
		return riverID;
	}
	public void setRiverID(int rid) {
		this.riverID = rid;
	}
	
	public String getRiverName() {
		return RiverName;
	}
	public void setRiverName(String rname) {
		this.RiverName = rname;
	}
	
	public String getBasin() {
		return Basin;
	}
	
	public void setBasin(String basin) {
		this.Basin = basin;
	}
	
	public String getWaterSystem() {
		return WaterSystem;
	}
	public void setWaterSystem(String waterSystem) {
		this.WaterSystem = waterSystem;
	}
	
	public String getMidWatershed() {
		return MidWatershed;
	}
	public void setMidWatershed(String midWatershed) {
		this.MidWatershed = midWatershed;
	}
	
	public String getSubWatershed() {
		return SubWatershed;
	}
	public void setSubWatershed(String subWatershed) {
		this.SubWatershed = subWatershed;
	}
	
	public String getClassification() {
		return Classification;
	}
	public void setClassification(String classification) {
		this.Classification = classification;
	}
	
	public String getImage() {
		return Image;
	}
	public void setImage(String image) {
		this.Image = image;
	}
	
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		this.Description = description;
	}
	
	@OneToMany(mappedBy = "river")
	public List<Sites> getSites(){
		return sites;
	}
	public void setSites(List<Sites> sites){
		this.sites = sites;
	}
}
