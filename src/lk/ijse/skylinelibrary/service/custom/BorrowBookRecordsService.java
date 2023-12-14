package lk.ijse.skylinelibrary.service.custom;

import javafx.collections.ObservableList;
import lk.ijse.skylinelibrary.service.SuperService;
import lk.ijse.skylinelibrary.to.BorrowedBookRecords;

import java.sql.SQLException;

public interface BorrowBookRecordsService extends SuperService {
    ObservableList<BorrowedBookRecords> getAllBorrowedBookRecords() throws SQLException, ClassNotFoundException;
    String getBorrowedBookRecordsId() throws SQLException, ClassNotFoundException;
    ObservableList<BorrowedBookRecords> searchBorrowedBookRecords(String searchBy, String value) throws SQLException, ClassNotFoundException;
    String getRecordsCount() throws  ClassNotFoundException, SQLException;
    String getLastBorrowedBookRecordsId() throws SQLException, ClassNotFoundException;
    boolean addBorrowedBookRecords(BorrowedBookRecords temp) throws SQLException, ClassNotFoundException;
    boolean updateStatus(BorrowedBookRecords borrowedBookRecords) throws SQLException, ClassNotFoundException;
    String getDateDifference(String id) throws SQLException, ClassNotFoundException;
}
