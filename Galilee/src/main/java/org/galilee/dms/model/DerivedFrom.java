package org.galilee.dms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "DerivedFrom")
public class DerivedFrom {
	
	@Id 
	@Column(name="DerivedFromID")
	@GeneratedValue
	private int DerivedFromID ;
	
	@JoinColumn(name="ValueID")
	private DataValues Value;

	@Override
	public String toString() {
		return "DerivedFrom [DerivedFromID=" + DerivedFromID + ", Value="
				+ Value + "]";
	}

	public int getDerivedFromID() {
		return DerivedFromID;
	}

	public void setDerivedFromID(int derivedFromID) {
		DerivedFromID = derivedFromID;
	}

	public DataValues getValueID() {
		return Value;
	}

	public void setValueID(DataValues value) {
		Value = value;
	}
	
}
