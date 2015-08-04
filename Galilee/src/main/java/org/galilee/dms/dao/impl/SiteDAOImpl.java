package org.galilee.dms.dao.impl;

import java.util.List;

import org.galilee.dms.dao.SiteDAO;
import org.galilee.dms.model.Rivers;
import org.galilee.dms.model.Sites;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class SiteDAOImpl implements SiteDAO {

	private SessionFactory sessionFactory;

	public SiteDAOImpl(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Sites insert(Sites site) {
		// TODO Auto-generated method stub

		this.sessionFactory.getCurrentSession().save(site);
		return site;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Sites update(Sites site) {
		// TODO Auto-generated method stub

		this.sessionFactory.getCurrentSession().update(site);
		return site;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(Sites site) {
		// TODO Auto-generated method stub

		this.sessionFactory.getCurrentSession().delete(site);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Sites selectByID(int siteID) {
		// TODO Auto-generated method stub
		Sites site = (Sites) this.sessionFactory.getCurrentSession().get(
				Sites.class, siteID);
		return site;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<Sites> selectAll() {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<Sites> siteList = this.sessionFactory.getCurrentSession()
				.createCriteria(Sites.class).addOrder(Order.asc("SiteID")).
		setFetchMode("River", FetchMode.JOIN).list();
		return siteList;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<Sites> selectByRiverID(List<Integer> riverIDs) {
		// TODO Auto-generated method stub
		
		Session session = this.sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Sites> sites = session.createCriteria(Sites.class)
		.add(Restrictions.in("River.RiverID", riverIDs)).addOrder(Order.asc("SiteID")).list();
		for(Sites s: sites){
			System.out.println(s.getSiteName());
		}
		return sites;
	}
}
