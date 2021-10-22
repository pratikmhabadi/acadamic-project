/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.learn.myproject.dao;

import com.learn.myproject.entites.ContactUS;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Pratik
 */
public class ContactDao {
      private SessionFactory factory;

    public ContactDao(SessionFactory factory) {
        this.factory = factory;
    }

    public boolean saveUser(ContactUS user) {
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
}
