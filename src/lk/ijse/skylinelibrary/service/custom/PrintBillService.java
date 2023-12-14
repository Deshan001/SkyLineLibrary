package lk.ijse.skylinelibrary.service.custom;

import lk.ijse.skylinelibrary.service.SuperService;
import net.sf.jasperreports.engine.JRException;

import java.sql.Connection;
import java.util.HashMap;

public interface PrintBillService extends SuperService {
   void printBill(String query, String billpath, HashMap<String,Object>hm, Connection con, String savePath) throws JRException;
}
