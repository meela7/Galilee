package org.galilee.dms.service;

import java.util.List;

import org.galilee.dms.model.Features;

public interface FeatureService {	
	
	public void add(Features feature);
	public void update(Features feature);	
	public void delete(Features feature);
	public Features findByID(int featureID);
	public List<Features> findAll();
	
}
