package com.example.thmoduls3.controller;

import com.example.thmoduls3.DAO.CategoryimpCRUD;
import com.example.thmoduls3.DAO.ProductimpCRUD;
import com.example.thmoduls3.model.Category;
import com.example.thmoduls3.model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "ProductServlet", value = "/ProductServlet")
public class ProductServlet extends HttpServlet {
    ProductimpCRUD productimpCRUD = new ProductimpCRUD();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    showNewForm(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "delete":
                    deleteBook(request, response);
                    break;
                default:
                    listProduct(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
    private void listProduct(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {

        ArrayList<Product> products = productimpCRUD.findAll();
        CategoryimpCRUD crudCategory = new CategoryimpCRUD();
        ArrayList<Category> categories = crudCategory.findAll();
        request.setAttribute("categories",categories);
        request.setAttribute("lb", products);
        RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
        dispatcher.forward(request, response);
    }
    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CategoryimpCRUD category = new CategoryimpCRUD();
        ArrayList<Category> categories = category.findAll();

        RequestDispatcher dispatcher = request.getRequestDispatcher("create.jsp");
        request.setAttribute("categories",categories);
        dispatcher.forward(request, response);
    }
    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productimpCRUD.findById(id);
        CategoryimpCRUD category = new CategoryimpCRUD();
        ArrayList<Category> categories = category.findAll();
        RequestDispatcher dispatcher = request.getRequestDispatcher("edit.jsp");
        request.setAttribute("product", product);
        request.setAttribute("categories",categories);
        dispatcher.forward(request, response);

    }
    private void insertProduct(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {

        CategoryimpCRUD crudCategory = new CategoryimpCRUD();
        String name_product = request.getParameter("name_product");
        double price = Double.parseDouble(request.getParameter("price"));
        int amount = Integer.parseInt(request.getParameter("amount"));
        String color = request.getParameter("color");
        String describe_product = request.getParameter("describe_product");
        int category = Integer.parseInt(request.getParameter("category"));

        Product newProduct = new Product( name_product, price,amount,color,describe_product,crudCategory.findById(category));
        productimpCRUD.insert(newProduct);
        RequestDispatcher dispatcher = request.getRequestDispatcher("create.jsp");
        dispatcher.forward(request, response);
    }
    private void updateProduct(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        CategoryimpCRUD crudCategory = new CategoryimpCRUD();
        int id_product = Integer.parseInt(request.getParameter("id_product"));
        String name_product = request.getParameter("name_product");
        double price = Double.parseDouble(request.getParameter("price"));
        int amount = Integer.parseInt(request.getParameter("amount"));
        String color = request.getParameter("color");
        String describe_product = String.valueOf(Integer.parseInt(request.getParameter("describe_product")));
        int category = Integer.parseInt(request.getParameter("category"));
        Product product = new Product(id_product,name_product,price,amount,color,describe_product,crudCategory.findById(category));
        productimpCRUD.update(product);
        RequestDispatcher dispatcher = request.getRequestDispatcher("edit.jsp");
        dispatcher.forward(request, response);
    }
    private void deleteBook(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        productimpCRUD.delete(id);

        ArrayList<Product> products = productimpCRUD.findAll();
        request.setAttribute("lb", products);
        RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
        dispatcher.forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try { switch (action){
            case "create":
                insertProduct(request,response);
                break;
            case "edit":
                updateProduct(request,response);
                break;
//
        }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
    }
