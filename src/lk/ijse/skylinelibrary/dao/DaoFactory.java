package lk.ijse.skylinelibrary.dao;

import lk.ijse.skylinelibrary.dao.custom.impl.*;
import lk.ijse.skylinelibrary.service.ServiceFactory;
import lk.ijse.skylinelibrary.service.ServiceType;
import lk.ijse.skylinelibrary.service.SuperService;
import lk.ijse.skylinelibrary.service.custom.impl.*;

public class DaoFactory {
    private static DaoFactory daoFactory;

    private DaoFactory() {

    }

    public static DaoFactory getInstance() {
        if (daoFactory == null) daoFactory = new DaoFactory();
        return daoFactory;

    }

        public < T extends SuperDao >T getDao(DaoType daoType){
            switch (daoType){
                case BORROWBOOKRECORDS:return (T)new Barrow_book_recordsDaoimpl();
                case EXPENDITURE:return (T)new ExpenditureDaoimpl();
                case PUBLISHER:return (T)new PublisherDaoimpl();
                case CATEGORY:return (T)new CategoryDaoimpl();
                case MEMBER:return (T)new MemberDaoimpl();
                case AUTHOR:return (T)new AuthorDaoimpl();
                case FINE:return (T)new FineDaoimpl();
                case BOOK:return (T)new BookDaoimpl();

            }
            return null;

    }
}
