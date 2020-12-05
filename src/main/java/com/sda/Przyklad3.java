package com.sda;

import com.sda.model.Address;
import com.sda.model.Country;
import com.sda.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.w3c.dom.ls.LSOutput;

public class Przyklad3 {

  public static void main(String[] args) {
    Session session = HibernateUtil.getSessionFactory().openSession();

    Query<Country> query = session
        .createQuery("select c from Country c where c.name=:name", Country.class)
        .setParameter("name", "IndiaChanged");
    query.getResultList().forEach(System.out::println);
    //Wszystkie adresy dla danego kraju - Polska
    Query<Address> query1 = session
        .createQuery("select a from Address a join fetch a.country c where c.alias=:alias and c.name=:name", Address.class)
        .setParameter("alias", "IN")
        .setParameter("name", "India");

    List<Address> list = query1.getResultList();
    session.close();
    list.forEach(System.out::println);

  }

}
