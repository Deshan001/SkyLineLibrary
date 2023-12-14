package lk.ijse.skylinelibrary.service.custom;

import javafx.collections.ObservableList;
import lk.ijse.skylinelibrary.dao.CrudDao;
import lk.ijse.skylinelibrary.service.SuperService;
import lk.ijse.skylinelibrary.to.Publisher;

import java.sql.SQLException;

public interface PublisherService extends SuperService {
     String getPublisherCount() throws  ClassNotFoundException, SQLException;
     ObservableList<Publisher> getAllPublishers() throws SQLException, ClassNotFoundException;
     String getPublisherId() throws SQLException, ClassNotFoundException;
    String getLastPublisherId() throws SQLException, ClassNotFoundException;
     boolean addPublisher(Publisher temp) throws SQLException, ClassNotFoundException;
     ObservableList<Publisher> searchPublisher(String searchBy, String value) throws SQLException, ClassNotFoundException;
    ObservableList<Publisher> getAll() throws SQLException, ClassNotFoundException;
    Publisher search(String id) throws SQLException, ClassNotFoundException;
    boolean deletee(String obj) throws SQLException, ClassNotFoundException;
    boolean update(Publisher obj) throws SQLException, ClassNotFoundException;
    boolean add(Publisher obj) throws SQLException, ClassNotFoundException;
}
