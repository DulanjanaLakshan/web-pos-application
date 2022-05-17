package dao;

import entity.Customer;

import javax.json.JsonArray;
import java.sql.SQLException;

public interface CrudDAO<T,ID> extends SuperDAO{
    JsonArray getAll() throws SQLException, ClassNotFoundException;
    boolean add(Customer t) throws SQLException, ClassNotFoundException;
    boolean update(Customer t) throws SQLException, ClassNotFoundException;
    boolean delete(ID id) throws SQLException, ClassNotFoundException;
}
