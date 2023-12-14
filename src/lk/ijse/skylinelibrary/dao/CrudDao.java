package lk.ijse.skylinelibrary.dao;

import javafx.collections.ObservableList;

import java.sql.SQLException;

public interface CrudDao<T,ID> extends SuperDao{

   boolean add(T obj) throws SQLException,ClassNotFoundException;
   boolean update(T obj)throws SQLException,ClassNotFoundException;
   boolean deletee(String obj) throws SQLException,ClassNotFoundException;
   T search(String ID) throws SQLException,ClassNotFoundException;
   ObservableList<T> getAll() throws SQLException,ClassNotFoundException;
}
