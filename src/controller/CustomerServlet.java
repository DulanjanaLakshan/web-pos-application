package controller;

import dao.CrudDAO;
import dao.DAOFactory;
import dto.CustomerDTO;
import entity.Customer;

import javax.json.Json;
import javax.json.JsonObject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {
    CrudDAO<Customer, String> customerDAO = (CrudDAO<Customer, String>) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.CUSTOMER);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            resp.setContentType("application/json");
            resp.getWriter().print(customerDAO.getAll());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Customer customer = new Customer(req.getParameter("customerId"), req.getParameter("customerName"), req.getParameter("customerAddress"), Double.parseDouble(req.getParameter("customerSalary")));
        try {
            boolean b = customerDAO.add(customer);
            if (b){
                PrintWriter writer = resp.getWriter();
                writer.write("Customer Added...");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Customer customer = new Customer(req.getParameter("customerId"), req.getParameter("customerName"), req.getParameter("customerAddress"), Double.parseDouble(req.getParameter("customerSalary")));

        try {
            boolean b = customerDAO.update(customer);
            PrintWriter writer = resp.getWriter();
            if (b){
                writer.write("Customer Updated...");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            boolean b = customerDAO.delete( req.getParameter("txtCusID"));
            PrintWriter writer = resp.getWriter();
            if (b){
                writer.write("Customer Deleted...");
            }else {
                writer.write("Customer Not Deleted...");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
