package com.sda;

import com.sda.model.Address;
import com.sda.model.Country;
import com.sda.util.HibernateUtil;
import javax.xml.crypto.Data;
import org.hibernate.Session;

public class Przyklad1 {

  public static void main(String[] args) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    Address address = session.find(Address.class, 1);
    //System.out.println(address.getCountry());
    session.close();
    System.out.println(address.getCountry());
  }

}
