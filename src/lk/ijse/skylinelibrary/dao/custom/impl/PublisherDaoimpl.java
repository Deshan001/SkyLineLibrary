package lk.ijse.skylinelibrary.dao.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.skylinelibrary.dao.custom.PublisherDao;
import lk.ijse.skylinelibrary.to.Publisher;
import lk.ijse.skylinelibrary.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PublisherDaoimpl implements PublisherDao {

    @Override
    public boolean add(Publisher temp) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("insert into publisher Values(?,?,?)", temp.getId(), temp.getName(), temp.getCountry());
    }

    @Override
    public boolean update(Publisher obj) throws SQLException, ClassNotFoundException {
        throw new RuntimeException("update function not available");
    }

    @Override
    public boolean deletee(String obj) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Publisher search(String ID) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ObservableList<Publisher> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ObservableList<Publisher> getAll(String searchBy, String value) throws SQLException, ClassNotFoundException {
        ResultSet rs = CrudUtil.execute("SELECT * from publisher where "+searchBy+" Like '%"+value+"%'");
        ObservableList<Publisher>list= FXCollections.observableArrayList();
        while(rs.next()){
            String id = rs.getString(1);
            String name = rs.getString(2);
            String country = rs.getString(3);
            list.add(new Publisher(id,name,country));
        }
        return list;
    }

    @Override
    public String getPublisherCount() throws ClassNotFoundException, SQLException {
        ResultSet rs= CrudUtil.execute("SELECT count(Pub_Id) from publisher");
        if(rs.next()){
            return rs.getString(1);
        }
        return null;

    }

    @Override
    public ObservableList<Publisher> getAllPublishers() throws SQLException, ClassNotFoundException {
        ResultSet rs = CrudUtil.execute("SELECT * from publisher");
        ObservableList<Publisher> list = FXCollections.observableArrayList();
        while(rs.next()){
            String id = rs.getString(1);
            String name = rs.getString(2);
            String country = rs.getString(3);
            list.add(new Publisher(id,name,country));
        }
        return  list;
    }

    @Override
    public String getPublisherId() throws SQLException, ClassNotFoundException {
        String lastPublisherId=getLastPublisherId();
        if(lastPublisherId==null){
            return "P-0001";
        }else{
            String[] split=lastPublisherId.split("[P][-]");
            int lastDigits=Integer.parseInt(split[1]);
            lastDigits++;
            String newPublisherId=String.format("P-%04d", lastDigits);
            return newPublisherId;
        }
    }

    @Override
    public String getLastPublisherId() throws SQLException, ClassNotFoundException {
        ResultSet rs = CrudUtil.execute("SELECT Pub_Id from publisher order by Pub_Id DESC limit 1");
        if(rs.next()){
            return rs.getString(1);
        }
        return null;

    }
}
