package com.sda.dao;

import com.sda.model.Country;
import com.sda.model.User;
import com.sda.util.HibernateUtil;
import org.hibernate.Session;

public class UserDao {

  private Session session;

  public User findById(int id) {
    session = HibernateUtil.getSessionFactory().openSession();
    User user = session.find(User.class, id);
    session.close();
    return user;
  }

  public void insert (User user) {
    session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    session.persist(user);
    session.flush();
    session.close();
  }

  public void delete (int id) {
    session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    //session.delete(new User(id));
    session.delete("User", id);
    session.flush();
    session.close();
  }

  public void update (User user) {
    session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    if (session.find(User.class, user.getId()) != null) {
      session.merge(user);
    } else {
      System.out.println("User does not exist");
    }
    session.flush();
    session.close();
  }
}
