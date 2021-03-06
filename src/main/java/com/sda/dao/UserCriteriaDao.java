package com.sda.dao;

import com.sda.model.Address;
import com.sda.model.Address_;
import com.sda.model.Country;
import com.sda.model.Country_;
import com.sda.model.User;
import com.sda.model.User_;
import com.sda.util.HibernateUtil;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Fetch;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import org.hibernate.Session;

public class UserCriteriaDao {

  Session session;
  CriteriaBuilder criteriaBuilder;
  CriteriaQuery<User> criteriaQuery;
  Root<User> from;

  void configureFrom(){
    session = HibernateUtil.getSessionFactory().openSession();
    criteriaBuilder = session.getCriteriaBuilder();
    criteriaQuery = criteriaBuilder.createQuery(User.class);
    from = criteriaQuery.from(User.class);
  }

  public List<User> findUserWhereNameContains(String s) {
    configureFrom();
    from.fetch(User_.address);
    criteriaQuery.where(criteriaBuilder.like(from.get(User_.lastName), "%"+s+"%"));
    Query query = session.createQuery(criteriaQuery);
    List<User> users = query.getResultList();
    session.close();
    return users;
  }

  public List<User> findByEmail(String email) {
    configureFrom();
    criteriaQuery.select(from).where(criteriaBuilder.like(from.get(User_.email), email));
    Query query = session.createQuery(criteriaQuery);
    List<User> users = query.getResultList();
    session.close();
    return users;
  }

  public List<User> findAllBornBetween(LocalDate date1, LocalDate date2) {
    configureFrom();
    criteriaQuery.select(from).where(criteriaBuilder
        .between(from.get(User_.birthDate), date1, date2));
    TypedQuery<User> query = session.createQuery(criteriaQuery);
    List<User> users = query.getResultList();
    session.close();
    return users;
  }

  public List<User> findAllByCityName(String city) {
    configureFrom();
    from.fetch(User_.address);
    Join<User, Address> addressJoin = from.join(User_.address);
    criteriaQuery.where(criteriaBuilder.like(addressJoin.get(Address_.city), city));
    TypedQuery<User> query = session.createQuery(criteriaQuery);
    List<User> users = query.getResultList();
    session.close();
    return users;
  }

  public List<User> findByCountryAlias(String alias) {
    configureFrom();
    Join<User, Address> address = from.join(User_.address);
    Join<Address, Country> country = address.join(Address_.country);
    criteriaQuery.where(criteriaBuilder.like(country.get(Country_.alias), alias));
    TypedQuery<User> query = session.createQuery(criteriaQuery);
    List<User> users = query.getResultList();
    session.close();
    return users;
  }

}
