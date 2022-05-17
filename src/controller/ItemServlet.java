package controller;

import dao.CrudDAO;
import dao.DAOFactory;
import entity.Item;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/item")
public class ItemServlet extends HttpServlet {
    CrudDAO<Item, String> itemDAO = (CrudDAO<Item, String>) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ITEM);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            resp.setContentType("application/json");
            resp.getWriter().print(itemDAO.getAll());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Item item = new Item(req.getParameter("itemId"), req.getParameter("itemName"), req.getParameter("itemDescription"), Integer.parseInt(req.getParameter("itemQTY")), Double.parseDouble(req.getParameter("itemPrice")));
        try {
            boolean add = itemDAO.add(item);
            PrintWriter writer = resp.getWriter();
            if (add) {
                writer.write("Customer Added...");
            } else {
                writer.write("Customer Not Added...");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Item item = new Item(req.getParameter("itemId"), req.getParameter("itemName"), req.getParameter("itemDescription"), Integer.parseInt(req.getParameter("itemQTY")), Double.parseDouble(req.getParameter("itemPrice")));
        try {
            boolean add = itemDAO.update(item);
            PrintWriter writer = resp.getWriter();
            if (add) {
                writer.write("Customer Updated...");
            } else {
                writer.write("Customer Nor Updated...");
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
            boolean b = itemDAO.delete(req.getParameter("txtItemID"));
            PrintWriter writer = resp.getWriter();
            if (b){
                writer.write("Item Deleted...");
            }else {
                writer.write("Item Not Deleted...");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
