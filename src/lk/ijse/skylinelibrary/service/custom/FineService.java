package lk.ijse.skylinelibrary.service.custom;

import javafx.collections.ObservableList;
import lk.ijse.skylinelibrary.dao.CrudDao;
import lk.ijse.skylinelibrary.service.SuperService;
import lk.ijse.skylinelibrary.to.Fine;
import lk.ijse.skylinelibrary.to.IncomeTable;

import java.sql.SQLException;
import java.util.HashMap;

public interface FineService extends SuperService {
    ObservableList<Fine> getAllFine() throws SQLException, ClassNotFoundException;
     String getFineId() throws SQLException, ClassNotFoundException;
    String getLastFineId() throws SQLException, ClassNotFoundException;
     boolean addFine(Fine temp) throws SQLException, ClassNotFoundException;
     ObservableList<IncomeTable> getIncomeByDate(int value) throws SQLException, ClassNotFoundException;
     HashMap getIncomeBYMonth() throws SQLException, ClassNotFoundException;
    boolean add(Fine obj) throws SQLException, ClassNotFoundException;
    boolean update(Fine obj) throws SQLException, ClassNotFoundException;
    boolean deletee(String obj) throws SQLException, ClassNotFoundException;
    Fine search(String id) throws SQLException, ClassNotFoundException;
    ObservableList<Fine> getAll() throws SQLException, ClassNotFoundException;
}
