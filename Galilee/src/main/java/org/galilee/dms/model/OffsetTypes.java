package org.galilee.dms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "OffsetTypes")
public class OffsetTypes {

	@Id 
	@Column(name="OffsetTypeID")
	@GeneratedValue
	private int OffsetTypeID ;	
	
	@JoinColumn
	private int UnitID;
	
	private String OffsetDescription;

	public int getOffsetTypeID() {
		return OffsetTypeID;
	}

	public void setOffsetTypeID(int offsetTypeID) {
		OffsetTypeID = offsetTypeID;
	}

	public int getUnitID() {
		return UnitID;
	}

	public void setUnitID(int unitID) {
		UnitID = unitID;
	}

	public String getOffsetDescription() {
		return OffsetDescription;
	}

	public void setOffsetDescription(String offsetDescription) {
		OffsetDescription = offsetDescription;
	}

	@Override
	public String toString() {
		return "OffsetTypes [OffsetTypeID=" + OffsetTypeID + ", UnitID="
				+ UnitID + "]";
	}
	
}
