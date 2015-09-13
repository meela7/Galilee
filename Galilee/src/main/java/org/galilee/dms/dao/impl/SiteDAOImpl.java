package org.galilee.dms.dao.impl;

import java.util.List;

import org.galilee.dms.dao.SiteDAO;
import org.galilee.dms.model.SiteInfo;
import org.galilee.dms.model.Sites;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
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

		this.sessionFactory.getCurrentSession().save(site);
		return site;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Sites update(Sites site) {

		this.sessionFactory.getCurrentSession().update(site);
		return site;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(Sites site) {

		this.sessionFactory.getCurrentSession().delete(site);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<Sites> selectAll() {
		@SuppressWarnings("unchecked")
		List<Sites> siteList = this.sessionFactory.getCurrentSession()
				.createCriteria(Sites.class).addOrder(Order.asc("SiteID")).
		setFetchMode("River", FetchMode.JOIN).list();
		return siteList;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Sites selectByID(int siteID) {
		Sites site = (Sites) this.sessionFactory.getCurrentSession().get(
				Sites.class, siteID);
		return site;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<Sites> selectByRiverIDs(List<Integer> riverIDs) {
		
		Session session = this.sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Sites> sites = session.createCriteria(Sites.class).add(Restrictions.in("River.RiverID", riverIDs)).addOrder(Order.asc("SiteID")).list();

		return sites;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<Sites> selectByIDs(List<Integer> siteIDs) {
		
		Session session = this.sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Sites> sites = session.createCriteria(Sites.class)
		.add(Restrictions.in("SiteID", siteIDs)).addOrder(Order.asc("SiteID")).list();
		
		return sites;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<Sites> selectByBasin(String basin) {
		return this.sessionFactory.getCurrentSession().createCriteria(Sites.class)
				.add(Restrictions.eq("Basin", basin)).addOrder(Order.asc("SiteID")).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<SiteInfo> selectAllSiteInfo() {
		return this.sessionFactory.getCurrentSession().createCriteria(Sites.class, "site")
				.setFetchMode("site.River", FetchMode.JOIN).createAlias("site.River", "river")
				.setProjection(Projections.distinct(Projections.projectionList()
						.add( Projections.property("SiteID"), "SiteID")
						.add( Projections.property("SiteName"), "SiteName")
						.add( Projections.property("river.RiverName"), "RiverName")
						.add( Projections.property("river.Basin"), "Basin")
						.add( Projections.property("river.WaterSystem"), "WaterSystem")
						.add( Projections.property("river.MidWatershed"), "MidWatershed")
						.add( Projections.property("river.SubWatershed"), "SubWatershed")
						.add( Projections.property("river.Classification"), "Classification")
						.add( Projections.property("river.Image"), "RiverImage")
						.add( Projections.property("Latitude"), "Latitude")
						.add( Projections.property("Longitude"), "Longitude")
						.add( Projections.property("StreamOrder"), "StreamOrder")
						.add( Projections.property("StreamGrade"), "StreamGrade")
						.add( Projections.property("Address"), "Address")
						.add( Projections.property("StandardStructure"), "StandardStructure")
						.add( Projections.property("WQMN"), "WQMN")
						.add( Projections.property("Image"), "Image")
						.add( Projections.property("Description"), "Description")))
				.addOrder(Order.asc("SiteID"))
				.setResultTransformer(Transformers.aliasToBean(SiteInfo.class)).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<SiteInfo> selectInfoByIDs(List<Integer> infoIDs) {
		return this.sessionFactory.getCurrentSession().createCriteria(Sites.class, "site")
				.setFetchMode("site.River", FetchMode.JOIN).createAlias("site.River", "river")
				.setProjection(Projections.distinct(Projections.projectionList()
						.add( Projections.property("SiteID"), "SiteID")
						.add( Projections.property("SiteName"), "SiteName")
						.add( Projections.property("river.RiverName"), "RiverName")
						.add( Projections.property("river.Basin"), "Basin")
						.add( Projections.property("river.WaterSystem"), "WaterSystem")
						.add( Projections.property("river.MidWatershed"), "MidWatershed")
						.add( Projections.property("river.SubWatershed"), "SubWatershed")
						.add( Projections.property("river.Classification"), "Classification")
						.add( Projections.property("river.Image"), "RiverImage")
						.add( Projections.property("Latitude"), "Latitude")
						.add( Projections.property("Longitude"), "Longitude")
						.add( Projections.property("StreamOrder"), "StreamOrder")
						.add( Projections.property("StreamGrade"), "StreamGrade")
						.add( Projections.property("Address"), "Address")
						.add( Projections.property("StandardStructure"), "StandardStructure")
						.add( Projections.property("WQMN"), "WQMN")
						.add( Projections.property("Image"), "Image")
						.add( Projections.property("Description"), "Description")))
				.add(Restrictions.in("SiteID", infoIDs))
				.addOrder(Order.asc("SiteID"))
				.setResultTransformer(Transformers.aliasToBean(SiteInfo.class)).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<SiteInfo> selectInfoByRivers(List<Integer> riverIDs) {
		return this.sessionFactory.getCurrentSession().createCriteria(Sites.class, "site")
				.setFetchMode("site.River", FetchMode.JOIN).createAlias("site.River", "river")
				.setProjection(Projections.distinct(Projections.projectionList()
						.add( Projections.property("SiteID"), "SiteID")
						.add( Projections.property("SiteName"), "SiteName")
						.add( Projections.property("river.RiverName"), "RiverName")
						.add( Projections.property("river.Basin"), "Basin")
						.add( Projections.property("river.WaterSystem"), "WaterSystem")
						.add( Projections.property("river.MidWatershed"), "MidWatershed")
						.add( Projections.property("river.SubWatershed"), "SubWatershed")
						.add( Projections.property("river.Classification"), "Classification")
						.add( Projections.property("river.Image"), "RiverImage")
						.add( Projections.property("Latitude"), "Latitude")
						.add( Projections.property("Longitude"), "Longitude")
						.add( Projections.property("StreamOrder"), "StreamOrder")
						.add( Projections.property("StreamGrade"), "StreamGrade")
						.add( Projections.property("Address"), "Address")
						.add( Projections.property("StandardStructure"), "StandardStructure")
						.add( Projections.property("WQMN"), "WQMN")
						.add( Projections.property("Image"), "Image")
						.add( Projections.property("Description"), "Description")))
				.add(Restrictions.in("river.RiverID", riverIDs))
				.addOrder(Order.asc("SiteID"))
				.setResultTransformer(Transformers.aliasToBean(SiteInfo.class)).list();
	}
}
