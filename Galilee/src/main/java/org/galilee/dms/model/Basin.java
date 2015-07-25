package org.galilee.dms.model;

public class Basin {
	
	private String Basin;
	private String WaterSystem;
	private String MidWatershed;
	private String SubWatershed;
	private String RiverName;
	private String SiteName;
	
	public Basin(){
		
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

	
	public String getRiverName() {
		return RiverName;
	}

	public void setRiverName(String riverName) {
		RiverName = riverName;
	}

	public String getSiteName() {
		return SiteName;
	}

	public void setSiteName(String siteName) {
		SiteName = siteName;
	}

	@Override
	public String toString() {
		return "Basin [Basin=" + Basin + ", WaterSystem=" + WaterSystem
				+ ", MidWatershed=" + MidWatershed + ", SubWatershed="
				+ SubWatershed + ", RiverName=" + RiverName + ", SiteName="
				+ SiteName + "]";
	}	
}
