package org.galilee.dms.dao.impl;

import java.util.List;

import org.galilee.dms.dao.FeatureDAO;
import org.galilee.dms.model.Features;
import org.galilee.dms.model.Sites;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class FeatureDAOImpl implements FeatureDAO {

	private SessionFactory sessionFactory;

	public FeatureDAOImpl(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Features insert(Features feature) {
		// TODO Auto-generated method stub
		
		this.sessionFactory.getCurrentSession().save(feature);
		return feature;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Features update(Features feature) {
		// TODO Auto-generated method stub
		
		this.sessionFactory.getCurrentSession().update(feature);
		return feature;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(Features feature) {
		// TODO Auto-generated method stub
		
		this.sessionFactory.getCurrentSession().delete(feature);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Features selectByID(int featureID) {
		// TODO Auto-generated method stub
		
		Features feature = (Features) this.sessionFactory.getCurrentSession().get(Features.class, featureID);
		return feature;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<Features> selectAll() {
		// TODO Auto-generated method stub
		
		@SuppressWarnings("unchecked")
		List<Features> featureList = this.sessionFactory.getCurrentSession()
				.createCriteria(Features.class).addOrder(Order.asc("FeatureID")).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return featureList;
	}

}
