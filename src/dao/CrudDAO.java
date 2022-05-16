package dao;

import dto.CustomerDTO;

import javax.json.JsonArray;
import java.sql.SQLException;

public interface CrudDAO<T,ID> extends SuperDAO{
    JsonArray getAll() throws SQLException, ClassNotFoundException;
    boolean add(CustomerDTO t) throws SQLException, ClassNotFoundException;
    boolean update(CustomerDTO t) throws SQLException, ClassNotFoundException;
    boolean delete(ID id);
}
