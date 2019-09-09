
import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.net.URL;
import java.sql.*;

public class ConnectDatabase {
    Connection connection;
    public ConnectDatabase() throws SQLException{
        Driver driver = new FabricMySQLDriver();
        DriverManager.registerDriver(driver);
    }
    public Connection getConnection(String url, String username, String password) throws SQLException{
        if (connection != null){
            return connection;
        }
        connection = DriverManager.getConnection (url, username, password);
        return connection;
    }
}
