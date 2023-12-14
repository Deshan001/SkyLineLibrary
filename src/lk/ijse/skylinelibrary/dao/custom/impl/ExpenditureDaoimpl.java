package lk.ijse.skylinelibrary.dao.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.skylinelibrary.dao.custom.ExpenditureDao;
import lk.ijse.skylinelibrary.to.Expenditure;
import lk.ijse.skylinelibrary.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ExpenditureDaoimpl implements ExpenditureDao {
    @Override
    public boolean add(Expenditure temp) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("insert into expenditure Values(?,?,?,?)",  temp.getDate(),temp.getTras_id(), temp.getAmount(),temp.getInvoice_no());
    }

    @Override
    public boolean update(Expenditure obj) throws SQLException, ClassNotFoundException {
        throw new RuntimeException("update function not available");
    }

    @Override
    public boolean deletee(String obj) throws SQLException, ClassNotFoundException {
        throw new RuntimeException("delete function not available");
    }

    @Override
    public Expenditure search(String ID) throws SQLException, ClassNotFoundException {
        throw new RuntimeException("search function not available");
    }

    @Override
    public ObservableList<Expenditure> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ObservableList<Expenditure> getAll(String searchBy, String value) throws SQLException, ClassNotFoundException {
        ResultSet rs = CrudUtil.execute("SELECT * from expenditure where "+searchBy+" Like '%"+value+"%'");
        ObservableList<Expenditure>list= FXCollections.observableArrayList();
        while(rs.next()){
            String date = rs.getString(1);
            String tras_id = rs.getString(2);
            String amount = rs.getString(3);
            String invoice_no = rs.getString(4);
            list.add(new Expenditure(date,tras_id,amount,invoice_no));

        }
        return list;
    }

    @Override
    public String getExpenditureCount() throws ClassNotFoundException, SQLException {
        ResultSet rs= CrudUtil.execute("SELECT count(Tras_Id) from expenditure");
        if(rs.next()){
            return rs.getString(1);
        }
        return null;
    }

    @Override
    public ObservableList<Expenditure> getAllExpenditure() throws SQLException, ClassNotFoundException {
        ResultSet rs = CrudUtil.execute("SELECT * from expenditure");
        ObservableList<Expenditure> list = FXCollections.observableArrayList();
        while(rs.next()){
            String date = rs.getString(1);
            String tras_id = rs.getString(2);
            String amount = rs.getString(3);
            String invoice_no = rs.getString(4);
            list.add(new Expenditure(date,tras_id,amount,invoice_no));
        }
        return  list;

    }

    @Override
    public String getTrasId() throws SQLException, ClassNotFoundException {
        String lastTrasId=getLastTrasId();
        if(lastTrasId==null){
            return "T-0001";
        }else{
            String[] split=lastTrasId.split("[T][-]");
            int lastDigits=Integer.parseInt(split[1]);
            lastDigits++;
            String newTrasId=String.format("T-%04d", lastDigits);
            return newTrasId;
        }
    }

    @Override
    public String getLastTrasId() throws SQLException, ClassNotFoundException {
        ResultSet rs = CrudUtil.execute("SELECT Tras_Id from expenditure order by Tras_Id DESC limit 1");
        if(rs.next()){
            return rs.getString(1);
        }
        return null;

    }
}
