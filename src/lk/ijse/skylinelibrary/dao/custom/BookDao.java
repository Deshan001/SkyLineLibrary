package lk.ijse.skylinelibrary.dao.custom;

import javafx.collections.ObservableList;
import lk.ijse.skylinelibrary.dao.CrudDao;
import lk.ijse.skylinelibrary.to.Book;

import java.sql.SQLException;

public interface BookDao extends CrudDao<Book,String> {
    ObservableList<Book> search(String searchBy, String value) throws SQLException, ClassNotFoundException;
    String getBookId() throws SQLException, ClassNotFoundException;
    String getLastBookId() throws SQLException, ClassNotFoundException;
    String getBookCount() throws  ClassNotFoundException, SQLException;
}
