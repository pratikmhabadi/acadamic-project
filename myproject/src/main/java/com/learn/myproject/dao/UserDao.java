/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.learn.myproject.dao;

import com.learn.myproject.entites.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author Pratik
 */
public class UserDao {

    private SessionFactory factory;

    public UserDao(SessionFactory factory) {
        this.factory = factory;
    }

    public boolean saveUser(User user) {
        boolean f = false;
        try {
            Session session = this.factory.openSession();
            Transaction tx = session.beginTransaction();
            session.saveOrUpdate(user);
            tx.commit();
            session.close();
            f = true;
        } catch (Exception e) {
            e.printStackTrace();
            f = false;
        }
        return f;
    }

    public User getUserByEmail(String email) {
        User user = null;
        try {
            String query = "from User as u where u.UserEMAIL=:e";
            Session session = this.factory.openSession();
            Query q = session.createQuery(query);
            q.setParameter("e", email);
            user = (User) q.uniqueResult();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    public User getUserByEmailAndPassword(String email, String password) {
        User user = null;
        try {
            String query = "from User where UserEMAIL =:e and UserPASSWORD=: p";
            Session session = this.factory.openSession();
            Query q = session.createQuery(query);
            q.setParameter("e", email);
            q.setParameter("p", password);
            user = (User) q.uniqueResult();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    public User getUserByID(int UserID) {
        User u = new User();
        try {
            Session session = this.factory.openSession();
            Transaction tx = session.beginTransaction();

            u = session.get(User.class, UserID);

            tx.commit();
            session.close();
            return u;
        } catch (Exception e) {
            e.printStackTrace();

        }
        return u;
    }
    
    
}
