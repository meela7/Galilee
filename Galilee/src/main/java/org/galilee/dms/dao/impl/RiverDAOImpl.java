package org.galilee.dms.dao.impl;

import java.util.List;

import org.galilee.dms.dao.RiverDAO;
import org.galilee.dms.model.Rivers;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.transaction.annotation.Transactional;

public class RiverDAOImpl implements RiverDAO {

private SessionFactory sessionFactory;
	
	public RiverDAOImpl(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	
	@Override
	@Transactional
	public void insert(Rivers river) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(river);
	}

	@Override
	@Transactional
	public void update(Rivers river) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(river);
	}

	@Override
	@Transactional
	public void delete(Rivers river) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(river);
	}

	@Override
	@Transactional
	public Rivers selectByID(int riverID) {
		// TODO Auto-generated method stub
		Rivers river = (Rivers) sessionFactory.getCurrentSession().get(
				Rivers.class, riverID);
		return river;
	}
	
	@Override
	@Transactional
	public List<Rivers> selectAll() {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<Rivers> riverList = sessionFactory.getCurrentSession()
				.createCriteria(Rivers.class).addOrder(Order.asc("RiverID")).list();
		;
		return riverList;
	}
}
