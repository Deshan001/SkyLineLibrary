package lk.ijse.skylinelibrary.service.custom.impl;

import javafx.collections.ObservableList;
import lk.ijse.skylinelibrary.dao.DaoFactory;
import lk.ijse.skylinelibrary.dao.DaoType;
import lk.ijse.skylinelibrary.dao.custom.BookDao;
import lk.ijse.skylinelibrary.dao.custom.PublisherDao;
import lk.ijse.skylinelibrary.dao.custom.impl.BookDaoimpl;
import lk.ijse.skylinelibrary.dao.custom.impl.PublisherDaoimpl;
import lk.ijse.skylinelibrary.service.custom.PublisherService;
import lk.ijse.skylinelibrary.to.Publisher;

import java.sql.SQLException;

public class PublisherServiceImpl implements PublisherService {
    private PublisherDao publisherDao = DaoFactory.getInstance().getDao(DaoType.PUBLISHER);

    @Override
    public boolean add(Publisher obj) throws SQLException, ClassNotFoundException {
        return publisherDao.add(obj);
    }

    @Override
    public boolean update(Publisher obj) throws SQLException, ClassNotFoundException {
        return publisherDao.update(obj);
    }

    @Override
    public boolean deletee(String obj) throws SQLException, ClassNotFoundException {
        return publisherDao.deletee(obj);
    }

    @Override
    public Publisher search(String id) throws SQLException, ClassNotFoundException {
        return publisherDao.search(id);
    }

    @Override
    public String getPublisherCount() throws ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public ObservableList<Publisher> getAllPublishers() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public String getPublisherId() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public String getLastPublisherId() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean addPublisher(Publisher temp) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public ObservableList<Publisher> searchPublisher(String searchBy, String value) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ObservableList<Publisher> getAll() throws SQLException, ClassNotFoundException {
        return publisherDao.getAll();
    }
}

