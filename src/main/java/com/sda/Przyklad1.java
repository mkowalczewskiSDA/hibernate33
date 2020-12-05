package com.sda;

import com.sda.model.Country;
import com.sda.util.HibernateUtil;
import javax.xml.crypto.Data;
import org.hibernate.Session;

public class Przyklad1 {

  public static void main(String[] args) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    Country country = session.find(Country.class, 2);
    System.out.println(country.toString());
    session.close();
  }

}
