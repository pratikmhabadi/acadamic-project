package com.learn.myproject.servlet;

import com.learn.myproject.dao.OrderDao;
import com.learn.myproject.entites.MyOrder;
import com.learn.myproject.helper.FactoryProvider;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Pratik
 */
public class OrderServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            StringBuilder jb = new StringBuilder();
            String line = null;

            BufferedReader reader = request.getReader();
            while ((line = reader.readLine()) != null) {
                jb.append(line);
            }
           
           
            
            OrderDao cdao= new OrderDao(FactoryProvider.getFactory());
            List no = cdao.getMaxOrderNo(); 
              
          
             int no1=(int)no.get(0)+1;
           
            
             

            
            Date dNow = new Date();
            String str = jb.toString();
            JSONArray array = new JSONArray(str);
            for (int i = 0; i < array.length(); i++) {
                JSONObject object = array.getJSONObject(i);
                out.println(object.getInt("productId"));
                out.println(object.getString("productName"));
                int total = (object.getInt("productPrice")) * (object.getInt("productQuantity"));

                try {

                    MyOrder c = new MyOrder();
                    c.setMyProductID(object.getInt("productId"));
                    c.setMyOrderSTATUS("Not Delivered");
                    c.setMyOrderProductTOTALPRICE(total);
                    c.setMyOrderProductQTY(object.getInt("productQuantity"));
                    c.setMyOrderProductPRICE(object.getInt("productPrice"));
                    c.setMyOrderProductNAME(object.getString("productName"));                
                  
                        c.setMyOrderNo(no1);
                   
                    c.setMyOrderDATE(dNow);
                    c.setMyUserID(object.getInt("userId"));
                   

                    
                    cdao.saveCart(c);

                } catch (Exception e) {
                    e.printStackTrace();
                    out.println(e);
                }
            }
            reader.close();
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
