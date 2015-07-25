package org.galilee.dms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name="DataValues")
public class DataValues {
	@Id
	@GeneratedValue
	@Column (name="ValueID")
	private int ValueID;
	
	private double DataValue;
	private String DateTime;
	private Sites Site;
	
	private String Latitude;
	private String Longitude;
	
	@JoinColumn(name="SourceID")
	private Sources Source;
	
	@JoinColumn(name="FeatureID")
	private Features Feature;
	
	@JoinColumn(name="VariableID")
	private Variables Variable;
	
	@JoinColumn(name="OffsetTypeID")
	private OffsetTypes OffsetType;
	private double OffsetValue;
	
	@JoinColumn(name="SampleID")
	private Samples Sample;
	
	@JoinColumn(name="DerivedFromID")
	private int DerivedFrom;	

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

	@ManyToOne
    @JoinColumn(name = "SiteID")
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

	public OffsetTypes getOffsetType() {
		return OffsetType;
	}

	public void setOffsetType(OffsetTypes offsetType) {
		OffsetType = offsetType;
	}

	public double getOffsetValue() {
		return OffsetValue;
	}

	public void setOffsetValue(double offsetValue) {
		OffsetValue = offsetValue;
	}

	public Samples getSample() {
		return Sample;
	}

	public void setSample(Samples sample) {
		Sample = sample;
	}

	public int getDerivedFrom() {
		return DerivedFrom;
	}

	public void setDerivedFrom(int derivedFrom) {
		DerivedFrom = derivedFrom;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	private String Description;



	@Override
	public String toString() {
		return "DataValues [ValueID=" + ValueID + ", DataValue=" + DataValue
				+ ", DateTime=" + DateTime + ", Site=" + Site + ", Latitude="
				+ Latitude + ", Longitude=" + Longitude + ", Source=" + Source
				+ ", Variable=" + Variable + ", OffsetType=" + OffsetType
				+ ", OffsetValue=" + OffsetValue + ", Sample=" + Sample
				+ ", DerivedFrom=" + DerivedFrom + ", Description="
				+ Description + "]";
	}

	public Features getFeature() {
		return Feature;
	}

	public void setFeature(Features feature) {
		Feature = feature;
	}
}
