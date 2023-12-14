package lk.ijse.skylinelibrary.service.custom;

import javafx.collections.ObservableList;
import lk.ijse.skylinelibrary.service.SuperService;
import lk.ijse.skylinelibrary.to.Expenditure;

import java.sql.SQLException;

public interface ExpenditureService extends SuperService {
     String getExpenditureCount() throws  ClassNotFoundException, SQLException;
     ObservableList<Expenditure> getAllExpenditure() throws SQLException, ClassNotFoundException;
     String getTrasId() throws SQLException, ClassNotFoundException;
    String getLastTrasId() throws SQLException, ClassNotFoundException;
     boolean addExpenditure(Expenditure temp) throws SQLException, ClassNotFoundException;
     ObservableList<Expenditure> searchExpenditure(String searchBy, String value) throws SQLException, ClassNotFoundException;
    boolean add(Expenditure obj) throws SQLException, ClassNotFoundException;
    boolean update(Expenditure obj) throws SQLException, ClassNotFoundException;
    boolean deletee(String obj) throws SQLException, ClassNotFoundException;
    Expenditure search(String id) throws SQLException, ClassNotFoundException;
    ObservableList<Expenditure> getAll() throws SQLException, ClassNotFoundException;
}
