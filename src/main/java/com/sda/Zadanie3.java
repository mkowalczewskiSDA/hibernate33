package com.sda;

import com.sda.dao.GenericDao;
import com.sda.dao.OrderDao;
import com.sda.model.Product;
import java.time.LocalDateTime;
import java.time.Year;
import java.time.temporal.ChronoUnit;

public class Zadanie3 {

  public static void main(String[] args) {
    OrderDao orderDao = new OrderDao();
    GenericDao<Product> productDao = new GenericDao<>(Product.class);
    /*orderDao.findAfterDate(
        LocalDateTime.now().minus(6, ChronoUnit.DAYS))
    .forEach(System.out::println);
        //2020-12-06 10:41:07*/
    orderDao
        .findAllContainingProduct(productDao.findById(3))
        .forEach(System.out::println);

  }

}
