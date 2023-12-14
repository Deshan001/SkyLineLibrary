package lk.ijse.skylinelibrary.dao.custom;

import javafx.collections.ObservableList;
import lk.ijse.skylinelibrary.dao.CrudDao;
import lk.ijse.skylinelibrary.to.Member;

import java.sql.SQLException;

public interface MemberDao extends CrudDao<Member,String>  {

    ObservableList<Member> search(String searchBy, String value) throws SQLException, ClassNotFoundException;
    String getMemberCount() throws  ClassNotFoundException, SQLException;
    ObservableList<Member> getAllMembers() throws SQLException, ClassNotFoundException;
    String getMemberId() throws SQLException, ClassNotFoundException;
    String getLastMemberId() throws SQLException, ClassNotFoundException;
}
