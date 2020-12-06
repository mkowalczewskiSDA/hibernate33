package com.sda;

import com.sda.model.Address;
import com.sda.model.Category;
import com.sda.model.Country;
import com.sda.model.Order;
import com.sda.model.Product;
import com.sda.model.User;
import com.sda.util.HibernateUtil;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.util.HashSet;
import java.util.Set;
import org.hibernate.Session;

public class AddData {

      public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Country country1 = new Country();
        country1.setName("Polska");
        country1.setAlias("PL");
        Country country2 = new Country();
        country2.setName("Wielka Brytania");
        country2.setAlias("UK");

        Address address1 = new Address("Marszalkowska", "1", "2", "Warszawa", "00-000", country1);
        Address address2 = new Address("Downing St", "1", null, "Londyn", "xxxxx", country2);

        User user1 = new User("Boris", "Johnson", "bj@uk.com", address2, LocalDate
            .of(1970, Month.FEBRUARY,20));
        User user2 = new User("Jan", "Kowalski", "jk@wp.pl",address1, LocalDate.now());
        User user3 = new User("Tony", "Blair", "tb@uk.com", address2, LocalDate.of(1960, Month.AUGUST, 5));
        User user4 = new User("Adam", "Nowak", "ad@wp.pl", address1, LocalDate.of(1995, Month.JANUARY, 16));

        Category category = new Category("Jedzenie");
        Category category1 = new Category("IT");
        Category category2 = new Category("Szkolenia");

        Product product = new Product("Kanapka", BigDecimal.valueOf(10), "Z Dzemem", category);
        Product product2 = new Product("Komputer", BigDecimal.valueOf(120), "Duzy", category1);
        Product product3 = new Product("Bulka", BigDecimal.valueOf(5), "Z Maslem",category);
        Product product4 = new Product("kurs", BigDecimal.valueOf(10000), "SDA",category2);

        Order order1 = new Order(LocalDateTime.now(), BigDecimal.valueOf(10000), user1);
        Order order2 = new Order(LocalDateTime.now().minus(Period.ofDays(5)), BigDecimal.valueOf(15), user3);
        Order order3 = new Order(LocalDateTime.now().minus(Period.ofMonths(3)), BigDecimal.valueOf(130), user1);
        Order order4 = new Order(LocalDateTime.now().minus(Period.ofMonths(5)), BigDecimal.valueOf(5), user2);

        Set<Product> products1 = new HashSet<>();
        products1.add(product4);
        order1.setProducts(products1);
        Set<Product> products2 = new HashSet<>();
        products2.add(product);
        products2.add(product3);
        order2.setProducts(products2);
        Set<Product> products3 = new HashSet<>();
        products3.add(product2);
        products3.add(product);
        order3.setProducts(products3);
        Set<Product> products4 = new HashSet<>();
        products4.add(product3);
        order4.setProducts(products4);



        session.beginTransaction();
        session.persist(country1);
        session.persist(country2);
        session.persist(address1);
        session.persist(address2);
        session.persist(category);
        session.persist(category1);
        session.persist(category2);
        session.persist(product);
        session.persist(product2);
        session.persist(product3);
        session.persist(product4);
        session.persist(user1);
        session.persist(user2);
        session.persist(user3);
        session.persist(user4);
        session.persist(product);
        session.persist(product2);
        session.persist(product3);
        session.persist(product4);
        session.persist(order1);
        session.persist(order2);
        session.persist(order3);
        session.persist(order4);
        session.flush();
        session.getTransaction().commit();
        session.close();
      }
}




