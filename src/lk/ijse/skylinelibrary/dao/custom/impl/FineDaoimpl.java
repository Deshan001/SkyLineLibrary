package lk.ijse.skylinelibrary.dao.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.skylinelibrary.dao.custom.FineDao;
import lk.ijse.skylinelibrary.to.Fine;
import lk.ijse.skylinelibrary.to.IncomeTable;
import lk.ijse.skylinelibrary.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashMap;

public class FineDaoimpl implements FineDao {
    @Override
    public boolean add(Fine temp) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("insert into fine Values(?,?,?,?)", temp.getF_id(), temp.getBorrowed_book_records_id(), temp.getCost(), LocalDate.now());
    }

    @Override
    public boolean update(Fine obj) throws SQLException, ClassNotFoundException {
        throw new RuntimeException("update function not available");
    }

    @Override
    public boolean deletee(String obj) throws SQLException, ClassNotFoundException {
        throw new RuntimeException("delete function not available");
    }

    @Override
    public Fine search(String ID) throws SQLException, ClassNotFoundException {
        throw new RuntimeException("search function not available");
    }

    @Override
    public ObservableList<Fine> getAll() throws SQLException, ClassNotFoundException {
        throw new RuntimeException(" function not available");
    }

    @Override
    public ObservableList<Fine> getAllFine() throws SQLException, ClassNotFoundException {
        ResultSet rs = CrudUtil.execute("SELECT * from fine");
        ObservableList<Fine>list= FXCollections.observableArrayList();
        while(rs.next()){
            String f_id = rs.getString(1);
            String borrowed_book_records_id =rs.getString(2);
            double cost = rs.getDouble(3);
            list.add(new Fine(f_id,borrowed_book_records_id,cost));

        }
        return list;
    }

    @Override
    public String getFineId() throws SQLException, ClassNotFoundException {
        String lastFineId=getLastFineId();
        if(lastFineId==null){
            return "F-0001";
        }else{
            String[] split=lastFineId.split("[F][-]");
            int lastDigits=Integer.parseInt(split[1]);
            lastDigits++;
            String newFineId=String.format("F-%04d", lastDigits);
            return newFineId;
        }
    }

    @Override
    public String getLastFineId() throws SQLException, ClassNotFoundException {
        ResultSet rs = CrudUtil.execute("SELECT F_Id from fine order by F_Id DESC limit 1");
        if(rs.next()){
            return rs.getString(1);
        }
        return null;

    }

    @Override
    public ObservableList<IncomeTable> getIncomeByDate(int value) throws SQLException, ClassNotFoundException {
        ResultSet rs = CrudUtil.execute("SELECT (f.date),Sum(f.cost),Month(f.date) as month,Year(f.date) as Year from fine f " +
                "Group BY (date) having month = ? and year = ?", value,LocalDate.now().getYear());
        ObservableList<IncomeTable> list = FXCollections.observableArrayList();
        while(rs.next()){
            list.add(new IncomeTable(rs.getString(1),rs.getDouble(2)));
        }
        return list;

    }

    @Override
    public HashMap getIncomeBYMonth() throws SQLException, ClassNotFoundException {
        ResultSet rs = CrudUtil.execute("SELECT (f.date),Sum(f.cost),Month(f.date) as month,Year(f.date) as Year from fine f " +
                "Group BY (month) having year = ?  order by month", LocalDate.now().getYear());
        HashMap hm = new HashMap();
        while(rs.next()){
            hm.put(rs.getInt(3),rs.getDouble(2));
        }
        return hm;

    }
}
