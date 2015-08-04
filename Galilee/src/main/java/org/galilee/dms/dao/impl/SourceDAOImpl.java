package org.galilee.dms.dao.impl;

import java.util.List;

import org.galilee.dms.dao.SourceDAO;
import org.galilee.dms.model.Sources;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class SourceDAOImpl implements SourceDAO {

	private SessionFactory sessionFactory;

	public SourceDAOImpl(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Sources insert(Sources source) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(source);
		return source;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Sources update(Sources source) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().update(source);
		return source;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(Sources source) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(source);;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Sources selectByID(int sourceID) {
		// TODO Auto-generated method stub
		Sources source = (Sources) sessionFactory.getCurrentSession().get(
				Sources.class, sourceID);
		return source;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<Sources> selectAll() {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<Sources> sourceList = sessionFactory.getCurrentSession()
				.createCriteria(Sources.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return sourceList;
	}

}
