package com.vodafone.repository;

import com.vodafone.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private static StandardServiceRegistry registry=new StandardServiceRegistryBuilder().configure().build();
    private static SessionFactory sessionFactory=new MetadataSources(registry).buildMetadata().buildSessionFactory();

    @Override
    public User addUser(User user) {
        try(Session s=sessionFactory.openSession()){
            Transaction transaction=s.beginTransaction();
            s.persist(user);
            transaction.commit();
        }
        return user;
    }

    @Override
    public List<User> findAllUsers() {
        List<User> users;
        try(Session s=sessionFactory.openSession()){
            users= s.createQuery("from User", User.class).list();
        }
        return users;
    }
}
