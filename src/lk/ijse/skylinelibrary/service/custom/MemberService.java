package lk.ijse.skylinelibrary.service.custom;

import javafx.collections.ObservableList;
import lk.ijse.skylinelibrary.service.SuperService;
import lk.ijse.skylinelibrary.to.Member;

import java.sql.SQLException;

public interface MemberService extends SuperService {
     ObservableList<Member> getAllMembers() throws SQLException, ClassNotFoundException;
     String getMemberCount() throws  ClassNotFoundException, SQLException;
     String getMemberId() throws SQLException, ClassNotFoundException;
    String getLastMemberId() throws SQLException, ClassNotFoundException;
     boolean addMember(Member temp) throws SQLException, ClassNotFoundException;
     boolean updateMember(Member member) throws SQLException, ClassNotFoundException;
     boolean deleteMember(String id) throws SQLException, ClassNotFoundException;
     ObservableList<Member> searchMember(String searchBy, String value) throws SQLException, ClassNotFoundException;
    ObservableList<Member> getAll() throws SQLException, ClassNotFoundException;
    Member search(String id) throws SQLException, ClassNotFoundException;
    boolean deletee(String obj) throws SQLException, ClassNotFoundException;
    boolean update(Member obj) throws SQLException, ClassNotFoundException;
    boolean add(Member obj) throws SQLException, ClassNotFoundException;
}
