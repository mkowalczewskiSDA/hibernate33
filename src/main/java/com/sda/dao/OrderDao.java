package com.sda.dao;

import com.sda.model.Order;
import com.sda.model.Product;
import com.sda.util.HibernateUtil;
import java.time.LocalDateTime;
import java.util.List;
import org.hibernate.Session;

public class OrderDao extends GenericDao<Order> {

  public OrderDao() {
    super(Order.class);
  }

  public List<Order> findByDate(LocalDateTime dateTime) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    List<Order> orders = session.createQuery(
        "Select o from Order o where o.orderDate like :date", Order.class)
        .setParameter("date", dateTime).getResultList();
    session.close();
    return orders;
  }

  public List<Order> findBeforeDate(LocalDateTime dateTime) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    List<Order> orders = session.createQuery(
        "Select o from Order o where o.orderDate < :date", Order.class)
        .setParameter("date", dateTime).getResultList();
    session.close();
    return orders;
  }

  public List<Order> findAfterDate(LocalDateTime dateTime) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    List<Order> orders = session.createNativeQuery(
        "Select * from `Order` where ORD_DATE > :date", Order.class)
        .setParameter("date", dateTime).getResultList();
    session.close();
    return orders;
  }

  public List<Order> findAllContainingProduct(Product product) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    List<Order> orders = session
        .createQuery("Select o from Order o join fetch o.products p where p = :product"
            , Order.class)
        .setParameter("product", product)
        .getResultList();
    session.close();
    return orders;
  }

  public List<Order> findByPriceLowerThan(double price) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    List<Order> orders = session
        .createQuery("Select o from Order where o.price < :price"
        , Order.class)
        .setParameter("price", price)
        .getResultList();
    session.close();
    return orders;
  }

}
