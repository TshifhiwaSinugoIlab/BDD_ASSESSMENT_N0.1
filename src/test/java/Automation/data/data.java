package Automation.data;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class data {

    public ResultSet ConnectAndQuerySQL(String sDBURL, String sUserName, String sPassword, String sQuery) {

        ResultSet rs = null;
        try {

            String dbURL = sDBURL;
            String user = sUserName;
            String pass = sPassword;
            java.sql.Connection conn = DriverManager.getConnection(dbURL, user, pass);
            Statement statem = conn.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = statem.executeQuery(sQuery);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return rs;
    }
}
