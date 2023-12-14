package lk.ijse.skylinelibrary.service.custom.impl;

import javafx.collections.ObservableList;
import lk.ijse.skylinelibrary.dao.DaoFactory;
import lk.ijse.skylinelibrary.dao.DaoType;
import lk.ijse.skylinelibrary.dao.custom.MemberDao;
import lk.ijse.skylinelibrary.dao.custom.impl.MemberDaoimpl;
import lk.ijse.skylinelibrary.service.custom.MemberService;
import lk.ijse.skylinelibrary.to.Member;

import java.sql.SQLException;

public class MemberServiceImpl implements MemberService {
    MemberDao memberDao = DaoFactory.getInstance().getDao(DaoType.MEMBER);
    @Override
    public ObservableList<Member> getAllMembers() throws SQLException, ClassNotFoundException {
        return memberDao.getAllMembers();
    }

    @Override
    public String getMemberCount() throws ClassNotFoundException, SQLException {
        return "0";
    }

    @Override
    public String getMemberId() throws SQLException, ClassNotFoundException {
        return memberDao.getMemberId();
    }

    @Override
    public String getLastMemberId() throws SQLException, ClassNotFoundException {
        return memberDao.getLastMemberId();
    }

    @Override
    public boolean addMember(Member temp) throws SQLException, ClassNotFoundException {
        return memberDao.add(temp);
    }

    @Override
    public boolean updateMember(Member member) throws SQLException, ClassNotFoundException {
        return memberDao.update(member);
    }

    @Override
    public boolean deleteMember(String id) throws SQLException, ClassNotFoundException {
        return memberDao.deletee(id);
    }

    @Override
    public ObservableList<Member> searchMember(String searchBy, String value) throws SQLException, ClassNotFoundException {
        return memberDao.search(searchBy,value);
    }

    @Override
    public boolean add(Member obj) throws SQLException, ClassNotFoundException {
        return memberDao.add(obj);
    }

    @Override
    public boolean update(Member obj) throws SQLException, ClassNotFoundException {
        return memberDao.update(obj);
    }

    @Override
    public boolean deletee(String obj) throws SQLException, ClassNotFoundException {
        return memberDao.deletee(obj);
    }

    @Override
    public Member search(String id) throws SQLException, ClassNotFoundException {
        return memberDao.search(id);
    }

    @Override
    public ObservableList<Member> getAll() throws SQLException, ClassNotFoundException {
        return memberDao.getAll();
    }
}
