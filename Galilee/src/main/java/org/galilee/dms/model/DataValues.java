package org.galilee.dms.model;

import org.galilee.dms.model.Sites;

public class DataValues {

	private int ValueID;	
	private double DataValue;
	private String DateTime;
	private Sites Site;	
	private String Latitude;
	private String Longitude;	
	private Sources Source;
	private Features Feature;
	private Variables Variable;

	public int getValueID() {
		return ValueID;
	}

	public void setValueID(int valueID) {
		ValueID = valueID;
	}

	public double getDataValue() {
		return DataValue;
	}

	public void setDataValue(double dataValue) {
		DataValue = dataValue;
	}

	public String getDateTime() {
		return DateTime;
	}

	public void setDateTime(String dateTime) {
		DateTime = dateTime;
	}

	public Sites getSite() {
		return Site;
	}

	public void setSite(Sites site) {
		Site = site;
	}

	public String getLatitude() {
		return Latitude;
	}

	public void setLatitude(String latitude) {
		Latitude = latitude;
	}

	public String getLongitude() {
		return Longitude;
	}

	public void setLongitude(String longitude) {
		Longitude = longitude;
	}

	public Sources getSource() {
		return Source;
	}

	public void setSource(Sources source) {
		Source = source;
	}

	public Variables getVariable() {
		return Variable;
	}

	public void setVariable(Variables variable) {
		Variable = variable;
	}


	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	private String Description;

	public Features getFeature() {
		return Feature;
	}

	public void setFeature(Features feature) {
		Feature = feature;
	}

	@Override
	public String toString() {
		return "DataValues [ValueID=" + ValueID + ", DataValue=" + DataValue
				+ ", DateTime=" + DateTime + ", Site=" + Site + ", Latitude="
				+ Latitude + ", Longitude=" + Longitude + ", Source=" + Source
				+ ", Feature=" + Feature + ", Variable=" + Variable
				+ ", Description=" + Description + "]";
	}
	
}
