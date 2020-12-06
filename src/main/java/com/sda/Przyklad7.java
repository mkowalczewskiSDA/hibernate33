package com.sda;

import com.sda.dao.UserCriteriaDao;

public class Przyklad7 {

  public static void main(String[] args) {
    UserCriteriaDao userCriteriaDao = new UserCriteriaDao();
    //userCriteriaDao.findUserWhereNameContains("Jo").forEach(System.out::println);
    userCriteriaDao.findByEmail("jk@wp.pl").forEach(System.out::println);
  }

}
