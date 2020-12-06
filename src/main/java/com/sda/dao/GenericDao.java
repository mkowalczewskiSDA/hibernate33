package com.sda.dao;

import com.sda.model.ModelClass;
import com.sda.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

public class GenericDao<T extends ModelClass>  {

  final Class<T> classParameter;

  public GenericDao(Class<T> classParameter) { this.classParameter = classParameter; }

  public T findById(int id) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    T t = session.find(classParameter,id);
    session.close();
    return t;
  }

  public void insert(T t) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    session.persist(t);
    session.flush();
    session.close();
  }

  public void delete(T t) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    session.delete(t);
    session.flush();
    session.close();
  }

  public void update(T t) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    if (session.find(classParameter, t.getId()) != null) {
      session.merge(t);
    } else {
      System.out.println("Object does not exist in database");
    }
    session.flush();
    session.close();
  }

  public List<T> getAll() {
    Session session = HibernateUtil.getSessionFactory().openSession();
    List all = session
        .createQuery("from "+classParameter.getName()).getResultList();
    session.close();
    return all;
  }

  public List<T> getAll(int firstResult, int maxResults) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    List all = session
        .createQuery("from "+classParameter.getName())
        .setFirstResult(firstResult)
        .setMaxResults(maxResults)
        .getResultList();
    session.close();
    return all;
  }

}
