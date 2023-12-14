package lk.ijse.skylinelibrary.service.custom.impl;

import javafx.collections.ObservableList;
import lk.ijse.skylinelibrary.dao.DaoFactory;
import lk.ijse.skylinelibrary.dao.DaoType;
import lk.ijse.skylinelibrary.dao.custom.BookDao;
import lk.ijse.skylinelibrary.dao.custom.impl.BookDaoimpl;
import lk.ijse.skylinelibrary.service.custom.BookService;
import lk.ijse.skylinelibrary.to.Book;

import java.sql.SQLException;

public class BookServiceImpl implements BookService {
    private BookDao bookDao = DaoFactory.getInstance().getDao(DaoType.BOOK);

    @Override
    public ObservableList<Book> getAllBooks() throws SQLException, ClassNotFoundException {
        return bookDao.getAll();
    }

    @Override
    public String getBookCount() throws ClassNotFoundException, SQLException {
        return bookDao.getBookCount();//
    }

    @Override
    public String getBookId() throws SQLException, ClassNotFoundException {
        return bookDao.getBookId();
    }

    @Override
    public String getLastBookId() throws SQLException, ClassNotFoundException {
        return bookDao.getLastBookId();
    }

    @Override
    public boolean addBook(Book temp) throws SQLException, ClassNotFoundException {
        return bookDao.add(temp);
    }

    @Override
    public boolean updateBook(Book book) throws SQLException, ClassNotFoundException {
        return bookDao.update(book);
    }

    @Override
    public boolean deleteBook(String id) throws SQLException, ClassNotFoundException {
        return bookDao.deletee(id);
    }

    @Override
    public ObservableList<Book> searchBook(String searchBy, String value) throws SQLException, ClassNotFoundException {
        return bookDao.search(searchBy,value);
    }
}
