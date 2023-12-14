package lk.ijse.skylinelibrary.service.custom.impl;

import javafx.collections.ObservableList;
import lk.ijse.skylinelibrary.dao.DaoFactory;
import lk.ijse.skylinelibrary.dao.DaoType;
import lk.ijse.skylinelibrary.dao.custom.Barrow_book_recordsDao;
import lk.ijse.skylinelibrary.dao.custom.impl.Barrow_book_recordsDaoimpl;
import lk.ijse.skylinelibrary.service.custom.BorrowBookRecordsService;
import lk.ijse.skylinelibrary.to.BorrowedBookRecords;

import java.sql.SQLException;

public class BorrowBookRecordsServiceImpl implements BorrowBookRecordsService {
    private Barrow_book_recordsDao bookRecordsDao = DaoFactory.getInstance().getDao(DaoType.BORROWBOOKRECORDS);
    @Override
    public ObservableList<BorrowedBookRecords> getAllBorrowedBookRecords() throws SQLException, ClassNotFoundException {
        return bookRecordsDao.getAll();
    }

    @Override
    public String getBorrowedBookRecordsId() throws SQLException, ClassNotFoundException {
        return bookRecordsDao.getBorrowedBookRecordsId();
    }

    @Override
    public ObservableList<BorrowedBookRecords> searchBorrowedBookRecords(String searchBy, String value) throws SQLException, ClassNotFoundException {
        return bookRecordsDao.getAll(searchBy, value);
    }

    @Override
    public String getRecordsCount() throws ClassNotFoundException, SQLException {
        return bookRecordsDao.getRecordsCount();
    }

    @Override
    public String getLastBorrowedBookRecordsId() throws SQLException, ClassNotFoundException {
        return bookRecordsDao.getLastBorrowedBookRecordsId();
    }

    @Override
    public boolean addBorrowedBookRecords(BorrowedBookRecords temp) throws SQLException, ClassNotFoundException {
        return bookRecordsDao.add(temp);
    }

    @Override
    public boolean updateStatus(BorrowedBookRecords borrowedBookRecords) throws SQLException, ClassNotFoundException {
        return bookRecordsDao.update(borrowedBookRecords);
    }

    @Override
    public String getDateDifference(String id) throws SQLException, ClassNotFoundException {
        return bookRecordsDao.getBorrowedBookRecordsId();
    }
}
