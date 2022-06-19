package com.example.obhibernateproyecto.dao;

import com.example.obhibernateproyecto.entities.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> findAllActive() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> criteria = builder.createQuery(User.class);
        Root<User> userTable = criteria.from(User.class);

        Predicate isActive = builder.isTrue(userTable.get("active"));

        criteria.select(userTable).where(isActive);

        return entityManager.createQuery(criteria).getResultList();
    }
}
