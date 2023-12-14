package lk.ijse.skylinelibrary.dao.custom;

import javafx.collections.ObservableList;
import lk.ijse.skylinelibrary.dao.CrudDao;
import lk.ijse.skylinelibrary.to.BorrowedBookRecords;

import java.sql.SQLException;

public interface Barrow_book_recordsDao extends CrudDao<BorrowedBookRecords,String> {
    public ObservableList<BorrowedBookRecords> getAll(String searchBy, String value) throws SQLException, ClassNotFoundException;
    String getBorrowedBookRecordsId() throws SQLException, ClassNotFoundException;
    String getLastBorrowedBookRecordsId() throws SQLException, ClassNotFoundException;
    String getRecordsCount() throws  ClassNotFoundException, SQLException;
}
