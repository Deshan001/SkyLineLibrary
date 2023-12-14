package lk.ijse.skylinelibrary.service.custom;

import javafx.collections.ObservableList;
import lk.ijse.skylinelibrary.dao.CrudDao;
import lk.ijse.skylinelibrary.service.SuperService;
import lk.ijse.skylinelibrary.to.Author;

import java.sql.SQLException;

public interface AuthorService extends SuperService {
    boolean add(Author obj) throws SQLException, ClassNotFoundException;
    boolean update(Author obj) throws SQLException, ClassNotFoundException;
    boolean deletee(String obj) throws SQLException, ClassNotFoundException;
    Author search(String id) throws SQLException, ClassNotFoundException;
    ObservableList<Author> getAll() throws SQLException, ClassNotFoundException;
    ObservableList<Author> getAll(String searchBy, String value) throws SQLException, ClassNotFoundException;

    String getAuthorCount() throws ClassNotFoundException, SQLException;

    ObservableList<Author> getAllAuthors() throws SQLException, ClassNotFoundException;

    String getAuthorId() throws SQLException, ClassNotFoundException;

    String getLastAuthorId() throws SQLException, ClassNotFoundException;

    boolean addAuthor(Author temp) throws SQLException, ClassNotFoundException;

    ObservableList<Author> searchAuthor(String searchBy, String value) throws SQLException, ClassNotFoundException;

}
