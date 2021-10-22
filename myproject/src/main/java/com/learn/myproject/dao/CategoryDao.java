/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.learn.myproject.dao;

import com.learn.myproject.entites.Category;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author Pratik
 */
public class CategoryDao {
    private SessionFactory factory;
    
    public CategoryDao(SessionFactory factory) {
        this.factory = factory;
    }
     
      public int saveCategory(Category cat){
          Session session = this.factory.openSession();
          Transaction tx = session.beginTransaction();
          int catId=(int)session.save(cat);
          tx.commit();
          session.close();
          return catId;
      }
      
      public Category getCategoryById (int cid)
    {
        Category cat=null;
        try{            
            Session session = this.factory.openSession();
            cat = session.get(Category.class, cid);
            session.close();            
        }catch (Exception e){
            e.printStackTrace();
        }
    return cat;    
    }
      
      public List <Category>getCategories()
    {
       Session s = this.factory.openSession();
       Query query = s.createQuery("from Category");
       List<Category> list=query.list();
       return list;
    }
      
       public int deleteCategory(int cId)
    {
        int status=0;
        try{
            Session session = this.factory.openSession();
            Transaction tx = session.beginTransaction();
            Query query =session.createQuery("delete from Category where ID=:id");
            query.setParameter("id", cId);
            status= query.executeUpdate();
            tx.commit();
            session.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
       
        public boolean updateCategory(Category category)
    {
        boolean f=false;
        try{
            Session session = this.factory.openSession();
            Transaction tx = session.beginTransaction();            
            session.saveOrUpdate(category);            
            tx.commit();
            session.close();
            f=true;            
        }catch (Exception e){            
         e.printStackTrace();
        f=false;
        }
    return f;
    }
}
