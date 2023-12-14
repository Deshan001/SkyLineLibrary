package lk.ijse.skylinelibrary.service.custom.impl;
import javafx.collections.ObservableList;
import lk.ijse.skylinelibrary.dao.DaoFactory;
import lk.ijse.skylinelibrary.dao.DaoType;
import lk.ijse.skylinelibrary.dao.custom.AuthorDao;
import lk.ijse.skylinelibrary.dao.custom.ExpenditureDao;
import lk.ijse.skylinelibrary.dao.custom.impl.AuthorDaoimpl;
import lk.ijse.skylinelibrary.dao.custom.impl.ExpenditureDaoimpl;
import lk.ijse.skylinelibrary.service.custom.ExpenditureService;
import lk.ijse.skylinelibrary.to.Expenditure;

import java.sql.SQLException;

public class ExpenditureServiceImpl implements ExpenditureService{
    private ExpenditureDao expenditureDao = DaoFactory.getInstance().getDao(DaoType.EXPENDITURE);

    @Override
    public boolean add(Expenditure obj) throws SQLException, ClassNotFoundException {
        return expenditureDao.add(obj);
    }

    @Override
    public boolean update(Expenditure obj) throws SQLException, ClassNotFoundException {
        return expenditureDao.update(obj);
    }

    @Override
    public boolean deletee(String obj) throws SQLException, ClassNotFoundException {
        return expenditureDao.deletee(obj);
    }

    @Override
    public Expenditure search(String id) throws SQLException, ClassNotFoundException {
        return expenditureDao.search(id);
    }

    @Override
    public ObservableList<Expenditure> getAll() throws SQLException, ClassNotFoundException {
        return expenditureDao.getAll();
    }

    @Override
    public String getExpenditureCount() throws ClassNotFoundException, SQLException {
        return expenditureDao.getExpenditureCount();
    }

    @Override
    public ObservableList<Expenditure> getAllExpenditure() throws SQLException, ClassNotFoundException {
        return expenditureDao.getAllExpenditure();
    }

    @Override
    public String getTrasId() throws SQLException, ClassNotFoundException {
        return expenditureDao.getTrasId();
    }

    @Override
    public String getLastTrasId() throws SQLException, ClassNotFoundException {
        return expenditureDao.getLastTrasId();
    }

    @Override
    public boolean addExpenditure(Expenditure temp) throws SQLException, ClassNotFoundException {
        return expenditureDao.add(temp);
    }

    @Override
    public ObservableList<Expenditure> searchExpenditure(String searchBy, String value) throws SQLException, ClassNotFoundException {
        return expenditureDao.getAll();
    }
}
