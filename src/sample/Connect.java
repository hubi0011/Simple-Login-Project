package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
    Connection connection;
    public  Connection getConnetion() {
          String URL = "";
          String UserName = "";
          String Password = "";
        try {
            connection = DriverManager.getConnection(URL, UserName, Password);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return connection;

    }
}
