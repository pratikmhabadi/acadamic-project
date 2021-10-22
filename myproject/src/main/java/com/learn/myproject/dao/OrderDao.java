package com.learn.myproject.dao;

import com.learn.myproject.entites.MyOrder;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author Pratik
 */
public class OrderDao {

    private SessionFactory factory;

    public OrderDao(SessionFactory factory) {
        this.factory = factory;

    }

    public boolean saveCart(MyOrder order) {
        boolean f = false;
        try {
            Session session = this.factory.openSession();
            Transaction tx = session.beginTransaction();
            session.saveOrUpdate(order);
            tx.commit();
            session.close();
            f = true;
        } catch (Exception e) {
            e.printStackTrace();
            f = false;
        }
        return f;
    }

    public List getMaxOrderNo() 
    {
         Session s = this.factory.openSession();
         Query query = s.createQuery("Select max(MyOrderNo)From MyOrder");
         List list = query.list();        
         return list;
    }
    
    public List <MyOrder> getOrderssByUserId(int id)
    {     
         Session s = this.factory.openSession();
         Query query = s.createQuery("from MyOrder as o where o.MyUserID=:id");
         query.setParameter("id", id);
         List<MyOrder> list = query.list();    
         return list;
    }
     public List getTotalByOrderno(int id)
    {     
         Session s = this.factory.openSession();
         Query query = s.createQuery("SELECT sum(MyOrderProductTOTALPRICE) from MyOrder as o where o.MyOrderNo=:id");
         query.setParameter("id", id);
         List list = query.list();    
         return list;
    }
      public List getMaxOrderNoByuserid(int userid) 
    {
         Session s = this.factory.openSession();
         Query query = s.createQuery("Select max(MyOrderNo)From MyOrder as o where o.MyUserID=:id");
          query.setParameter("id", userid);
         List list = query.list();        
         return list;
    }
       public List <MyOrder> getOrderssBymaxOrderno(int id)
    {     
         Session s = this.factory.openSession();
         Query query = s.createQuery("from MyOrder as o where o.MyOrderNo=:id");
         query.setParameter("id", id);
         List<MyOrder> list = query.list();    
         return list;
    }
       public List <MyOrder> getAllOrders()
    {     
         Session s = this.factory.openSession();
         Query query = s.createQuery("from MyOrder");
         List<MyOrder> list = query.list();        
         return list;
    }
       
         public MyOrder getOrderssByorderId (int oid)
    {
        MyOrder o=null;
        try{            
            Session session = this.factory.openSession();
            o = session.get(MyOrder.class, oid);
            session.close();            
        }catch (Exception e){
            e.printStackTrace();
        }
    return o;    
    }
          public List getTotal()
    {     
         Session s = this.factory.openSession();
         Query query = s.createQuery("SELECT sum(MyOrderProductTOTALPRICE) from MyOrder");         
         List list = query.list();    
         return list;
    }
}
