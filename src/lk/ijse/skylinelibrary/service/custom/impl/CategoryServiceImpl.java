package lk.ijse.skylinelibrary.service.custom.impl;

import javafx.collections.ObservableList;
import lk.ijse.skylinelibrary.dao.DaoFactory;
import lk.ijse.skylinelibrary.dao.DaoType;
import lk.ijse.skylinelibrary.dao.custom.BookDao;
import lk.ijse.skylinelibrary.dao.custom.CategoryDao;
import lk.ijse.skylinelibrary.dao.custom.impl.BookDaoimpl;
import lk.ijse.skylinelibrary.dao.custom.impl.CategoryDaoimpl;
import lk.ijse.skylinelibrary.service.custom.CategoryService;
import lk.ijse.skylinelibrary.to.Catagory;

import java.sql.SQLException;

public class CategoryServiceImpl implements CategoryService {
    private CategoryDao categoryDao = DaoFactory.getInstance().getDao(DaoType.CATEGORY);
    @Override
    public boolean add(Catagory obj) throws SQLException, ClassNotFoundException {
        return categoryDao.add(obj);
    }

    @Override
    public boolean update(Catagory obj) throws SQLException, ClassNotFoundException {
        return categoryDao.update(obj);
    }

    @Override
    public boolean deletee(String obj) throws SQLException, ClassNotFoundException {
        return categoryDao.deletee(obj);
    }

    @Override
    public Catagory search(String id) throws SQLException, ClassNotFoundException {
        return categoryDao.search(id);
    }

    @Override
    public ObservableList<Catagory> getAll() throws SQLException, ClassNotFoundException {
        return categoryDao.getAll();
    }

    @Override
    public String getCatagoryCount() throws ClassNotFoundException, SQLException {
        return categoryDao.getCatagoryCount();
    }

    @Override
    public ObservableList<Catagory> getAllCatagory() throws SQLException, ClassNotFoundException {
        return categoryDao.getAllCatagory();
    }

    @Override
    public String getCatagoryId() throws SQLException, ClassNotFoundException {
        return categoryDao.getCatagoryId();
    }

    @Override
    public String getLastcatagoryId() throws SQLException, ClassNotFoundException {
        return categoryDao.getLastcatagoryId();
    }

    @Override
    public ObservableList<Catagory> searchCatagory(String searchBy, String value) throws SQLException, ClassNotFoundException {
        return categoryDao.searchCatagory(searchBy,value);
    }

    @Override
    public boolean addCatagory(Catagory temp) throws SQLException, ClassNotFoundException {
        return addCatagory(temp);
    }
}
