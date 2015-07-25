package org.galilee.dms.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.galilee.dms.model.Taxon;
import org.galilee.dms.model.Fishes;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class FishDaoImpl {

	public static Logger logger = LoggerFactory.getLogger(FishDaoImpl.class);
	SessionFactory sessionFactory;

	@Autowired
	public FishDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public int insertFish(Fishes fish) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(fish);
		tx.commit();
		Serializable id = session.getIdentifier(fish);
		session.close();
		return (Integer) id;
	}

	@SuppressWarnings("unchecked")
	public List<Fishes> getList() {
		Session session = sessionFactory.openSession();
		List<Fishes> fishList = session.createQuery("from Fishes").list();
		// List<Fishes> fList =
		// (List<Fishes>)session.createSQLQuery("SELECT * FROM Fishes").addEntity(Fishes.class).list();
		session.close();
		return fishList;
	}

	@SuppressWarnings("unchecked")
	public List<String> getFishClass() {
		Session session = sessionFactory.openSession();
		List<String> fc = session.createSQLQuery(
				"select distinct Class from Fishes").list();

		// List<Fishes> fList =
		// (List<Fishes>)session.createSQLQuery("SELECT * FROM Fishes").addEntity(Fishes.class).list();

		session.close();
		return fc;
	}

	@SuppressWarnings("unchecked")
	public List<String> getOrder() {
		Session session = sessionFactory.openSession();
		// Criteria cr = session.createCriteria(Fishes.class);
		// cr.setProjection(Projections.property("WaterSystem"));
		List<String> orderList = session.createSQLQuery(
				"select distinct Order from Fishes").list();
		return orderList;
	}

	@SuppressWarnings("unchecked")
	public List<String> getOrderByClass(String fc) {
		Session session = sessionFactory.openSession();
		List<String> orderList = session.createSQLQuery(
				"select distinct Order from Fishes where Class = '"
						+ fc + "' ").list();
		logger.info("Class:{},Result#:{}", fc, orderList.size());
		return orderList;
	}

	@SuppressWarnings("unchecked")
	public List<String> getFamilyByOrder(String order) {
		Session session = sessionFactory.openSession();
		List<String> fmList = session.createSQLQuery(
				"select distinct Family from Fishes where Order = '"
						+ order + "' ").list();
		logger.info("Order:{},Result#:{}", order, fmList.size());
		return fmList;
	}

	@SuppressWarnings("unchecked")
	public List<List> getTaxom() {
		Session session = sessionFactory.openSession();
		// Criteria cr = session.createCriteria(Fishes.class);
		// ProjectionList proList = Projections.projectionList();
		// proList.add(Projections.property("Class"));
		// proList.add(Projections.property("WaterSystem"));
		// proList.add(Projections.property("MidWatershed"));
		// proList.add(Projections.property("SubWatershed"));
		// cr.setProjection(proList);
		// List<FishTaxom> rt = cr.list();234
		logger.info("Fish.getTaxom() Started...");
		List<List> ft = session
				.createSQLQuery(
						"select `Class`, `Order`, Family, Species from Fishes")
				.list();
		logger.info("Result#:{}", ft.size());
		return ft;
	}

	/*
	 * http://docs.jboss.org/hibernate/orm/3.3/reference/ko-KR/html/queryhql.html
	 */
	@SuppressWarnings("unchecked")
	public Fishes getFish(int fid) {
		Session session = sessionFactory.openSession();
		// List<Fishes> fList =
		// session.createQuery("from Fishes where FishID="+fid).list();
		// List<Fishes> fList =
		// session.createSQLQuery("SELECT * FROM Fishes").addEntity(Fishes.class).list();
		Query query = session.createQuery("from Fishes where FishID=?");
		List<Fishes> fList = query.setInteger(0, fid).list();
		session.close();
		return fList.get(0);
	}

	public int updateFish(Fishes fish) {
		Session session = sessionFactory.openSession();

		Transaction tx = session.beginTransaction();
		// session.saveOrUpdate(fish);
		Fishes loaded = (Fishes) session.get(Fishes.class, fish.getFishID());
		loaded.setFishClass(fish.getFishClass());
		loaded.setOrder(fish.getOrder());
		loaded.setFamily(fish.getFamily());
		session.update(loaded);
		tx.commit();
		Serializable id = session.getIdentifier(loaded);
		session.close();
		return (Integer) id;
	}

	public int deleteFish(int fid) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Fishes fish = (Fishes) session.get(Fishes.class, fid);
		Serializable ids = session.getIdentifier(fish);
		session.delete(fish);
		tx.commit();

		session.close();
		return (Integer) ids;
	}

}
