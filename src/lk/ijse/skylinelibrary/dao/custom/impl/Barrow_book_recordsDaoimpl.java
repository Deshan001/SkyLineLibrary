package lk.ijse.skylinelibrary.dao.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.skylinelibrary.dao.custom.Barrow_book_recordsDao;
import lk.ijse.skylinelibrary.to.BorrowedBookRecords;
import lk.ijse.skylinelibrary.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Barrow_book_recordsDaoimpl implements Barrow_book_recordsDao {
    @Override
    public boolean add(BorrowedBookRecords temp) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("insert into borrowed_book_records Values(?,?,?,?,?,?)", temp.getBorrowed_book_records_id(), temp.getM_id(), temp.getBook_id(),temp.getIssue_date(),temp.getReturn_date(),temp.getStatus());
    }

    @Override
    public boolean update(BorrowedBookRecords borrowedBookRecords) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("update borrowed_book_records set status = ? where " +
                "borrowed_book_records_id = ?",borrowedBookRecords.getStatus(),borrowedBookRecords.getBorrowed_book_records_id());

    }

    @Override
    public boolean deletee(String id) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("Delete from book where Book_Id = ?",id);
    }

    @Override
    public BorrowedBookRecords search(String ID) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ObservableList<BorrowedBookRecords> getAll() throws SQLException, ClassNotFoundException {
        ResultSet rs = CrudUtil.execute("SELECT * from borrowed_book_records where status = 'Away'");
        ObservableList<BorrowedBookRecords> list = FXCollections.observableArrayList();
        while(rs.next()){
            String borrowed_book_records_id = rs.getString(1);
            String m_id = rs.getString(2);
            String book_id = rs.getString(3);
            String issue_date= rs.getString(4);
            String return_date = rs.getString(5);
            String status = rs.getString(6);
            list.add(new BorrowedBookRecords(borrowed_book_records_id,m_id,book_id,issue_date,return_date,status));
        }
        return  list;
    }

    @Override
    public ObservableList<BorrowedBookRecords> getAll(String searchBy, String value) throws SQLException, ClassNotFoundException {
        ResultSet rs = CrudUtil.execute("SELECT * from borrowed_book_records where "+searchBy+" Like '%"+value+"%'");
        ObservableList<BorrowedBookRecords>list= FXCollections.observableArrayList();
        while(rs.next()){
            String borrowed_book_records_id = rs.getString(1);
            String m_id = rs.getString(2);
            String book_id = rs.getString(3);
            String issue_date= rs.getString(4);
            String return_date = rs.getString(5);
            String status = rs.getString(6);
            list.add(new BorrowedBookRecords(borrowed_book_records_id,m_id,book_id,issue_date,return_date,status));

        }
        return list;
    }

    @Override
    public String getBorrowedBookRecordsId() throws SQLException, ClassNotFoundException {
        String lastBorrowedBookRecordsId=getLastBorrowedBookRecordsId();
        if(lastBorrowedBookRecordsId==null){
            return "R-0001";
        }else{
            String[] split=lastBorrowedBookRecordsId.split("[R][-]");
            int lastDigits=Integer.parseInt(split[1]);
            lastDigits++;
            String newBorrowedBookRecordsId=String.format("R-%04d", lastDigits);
            return newBorrowedBookRecordsId;
        }
    }

    @Override
    public String getLastBorrowedBookRecordsId() throws SQLException, ClassNotFoundException {
        ResultSet rs = CrudUtil.execute("SELECT Borrowed_Book_Records_Id from borrowed_book_records order by Borrowed_Book_Records_Id DESC limit 1");
        if(rs.next()){
            return rs.getString(1);
        }
        return null;

    }

    @Override
    public String getRecordsCount() throws ClassNotFoundException, SQLException {
        ResultSet rs= CrudUtil.execute("SELECT count(Borrowed_Book_Records_Id) from borrowed_book_records");
        if(rs.next()){
            return rs.getString(1);
        }
        return null;
    }
}
