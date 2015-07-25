package org.galilee.dms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Features")
public class Features {
	
	@Id 
	@Column(name="FeatureID")
	@GeneratedValue
	private int FeatureID;
	private int FeatureType;
	private String FeatureName;
	
	public Features(){}

	public int getFeatureID() {
		return FeatureID;
	}

	public void setFeatureID(int featureID) {
		FeatureID = featureID;
	}

	public String getFeatureName() {
		return FeatureName;
	}

	public void setFeatureName(String featureName) {
		FeatureName = featureName;
	}

	public int getFeatureType() {
		return FeatureType;
	}

	public void setFeatureType(int featureType) {
		FeatureType = featureType;
	}

	@Override
	public String toString() {
		return "Features [FeatureID=" + FeatureID + ", FeatureType="
				+ FeatureType + ", FeatureName=" + FeatureName + "]";
	}	
}
