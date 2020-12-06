package com.sda;

import com.sda.model.User;
import com.sda.util.HibernateUtil;
import org.hibernate.Session;

public class Przyklad5 {

  public static void main(String[] args) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.createNamedQuery("user.select.byEmail", User.class)
        .setParameter("email", "jk@wp.pl")
        .getResultList().forEach(System.out::println);
  }

}
