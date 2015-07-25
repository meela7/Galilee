package org.galilee.dms.dao;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.galilee.dms.model.Rivers;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("riverDao")
public class RiverDAO {
	public static Logger logger = LoggerFactory.getLogger(RiverDAO.class);
	SessionFactory sessionFactory;

	@Autowired
	public RiverDAO(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public int insertRiver(Rivers river) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(river);
		tx.commit();
		Serializable id = session.getIdentifier(river);
		session.close();
		return (Integer) id;
	}

	@SuppressWarnings("unchecked")
	public List<Rivers> getList() {
		Session session = sessionFactory.openSession();
		List<Rivers> riverList = session.createQuery("from Rivers").list();
		// List<Rivers> riverList =
		// (List<Rivers>)session.createSQLQuery("SELECT * FROM Rivers").addEntity(Rivers.class).list();
		session.close();
		return riverList;
	}

	@SuppressWarnings("unchecked")
	public List<String> getBasin() {
		Session session = sessionFactory.openSession();
		List<String> basins = session.createSQLQuery(
				"select distinct Basin from Rivers").list();

		// List<Rivers> riverList =
		// (List<Rivers>)session.createSQLQuery("SELECT * FROM Rivers").addEntity(Rivers.class).list();

		session.close();
		return basins;
	}

	@SuppressWarnings("unchecked")
	public List<String> getWaterSystem() {
		Session session = sessionFactory.openSession();
//		Criteria cr = session.createCriteria(Rivers.class);
//		cr.setProjection(Projections.property("WaterSystem"));
		List<String> ws = session.createSQLQuery(
				"select distinct WaterSystem from Rivers").list();
		return ws;
	}
	
	@SuppressWarnings("unchecked")
	public List<String> getWaterSystemByBasin(String basin) {
		Session session = sessionFactory.openSession();
		List<String> ws = session.createSQLQuery(
				"select distinct WaterSystem from Rivers where Basin = '" +basin+"' ").list();
		logger.info("Basin:{},Result#:{}", basin, ws.size());
		return ws;
	}
	
	@SuppressWarnings("unchecked")
	public List<String> getSubWatershedByWS(String ws) {
		Session session = sessionFactory.openSession();
		List<String> subWS = session.createSQLQuery(
				"select distinct SubWatershed from Rivers where WaterSystem = '" + ws +"' ").list();
		logger.info("SUBWS:{},Result#:{}", ws, subWS.size());
		return subWS;
	}

	/*
	 * http://docs.jboss.org/hibernate/orm/3.3/reference/ko-KR/html/queryhql.html
	 */
	@SuppressWarnings("unchecked")
	public Rivers getRiver(int rid) {
		Session session = sessionFactory.openSession();
		// List<Rivers> riverList =
		// session.createQuery("from Rivers where RiverID="+rid).list();
		// List<Rivers> riverList =
		// session.createSQLQuery("SELECT * FROM Rivers").addEntity(Rivers.class).list();
		Query query = session.createQuery("from Rivers where RiverID=?");
		List<Rivers> riverList = query.setInteger(0, rid).list();
		session.close();
		return riverList.get(0);
	}

	public int updateRiver(Rivers river) {
		Session session = sessionFactory.openSession();

		Transaction tx = session.beginTransaction();
		// session.saveOrUpdate(river);
		Rivers loaded = (Rivers) session.get(Rivers.class, river.getRiverID());
		loaded.setRiverName(river.getRiverName());
		loaded.setBasin(river.getBasin());
		session.update(loaded);
		tx.commit();
		Serializable id = session.getIdentifier(loaded);
		session.close();
		return (Integer) id;
	}

	public int deleteRiver(int rid) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Rivers river = (Rivers) session.get(Rivers.class, rid);
		Serializable ids = session.getIdentifier(river);
		session.delete(river);
		tx.commit();

		session.close();
		return (Integer) ids;
	}

}
