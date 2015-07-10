package org.galilee.dms.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Rivers")
public class Rivers {
	@Id
	@GeneratedValue
	@Column (name = "RiverID")
	private int RiverID;
	private String RiverName;
	private String Basin;
	@Column (name = "WaterSystem")
	private String WaterBone;
	@Column (name = "MidWatershed")
	private String Stream;
	@Column (name = "SubWatershed")
	private String Catchment;
	@Column (name = "Classification")
	private String Division;
	private String Image;
	private String Description;
	
	public Rivers(){}
	
	public int getRiverID() {
		return RiverID;
	}
	public void setRiverID(int riverID) {
		RiverID = riverID;
	}
	public String getRiverName() {
		return RiverName;
	}
	public void setRiverName(String riverName) {
		RiverName = riverName;
	}
	public String getBasin() {
		return Basin;
	}
	public void setBasin(String basin) {
		Basin = basin;
	}
	public String getWaterBone() {
		return WaterBone;
	}
	public void setWaterBone(String waterBone) {
		WaterBone = waterBone;
	}
	public String getStream() {
		return Stream;
	}
	public void setStream(String stream) {
		Stream = stream;
	}
	public String getCatchment() {
		return Catchment;
	}
	public void setCatchment(String catchment) {
		Catchment = catchment;
	}
	public String getDivision() {
		return Division;
	}
	public void setDivision(String division) {
		Division = division;
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
		return "Rivers [RiverID=" + RiverID + ", RiverName=" + RiverName
				+ ", Basin=" + Basin + ", WaterBone=" + WaterBone + ", Stream="
				+ Stream + ", Catchment=" + Catchment + ", Division="
				+ Division + "]";
	}
}
