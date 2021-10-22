
package com.learn.myproject.mailservlet;

import com.learn.myproject.dao.UserDao;
import com.learn.myproject.entites.User;
import com.learn.myproject.helper.FactoryProvider;
import com.learn.myproject.mail.SendEmail;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class OTPSendServlet extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
          try{
               String op=request.getParameter("operation");
               if(op.trim().equals("Registration"))
               { try{
                   String Email =request.getParameter("email");
                   String Password =request.getParameter("password");
                   UserDao userDao =  new UserDao(FactoryProvider.getFactory());
                   User emailU = userDao.getUserByEmail(Email);
                   if(emailU==null)
                   {
                       SendEmail sm = new SendEmail(FactoryProvider.getFactory());
                       String Code = sm.getRandom();
                       User user =new User (Email,Password,Code);
                       boolean test =sm.SendEmail(user);
                       if(test)
                       {
                           HttpSession session = request.getSession();
                           session.setAttribute("authcode",user);
                           response.sendRedirect("RegistrationOTPVerification.jsp");
                       }
                   }else{
                       response.sendRedirect("index.jsp");
                   }}catch (Exception e) {
           e.printStackTrace();
           }
               }else if(op.trim().equals("ForgottenPassword"))
               {try{
                   String Email=request.getParameter("email");
                   UserDao userDao =  new UserDao(FactoryProvider.getFactory());
                   User user = userDao.getUserByEmail(Email);
                   if(user==null)
                   {
                       out.println("Your are not registerd");
                   }else{
                       SendEmail sm = new SendEmail(FactoryProvider.getFactory());
                       String Code = sm.getRandom();
                       User use =new User (Email,Code);
                       boolean test =sm.SendEmail(use);
                       if(test){
                           HttpSession session = request.getSession();
                           session.setAttribute("authcode",use);
                           response.sendRedirect("ForgottenOTPVerification.jsp");
                       }
                   }
               }catch (Exception e) {
           e.printStackTrace();
           }
               }
           }catch (Exception e) {
           e.printStackTrace();
           }
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
