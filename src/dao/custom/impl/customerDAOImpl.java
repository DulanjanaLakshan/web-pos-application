package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.customerDAO;
import dto.CustomerDTO;
import dto.ItemDTO;
import entity.Customer;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import java.sql.ResultSet;
import java.sql.SQLException;

public class customerDAOImpl implements customerDAO {

    @Override
    public JsonArray getAll() throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.executeQuery("select * from customer");
        Customer customer = null;
        JsonArrayBuilder customerArray = Json.createArrayBuilder();
        JsonObjectBuilder customerJson = Json.createObjectBuilder();

        while (rst.next()) {
            customer = new Customer(rst.getString(1), rst.getString(2), rst.getString(3), rst.getInt(4));
            customerJson.add("id", customer.getId());
            customerJson.add("name", customer.getName());
            customerJson.add("address", customer.getAddress());
            customerJson.add("salary", customer.getSalary());
            customerArray.add(customerJson.build());
        }
        return customerArray.build();
    }

    @Override
    public boolean add(Customer dto) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeUpdate("INSERT INTO customer VALUES(?,?,?,?)", dto.getId(), dto.getName(), dto.getAddress(), dto.getSalary());
    }

    @Override
    public boolean update(Customer dto) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeUpdate("UPDATE Customer SET name=?, address=?, salary=? WHERE id=?", dto.getName(), dto.getAddress(), dto.getSalary(), dto.getId());
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeUpdate("DELETE FROM Customer WHERE id=?", id);
    }
}
