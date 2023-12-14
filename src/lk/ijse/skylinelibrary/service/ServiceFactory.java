package lk.ijse.skylinelibrary.service;

import lk.ijse.skylinelibrary.service.custom.impl.*;

public class ServiceFactory {
    private static ServiceFactory serviceFactory;
    private ServiceFactory(){}

    public static ServiceFactory getInstance(){
        if (serviceFactory==null)serviceFactory=new ServiceFactory();
        return serviceFactory;

    }

    public < T extends SuperService >T getService(ServiceType serviceType){
        switch (serviceType){
            case BOOK:return (T)new BookServiceImpl();
            case FINE:return (T)new FineServiceImpl();
            case AUTHOR:return (T)new AuthorSeviceImpl();
            case MEMBER:return (T)new MemberServiceImpl();
            case CATEGORY:return (T)new CategoryServiceImpl();
            case PRINTBILL:return (T)new PrintBillServiceImpl();
            case PUBLISHER:return (T)new PublisherServiceImpl();
            case EXPENDITURE:return (T)new ExpenditureServiceImpl();
            case BORROWBOOKRECORDS:return (T)new BorrowBookRecordsServiceImpl();
        }
        return null;
    }
}
