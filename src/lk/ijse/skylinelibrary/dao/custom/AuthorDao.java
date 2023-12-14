package lk.ijse.skylinelibrary.dao.custom;

import javafx.collections.ObservableList;
import lk.ijse.skylinelibrary.dao.CrudDao;
import lk.ijse.skylinelibrary.to.Author;

import java.sql.SQLException;

public interface AuthorDao extends CrudDao<Author,String> {
   ObservableList<Author> getAll(String searchBy, String value) throws SQLException, ClassNotFoundException;
   String getAuthorCount() throws  ClassNotFoundException, SQLException;
}
