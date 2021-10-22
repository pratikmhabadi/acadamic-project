package com.learn.myproject.servlet;

import com.learn.myproject.dao.UserDao;
import com.learn.myproject.entites.User;
import com.learn.myproject.helper.FactoryProvider;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class NewPasswordServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String op = request.getParameter("operation");
            UserDao userDao = new UserDao(FactoryProvider.getFactory());
            if (op.trim().equals("newpass")) {
                HttpSession session = request.getSession();
                User user = (User) session.getAttribute("authcode");
                User use1 = userDao.getUserByEmail(user.getUserEMAIL());

                try {

                    if (use1.getUserPASSWORD().trim().equals(request.getParameter("password"))) {
                        response.sendRedirect("NewPassword.jsp");
                        out.println("Password should not be match with prevoius password");
                    } else {
                       
                        use1.setUserPASSWORD(request.getParameter("password"));                       
                        use1.setUserTYPE("normal");                       
                        userDao.saveUser(use1);
                        response.sendRedirect("Sign.jsp");
                        out.println("success");
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (op.trim().equals("setnew")) {
                try {
                    String oldp = request.getParameter("opassword");
                    String newp = request.getParameter("Cpassword");
                    if (oldp.trim().equals(newp.trim())) {
                         User use1 = userDao.getUserByEmail(request.getParameter("email"));                    
                         if (use1.getUserPASSWORD().trim().equals(request.getParameter("password"))) {
                        response.sendRedirect("Setting.jsp");
                        out.println("Password should not be match with prevoius password");
                         }else{

                        use1.setUserPASSWORD(request.getParameter("password"));
                         userDao.saveUser(use1);
                        response.sendRedirect("Sign.jsp");
                        out.println("success");
                    }
                    out.println("notchanged");}
                } catch (Exception e) {
                    e.printStackTrace();
                }
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
