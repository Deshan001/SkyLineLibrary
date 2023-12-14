package lk.ijse.skylinelibrary.dao.custom;

import javafx.collections.ObservableList;
import lk.ijse.skylinelibrary.dao.CrudDao;
import lk.ijse.skylinelibrary.to.Publisher;

import java.sql.SQLException;

public interface PublisherDao extends CrudDao<Publisher,String> {
    ObservableList<Publisher> getAll(String searchBy, String value) throws SQLException, ClassNotFoundException;
    String getPublisherCount() throws  ClassNotFoundException, SQLException;
    ObservableList<Publisher> getAllPublishers() throws SQLException, ClassNotFoundException;
    String getPublisherId() throws SQLException, ClassNotFoundException;
    String getLastPublisherId() throws SQLException, ClassNotFoundException;
}
