/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.learn.myproject.dao;

import com.learn.myproject.entites.Product;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author Pratik
 */
public class ProductDao {
     private SessionFactory factory;

    public ProductDao(SessionFactory factory) {
        this.factory = factory;
    }
    
    public boolean saveProduct(Product product)
    {
        boolean f=false;
        try{
            Session session = this.factory.openSession();
            Transaction tx = session.beginTransaction();            
            session.saveOrUpdate(product);            
            tx.commit();
            session.close();
            f=true;            
        }catch (Exception e){            
         e.printStackTrace();
        f=false;
        }
    return f;
    }
    
    public List <Product> getAllProductsById(int cid)
    {     
         Session s = this.factory.openSession();
         Query query = s.createQuery("from Product as p where p.Category.CategoryID=: id");
         query.setParameter("id", cid);
         List<Product> list = query.list();    
         return list;
    }
    
    public List <Product> getAllProducts()
    {     
         Session s = this.factory.openSession();
         Query query = s.createQuery("from Product");
         List<Product> list = query.list();        
         return list;
    }
    
    public Product getProductById(int pId)
    {
        Product p = new Product();
        try{ 
            Session session = this.factory.openSession();
            Transaction tx = session.beginTransaction();
            p=session.get(Product.class,pId);
            tx.commit();
            session.close();
            return p ;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return p ;
    }
    
    
    public int deleteProduct(int pId)
    {
        int status=0;
        try{
            Session session = this.factory.openSession();
            Transaction tx = session.beginTransaction();
            Query query =session.createQuery("delete from Product where ID=:id");
            query.setParameter("id", pId);
            status= query.executeUpdate();
            tx.commit();
            session.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
    
}

