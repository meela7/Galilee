package org.galilee.dms.dao;

import java.util.List;

import org.galilee.dms.model.Features;

public interface FeatureDAO {
	
	public Features insert(Features feature);
	public Features update(Features feature);
	public void delete(Features feature);
	public Features selectByID(int featureID);
	public List<Features> selectAll();
	
}
