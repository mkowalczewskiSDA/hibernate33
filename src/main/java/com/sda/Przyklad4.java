package com.sda;

import com.sda.model.User;
import com.sda.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

public class Przyklad4 {

  public static void main(String[] args) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    NativeQuery<User> nativeQuery = session
        .createNativeQuery("select * from User where usr_id>:id", User.class)
        .setParameter("id", 2);
    nativeQuery.getResultList().forEach(System.out::println);
  }

}
