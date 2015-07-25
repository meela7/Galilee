package org.galilee.dms.dao;

import java.io.Serializable;  
import java.util.List;  

import javax.transaction.Transactional;  

import org.galilee.dms.model.Sites;
import org.hibernate.Query;
import org.hibernate.Session;  
import org.hibernate.SessionFactory;  
import org.hibernate.Transaction;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Service;

@Service("siteDao")
public class SiteDAO {
  
 SessionFactory sessionFactory;

 @Autowired  
 public SiteDAO (SessionFactory sessionFactory) {
	 this.sessionFactory = sessionFactory;
 }
 
 @Transactional  
 public int insertSite(Sites site) {  
  Session session = sessionFactory.openSession();  
  Transaction tx = session.beginTransaction();  
  session.saveOrUpdate(site);  
  tx.commit();  
  Serializable id = session.getIdentifier(site);  
  session.close();  
  return (Integer) id;  
 }  
  

 public List<Sites> getList() {  
  Session session = sessionFactory.openSession();  
  @SuppressWarnings("unchecked")
List<Sites> siteList = session.createQuery("from Sites").list();  
  //List<Sites> siteList = (List<Sites>)session.createSQLQuery("SELECT * FROM Sites").addEntity(Sites.class).list();
  session.close();  
  return siteList;  
 }  
 /*
 * http://docs.jboss.org/hibernate/orm/3.3/reference/ko-KR/html/queryhql.html
 */
 
 public Sites getSite(int siteid) {  
	 Session session = sessionFactory.openSession();  
	 //List<Sites> siteList = session.createQuery("from Sites where SiteID="+siteid).list(); 
	 //List<Sites> siteList = session.createSQLQuery("SELECT * FROM Sites").addEntity(Sites.class).list();
	 Query query = session.createQuery("from Sites where SiteID=?");
	 @SuppressWarnings("unchecked")
	List<Sites> siteList = query.setInteger(0, siteid).list();
	 session.close(); 
  return siteList.get(0);  
}
 
 public int updateSite(Sites site) {  
  Session session = sessionFactory.openSession();

  Transaction tx = session.beginTransaction();  
  //session.saveOrUpdate(site);  
  Sites loaded = (Sites)session.get(Sites.class, site.getSiteID());
  loaded.setSiteName(site.getSiteName());
  loaded.setRiver(site.getRiver());
  loaded.setStreamOrder(site.getStreamOrder());
  loaded.setAddress(site.getAddress());
  session.update(loaded);
  tx.commit();  
  Serializable id = session.getIdentifier(loaded);  
  session.close();  
  return (Integer) id;  
 }  
   
 public int deleteSite(int siteid) {  
  Session session = sessionFactory.openSession();
  Transaction tx = session.beginTransaction();  
  Sites site = (Sites) session.get(Sites.class, siteid);
  Serializable ids = session.getIdentifier(site);  
  session.delete(site);  
  tx.commit();  
  
  session.close();  
  return (Integer) ids;  
 }  
  
}
