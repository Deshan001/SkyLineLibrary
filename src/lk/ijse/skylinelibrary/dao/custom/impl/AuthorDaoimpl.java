package lk.ijse.skylinelibrary.dao.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.skylinelibrary.dao.custom.AuthorDao;
import lk.ijse.skylinelibrary.to.Author;
import lk.ijse.skylinelibrary.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthorDaoimpl implements AuthorDao {
    @Override
    public boolean add(Author temp) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("insert into author Values(?,?,?,?)", temp.getId(), temp.getName(), temp.getSubject(),temp.getQualification());
    }

    @Override
    public boolean update(Author obj) throws SQLException, ClassNotFoundException {
        throw new RuntimeException("update function not available");
    }

    @Override
    public boolean deletee(String obj) throws SQLException, ClassNotFoundException {
        throw new RuntimeException("delete function not available");
    }

    @Override
    public Author search(String ID) throws SQLException, ClassNotFoundException {
        throw new RuntimeException("search function not available");
    }

    @Override
    public ObservableList<Author> getAll() throws SQLException, ClassNotFoundException {
        ResultSet rs = CrudUtil.execute("SELECT * from author");
        ObservableList<Author>list= FXCollections.observableArrayList();
        while(rs.next()){
            String id = rs.getString(1);
            String name = rs.getString(2);
            String subject = rs.getString(3);
            String qualification = rs.getString(4);
            list.add(new Author(id,name,subject,qualification));

        }
        return list;
    }

    @Override
    public ObservableList<Author> getAll(String searchBy, String value) throws SQLException, ClassNotFoundException {
        ResultSet rs = CrudUtil.execute("SELECT * from author where "+searchBy+" Like '%"+value+"%'");
        ObservableList<Author>list= FXCollections.observableArrayList();
        while(rs.next()){
            String id = rs.getString(1);
            String name = rs.getString(2);
            String subject = rs.getString(3);
            String qualification = rs.getString(4);
            list.add(new Author(id,name,subject,qualification));

        }
        return list;

    }

    @Override
    public String getAuthorCount() throws ClassNotFoundException, SQLException {
        ResultSet rs= CrudUtil.execute("SELECT count(Au_Id) from author");
        if(rs.next()){
            return rs.getString(1);
        }
        return null;
    }
}
