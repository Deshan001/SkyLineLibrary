package lk.ijse.skylinelibrary.dao.custom;

import javafx.collections.ObservableList;
import lk.ijse.skylinelibrary.dao.CrudDao;
import lk.ijse.skylinelibrary.to.Catagory;

import java.sql.SQLException;

public interface CategoryDao extends CrudDao<Catagory,String> {
    ObservableList<Catagory> searchCatagory(String searchBy, String value) throws SQLException, ClassNotFoundException;
    String getCatagoryCount() throws  ClassNotFoundException, SQLException;
    ObservableList<Catagory>getAllCatagory() throws SQLException, ClassNotFoundException;
    String getCatagoryId() throws SQLException, ClassNotFoundException;
    String getLastcatagoryId() throws SQLException, ClassNotFoundException;
}
