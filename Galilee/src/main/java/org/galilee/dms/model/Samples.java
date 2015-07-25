package org.galilee.dms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "Samples")
public class Samples {
	@Id 
	@Column(name="SampleID")
	@GeneratedValue
	private int SampleID ;	
	
	private String SampleType;
	@JoinColumn
	private String LabSampleCode;
	@JoinColumn
	private int LabMethodID;
	public int getSampleID() {
		return SampleID;
	}
	public void setSampleID(int sampleID) {
		SampleID = sampleID;
	}
	public String getSampleType() {
		return SampleType;
	}
	public void setSampleType(String sampleType) {
		SampleType = sampleType;
	}
	public String getLabSampleCode() {
		return LabSampleCode;
	}
	public void setLabSampleCode(String labSampleCode) {
		LabSampleCode = labSampleCode;
	}
	public int getLabMethodID() {
		return LabMethodID;
	}
	public void setLabMethodID(int labMethodID) {
		LabMethodID = labMethodID;
	}
	@Override
	public String toString() {
		return "Samples [SampleID=" + SampleID + ", SampleType=" + SampleType
				+ ", LabSampleCode=" + LabSampleCode + ", LabMethodID="
				+ LabMethodID + "]";
	}
	
}
