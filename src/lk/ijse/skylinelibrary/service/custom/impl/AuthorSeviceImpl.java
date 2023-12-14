package lk.ijse.skylinelibrary.service.custom.impl;

import javafx.collections.ObservableList;
import lk.ijse.skylinelibrary.dao.DaoFactory;
import lk.ijse.skylinelibrary.dao.DaoType;
import lk.ijse.skylinelibrary.dao.custom.AuthorDao;
import lk.ijse.skylinelibrary.dao.custom.impl.AuthorDaoimpl;
import lk.ijse.skylinelibrary.service.custom.AuthorService;
import lk.ijse.skylinelibrary.to.Author;

import java.sql.SQLException;

public class AuthorSeviceImpl implements AuthorService {
    private AuthorDao authorDao = DaoFactory.getInstance().getDao(DaoType.AUTHOR);

    @Override
    public boolean add(Author obj) throws SQLException, ClassNotFoundException {
        return authorDao.add(obj);
    }

    @Override
    public boolean update(Author obj) throws SQLException, ClassNotFoundException {
        return authorDao.update(obj);
    }

    @Override
    public boolean deletee(String obj) throws SQLException, ClassNotFoundException {
        return authorDao.deletee(obj);
    }

    @Override
    public Author search(String id) throws SQLException, ClassNotFoundException {
        return authorDao.search(id);
    }

    @Override
    public ObservableList<Author> getAll() throws SQLException, ClassNotFoundException {
        return authorDao.getAll();
    }

    @Override
    public ObservableList<Author> getAll(String searchBy, String value) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public String getAuthorCount() throws ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public ObservableList<Author> getAllAuthors() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public String getAuthorId() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public String getLastAuthorId() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean addAuthor(Author temp) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public ObservableList<Author> searchAuthor(String searchBy, String value) throws SQLException, ClassNotFoundException {
        return null;
    }
}