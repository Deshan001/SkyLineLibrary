package lk.ijse.skylinelibrary.dao.custom;

import javafx.collections.ObservableList;
import lk.ijse.skylinelibrary.dao.CrudDao;
import lk.ijse.skylinelibrary.to.Fine;
import lk.ijse.skylinelibrary.to.IncomeTable;

import java.sql.SQLException;
import java.util.HashMap;

public interface FineDao extends CrudDao<Fine,String> {
    ObservableList<Fine> getAllFine() throws SQLException, ClassNotFoundException;
    String getFineId() throws SQLException, ClassNotFoundException;
    String getLastFineId() throws SQLException, ClassNotFoundException;
    ObservableList<IncomeTable> getIncomeByDate(int value) throws SQLException, ClassNotFoundException;
    HashMap getIncomeBYMonth() throws SQLException, ClassNotFoundException;
}
