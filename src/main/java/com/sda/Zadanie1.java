package com.sda;

import com.sda.dao.GenericDao;
import com.sda.dao.UserDao;
import com.sda.model.Address;
import com.sda.model.Country;
import com.sda.model.User;
import com.sda.util.HibernateUtil;
import java.time.LocalDate;
import java.time.Year;
import java.time.temporal.ChronoUnit;
import org.hibernate.Session;

public class Zadanie1 {

  public static void main(String[] args) {
    /*User user = new User();
    user.setFirstName("Jan");
    user.setLastName("Kowalski");
    user.setEmail("jk@wp.pl");
    user.setBirthDate(LocalDate.now().minus(20, ChronoUnit.YEARS));

    /*Session session = HibernateUtil.getSessionFactory().openSession();
    Address address = session.find(Address.class, 1);
    session.close();*/
    /*user.setAddress(addressDao.findById(1));*/
    GenericDao<Address> addressDao = new GenericDao<>(Address.class);
    GenericDao<Country> countryDao = new GenericDao<>(Country.class);
    UserDao userDao = new UserDao();
    Address address = addressDao.findById(2);
    address.setCity("Krakow");
    //addressDao.insert(address);
    addressDao.update(address);
    /*

    userDao.insert(user);
    System.out.println(userDao.findById(1).toString());

    user.setFirstName("Adrian");
    userDao.update(user);
    System.out.println(userDao.findById(1).toString());*/

  }

}
