package com.sda;

import com.sda.dao.GenericDao;
import com.sda.model.Country;

public class zadanie2 {

  public static void main(String[] args) {

    GenericDao<Country> countryDao = new GenericDao<>(Country.class);
    //countryDao.getAll().forEach(System.out::println);
    countryDao.getAll(0,5).forEach(System.out::println);

  }

}
