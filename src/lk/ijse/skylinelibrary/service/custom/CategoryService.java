package lk.ijse.skylinelibrary.service.custom;

import javafx.collections.ObservableList;
import lk.ijse.skylinelibrary.dao.CrudDao;
import lk.ijse.skylinelibrary.service.SuperService;
import lk.ijse.skylinelibrary.to.Catagory;

import java.sql.SQLException;

public interface CategoryService extends SuperService {
     String getCatagoryCount() throws  ClassNotFoundException, SQLException;
     ObservableList<Catagory>getAllCatagory() throws SQLException, ClassNotFoundException;
     String getCatagoryId() throws SQLException, ClassNotFoundException;
    String getLastcatagoryId() throws SQLException, ClassNotFoundException;
     ObservableList<Catagory> searchCatagory(String searchBy, String value) throws SQLException, ClassNotFoundException;
     boolean addCatagory(Catagory temp) throws SQLException, ClassNotFoundException;
    boolean add(Catagory obj) throws SQLException, ClassNotFoundException;
    boolean update(Catagory obj) throws SQLException, ClassNotFoundException;
    boolean deletee(String obj) throws SQLException, ClassNotFoundException;
    Catagory search(String id) throws SQLException, ClassNotFoundException;
    ObservableList<Catagory> getAll() throws SQLException, ClassNotFoundException;
}
