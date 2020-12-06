package com.sda;

import com.sda.dao.OrderDao;
import com.sda.model.Order;
import com.sda.util.HibernateUtil;
import org.hibernate.Session;

public class Przyklad6 {

  public static void main(String[] args) {

    Session session = HibernateUtil.getSessionFactory().openSession();
    Order order = session.find(Order.class, 2);
    System.out.println(order.getId());
    order.getProducts().forEach(product -> System.out.println(product.getName()));
    session.close();

    OrderDao orderDao = new OrderDao();

  }

}
