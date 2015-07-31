package org.galilee.dms.model;

public class Features {

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
