package org.galilee.dms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "Variables")
public class Variables {

	@Id 
	@Column(name="VariableID")
	@GeneratedValue
	private int VariableID;
	private String VariableName;
	
	@JoinColumn
	private int UnitID;
	
	
	private String ValueType;
	private String GeneralCategory;
	private String SampleMedium;
	private String Speciation;
	private String Description;

	public Variables() {}
	
	public int getVariableID() {
		return VariableID;
	}

	public void setVariableID(int variableID) {
		VariableID = variableID;
	}

	public int getUnitID() {
		return UnitID;
	}

	public void setUnitID(int unitID) {
		UnitID = unitID;
	}

	public String getVariableName() {
		return VariableName;
	}

	public void setVariableName(String vn) {
		VariableName = vn;
	}
	
	public String getValueType() {
		return ValueType;
	}

	public void setValueType(String valueType) {
		ValueType = valueType;
	}

	public String getGeneralCategory() {
		return GeneralCategory;
	}

	public void setGeneralCategory(String generalCategory) {
		GeneralCategory = generalCategory;
	}

	public String getSampleMedium() {
		return SampleMedium;
	}

	public void setSampleMedium(String sampleMedium) {
		SampleMedium = sampleMedium;
	}

	public String getSpeciation() {
		return Speciation;
	}

	public void setSpeciation(String speciation) {
		Speciation = speciation;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	@Override
	public String toString() {
		return "Variables [VariableID=" + VariableID + ", VariableName="
				+ VariableName + ", UnitID=" + UnitID + ", ValueType=" + ValueType
				+ ", GeneralCategory=" + GeneralCategory + ", SampleMedium="
				+ SampleMedium + ", Speciation=" + Speciation + "]";
	}

	
}
