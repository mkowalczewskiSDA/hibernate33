package com.sda;

import com.sda.dao.UserCriteriaDao;
import com.sda.model.User;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class zadanie4 {

  public static void main(String[] args) {
    UserCriteriaDao userCriteriaDao = new UserCriteriaDao();
    LocalDate date1 = LocalDate.now().minus(70,ChronoUnit.YEARS);
    LocalDate date2 = LocalDate.now().minus(26,ChronoUnit.YEARS);
    //userCriteriaDao.findAllBornBetween(date1,date2).forEach(System.out::println);
    /*List<User> users = userCriteriaDao.findAllByCityName("Warszawa");
    /*users.forEach(System.out::println);*/
    userCriteriaDao.findByCountryAlias("UK").forEach(System.out::println);

  }

}
