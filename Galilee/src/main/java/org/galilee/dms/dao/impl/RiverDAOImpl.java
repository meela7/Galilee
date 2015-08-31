package org.galilee.dms.dao.impl;

import java.util.List;

import org.galilee.dms.dao.RiverDAO;
import org.galilee.dms.model.Rivers;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class RiverDAOImpl implements RiverDAO {

private SessionFactory sessionFactory;
	
	public RiverDAOImpl(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void insert(Rivers river) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(river);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void update(Rivers river) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(river);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(Rivers river) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(river);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Rivers selectByID(int riverID) {
		// TODO Auto-generated method stub
		Rivers river = (Rivers) sessionFactory.getCurrentSession().get(
				Rivers.class, riverID);
		return river;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<Rivers> selectAll() {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<Rivers> riverList = sessionFactory.getCurrentSession()
				.createCriteria(Rivers.class).addOrder(Order.asc("RiverID")).list();
		;
		return riverList;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<Rivers> selectByIDs(List<Integer> riverIDs) {
		// TODO Auto-generated method stub
		return this.sessionFactory.getCurrentSession()
				.createCriteria(Rivers.class)
				.add(Restrictions.in("RiverID", riverIDs))
				.addOrder(Order.asc("RiverName"))
				.list();
	}
}
