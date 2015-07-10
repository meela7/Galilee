package org.galilee.dms.dao;

import java.io.Serializable;  
import java.util.List;  

import javax.transaction.Transactional;  

import org.galilee.dms.model.Rivers;
import org.hibernate.Query;
import org.hibernate.Session;  
import org.hibernate.SessionFactory;  
import org.hibernate.Transaction;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Service;

@Service("riverDao")
public class RiverDAO {
  
 SessionFactory sessionFactory;

 @Autowired  
 public RiverDAO (SessionFactory sessionFactory) {
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
  

 public List<Rivers> getList() {  
  Session session = sessionFactory.openSession();  
  List<Rivers> riverList = session.createQuery("from Rivers").list();  
  //List<Rivers> riverList = (List<Rivers>)session.createSQLQuery("SELECT * FROM Rivers").addEntity(Rivers.class).list();
  session.close();  
  return riverList;  
 }  
 /*
 * http://docs.jboss.org/hibernate/orm/3.3/reference/ko-KR/html/queryhql.html
 */
 public Rivers getRiver(int rid) {  
	 Session session = sessionFactory.openSession();  
	 //List<Rivers> riverList = session.createQuery("from Rivers where RiverID="+rid).list(); 
	 //List<Rivers> riverList = session.createSQLQuery("SELECT * FROM Rivers").addEntity(Rivers.class).list();
	 Query query = session.createQuery("from Rivers where RiverID=?");
	 List<Rivers> riverList = query.setInteger(0, rid).list();
	 session.close(); 
  return riverList.get(0);  
}
 
 public int updateRiver(Rivers river) {  
  Session session = sessionFactory.openSession();

  Transaction tx = session.beginTransaction();  
  //session.saveOrUpdate(river);  
  Rivers loaded = (Rivers)session.get(Rivers.class, river.getRiverID());
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
