package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.itemDAO;
import entity.Customer;
import entity.Item;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import java.sql.ResultSet;
import java.sql.SQLException;

public class itemDAOImpl implements itemDAO {
    @Override
    public JsonArray getAll() throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.executeQuery("select * from item");
        Item item = null;
        JsonArrayBuilder customerArray = Json.createArrayBuilder();
        JsonObjectBuilder customerJson = Json.createObjectBuilder();

        while (rst.next()) {
            item=new Item(rst.getString(1),rst.getString(2),rst.getString(3),rst.getInt(4),rst.getBigDecimal(5));
            customerJson.add("id", item.getId());
            customerJson.add("name", item.getName());
            customerJson.add("description", item.getDescription());
            customerJson.add("qty", item.getQty());
            customerJson.add("price", item.getPrice());
            customerArray.add(customerJson.build());
        }
        return customerArray.build();
    }

    @Override
    public boolean add(Customer t) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(Customer t) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return false;
    }
}
