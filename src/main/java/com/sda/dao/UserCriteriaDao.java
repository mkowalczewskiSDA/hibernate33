package com.sda.dao;

import com.sda.model.User;
import com.sda.model.User_;
import com.sda.util.HibernateUtil;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;

public class UserCriteriaDao {

  public List<User> findUserWhereNameContains(String s) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
    CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(User.class);
    Root<User> from = criteriaQuery.from(User.class);
    criteriaQuery.where(criteriaBuilder.like(from.get(User_.lastName), "%"+s+"%"));
    Query query = session.createQuery(criteriaQuery);
    List<User> users = query.getResultList();
    session.close();
    return users;
  }

}
