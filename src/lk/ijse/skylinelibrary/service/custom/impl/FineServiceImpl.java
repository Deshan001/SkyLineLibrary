package lk.ijse.skylinelibrary.service.custom.impl;

import javafx.collections.ObservableList;
import lk.ijse.skylinelibrary.dao.DaoFactory;
import lk.ijse.skylinelibrary.dao.DaoType;
import lk.ijse.skylinelibrary.dao.custom.BookDao;
import lk.ijse.skylinelibrary.dao.custom.FineDao;
import lk.ijse.skylinelibrary.dao.custom.impl.BookDaoimpl;
import lk.ijse.skylinelibrary.dao.custom.impl.FineDaoimpl;
import lk.ijse.skylinelibrary.service.custom.FineService;
import lk.ijse.skylinelibrary.to.Fine;
import lk.ijse.skylinelibrary.to.IncomeTable;

import java.sql.SQLException;
import java.util.HashMap;

public class FineServiceImpl implements FineService {
    private FineDao fineDao = DaoFactory.getInstance().getDao(DaoType.FINE);
    @Override
    public boolean add(Fine obj) throws SQLException, ClassNotFoundException {
        return fineDao.add(obj);
    }

    @Override
    public boolean update(Fine obj) throws SQLException, ClassNotFoundException {
        return fineDao.update(obj);
    }

    @Override
    public boolean deletee(String obj) throws SQLException, ClassNotFoundException {
        return fineDao.deletee(obj);
    }

    @Override
    public Fine search(String id) throws SQLException, ClassNotFoundException {
        return fineDao.search(id);
    }

    @Override
    public ObservableList<Fine> getAll() throws SQLException, ClassNotFoundException {
        return fineDao.getAll();
    }

    @Override
    public ObservableList<Fine> getAllFine() throws SQLException, ClassNotFoundException {
        return fineDao.getAllFine();
    }

    @Override
    public String getFineId() throws SQLException, ClassNotFoundException {
        return fineDao.getFineId();
    }

    @Override
    public String getLastFineId() throws SQLException, ClassNotFoundException {
        return fineDao.getLastFineId();
    }

    @Override
    public boolean addFine(Fine temp) throws SQLException, ClassNotFoundException {
        return fineDao.add(temp);
    }

    @Override
    public ObservableList<IncomeTable> getIncomeByDate(int value) throws SQLException, ClassNotFoundException {
        return fineDao.getIncomeByDate(value);
    }

    @Override
    public HashMap getIncomeBYMonth() throws SQLException, ClassNotFoundException {
        return fineDao.getIncomeBYMonth();
    }
}
