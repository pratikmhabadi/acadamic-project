package com.learn.myproject.servlet;

import com.learn.myproject.dao.CategoryDao;
import com.learn.myproject.dao.OrderDao;
import com.learn.myproject.dao.ProductDao;
import com.learn.myproject.entites.Category;
import com.learn.myproject.entites.MyOrder;
import com.learn.myproject.entites.Product;
import com.learn.myproject.helper.FactoryProvider;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CategoryProductServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            try {
                String OP = request.getParameter("operation");
                CategoryDao categoryDao = new CategoryDao(FactoryProvider.getFactory());
                ProductDao pdao = new ProductDao(FactoryProvider.getFactory());
                if (OP.trim().equals("Category")) {
                    try {
                        Category Category = new Category();
                        Category.setCategoryNAME(request.getParameter("name"));
                        Category.setCategoryDESCRIPTION(request.getParameter("description"));
                        Category.setCategoryPHOTO(request.getParameter("photo"));
                        categoryDao.saveCategory(Category);
                        response.sendRedirect("CategoryAdd.jsp");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else if (OP.trim().equals("Product")) {
                    try {
                        Category Category = categoryDao.getCategoryById(Integer.parseInt(request.getParameter("categorie")));
                        Product p = new Product();
                        p.setProductNAME(request.getParameter("name"));
                        p.setProductPRICE(Integer.parseInt(request.getParameter("price")));
                        p.setProductDESCRIPTION(request.getParameter("description"));
                        p.setProductDISCOUNT(Integer.parseInt(request.getParameter("discount")));
                        p.setProductBADGE(request.getParameter("badge"));
                        p.setCategory(Category);
                        p.setProductSTATUS(request.getParameter("status"));
                        p.setProductIMG1(request.getParameter("photo1"));
                        p.setProductIMG2(request.getParameter("photo2"));
                        p.setProductIMG3(request.getParameter("photo3"));
                        p.setProductIMG4(request.getParameter("photo4"));
                        pdao.saveProduct(p);
                        response.sendRedirect("ProductAdd.jsp");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else if (OP.trim().equals("EditProduct")) {
                    try {
                        Product p = pdao.getProductById(Integer.parseInt(request.getParameter("id")));
                        Category Category = categoryDao.getCategoryById(Integer.parseInt(request.getParameter("categorie")));
                        p.setProductPRICE(Integer.parseInt(request.getParameter("price")));
                        p.setProductDESCRIPTION(request.getParameter("description"));
                        p.setProductDISCOUNT(Integer.parseInt(request.getParameter("discount")));
                        p.setProductBADGE(request.getParameter("badge"));
                        p.setCategory(Category);
                        p.setProductSTATUS(request.getParameter("status"));
                        p.setProductIMG1(request.getParameter("photo1"));
                        p.setProductIMG2(request.getParameter("photo2"));
                        p.setProductIMG3(request.getParameter("photo3"));
                        p.setProductIMG4(request.getParameter("photo4"));
                        pdao.saveProduct(p);
                        response.sendRedirect("AdminProductView.jsp");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else if (OP.trim().equals("ProductDelete")) {
                    try {
                        pdao.deleteProduct(Integer.parseInt(request.getParameter("id")));
                        response.sendRedirect("AdminProductView.jsp");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else if (OP.trim().equals("CategoryDelete")) {
                    try {
                        categoryDao.deleteCategory(Integer.parseInt(request.getParameter("id")));
                        response.sendRedirect("AdminCategoryView.jsp");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else if (OP.trim().equals("UpdateCategory")) {
                    try {
                        Category c = categoryDao.getCategoryById(Integer.parseInt(request.getParameter("id")));
                        c.setCategoryNAME(request.getParameter("name"));
                        c.setCategoryDESCRIPTION(request.getParameter("description"));
                        categoryDao.updateCategory(c);
                        response.sendRedirect("AdminCategoryView.jsp");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else if (OP.trim().equals("orderup")) {
                    try {
                        OrderDao dao = new OrderDao(FactoryProvider.getFactory());
                        MyOrder o = dao.getOrderssByorderId(Integer.parseInt(request.getParameter("id")));
                        o.setMyOrderSTATUS("Delivered");
                        dao.saveCart(o);
                        response.sendRedirect("Orders.jsp");

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } catch (Exception e) {
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
