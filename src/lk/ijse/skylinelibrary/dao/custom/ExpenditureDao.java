package lk.ijse.skylinelibrary.dao.custom;

import javafx.collections.ObservableList;
import lk.ijse.skylinelibrary.dao.CrudDao;
import lk.ijse.skylinelibrary.to.Expenditure;

import java.sql.SQLException;

public interface ExpenditureDao extends CrudDao<Expenditure,String> {
    ObservableList<Expenditure> getAll(String searchBy, String value) throws SQLException, ClassNotFoundException;
    String getExpenditureCount() throws  ClassNotFoundException, SQLException;
    ObservableList<Expenditure> getAllExpenditure() throws SQLException, ClassNotFoundException;
    String getTrasId() throws SQLException, ClassNotFoundException;
    String getLastTrasId() throws SQLException, ClassNotFoundException;
}
