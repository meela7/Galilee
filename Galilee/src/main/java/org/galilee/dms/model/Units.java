package org.galilee.dms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Units")
public class Units {

	@Id 
	@Column(name="UnitID")
	@GeneratedValue
	private int UnitID ;	
	
	@Column(name="UnitName")
	private String UnitName;
	
	@Column(name="UnitType")
	private String UnitType;
	
	@Column(name="UnitAbbreviation")
	private String UnitAbbreviation;
	
	public Units() {}
	
	public Units(int unitID){
		super();
		this.UnitID = unitID;
	}
	
	public int getUnitID() {
		return UnitID;
	}
	public void setUnitID(int unitID) {
		UnitID = unitID;
	}
	public String getUnitName() {
		return UnitName;
	}
	public void setUnitName(String unitName) {
		UnitName = unitName;
	}
	public String getUnitType() {
		return UnitType;
	}
	public void setUnitType(String unitType) {
		UnitType = unitType;
	}
	public String getUnitAbbreviation() {
		return UnitAbbreviation;
	}
	public void setUnitAbbreviation(String unitAbbreviation) {
		UnitAbbreviation = unitAbbreviation;
	}
	@Override
	public String toString() {
		return "<Units> "
				+ "<UnitID>" + UnitID + "</UnitID>" 
				+ "<UnitName>" + UnitName + "</UnitName>"
				+ "<UnitType>" + UnitType + "</UnitType>"
				+ "<UnitAbbreviation>" + UnitAbbreviation + "</UnitAbbreviation>"
				+ "</Units>";
	}
	
}

