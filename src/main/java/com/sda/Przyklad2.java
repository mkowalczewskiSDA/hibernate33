package com.sda;

import com.sda.model.Country;
import com.sda.util.HibernateUtil;
import org.hibernate.Session;

public class Przyklad2 {

  public static void main(String[] args) {
    usePersist();
    //useMerge();
    //useDelete();
  }

  public static void usePersist() {
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    Country newCountry = new Country();
    //newCountry.setId(5);
    newCountry.setName("India");
    newCountry.setAlias("IN");
    session.persist(newCountry);
    newCountry.setName("IndiaChanged");
    session.flush();
    session.close();
  }

  public static void useMerge() {
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    Country country = new Country();
    country.setId(8);
    country.setName("SpainAA");
    country.setAlias("ES");
    session.merge(country);
    //country.setName("SpainChanged");
    System.out.println(country);
    session.flush();
    session.close();
  }

  public static void useDelete() {
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    Country country = new Country();
    country.setId(4);
    session.delete(country);
    session.flush();
    session.close();
  }

}
