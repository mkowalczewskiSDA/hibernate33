package com.sda.dao;

import com.sda.model.ModelClass;
import com.sda.util.HibernateUtil;
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

}
