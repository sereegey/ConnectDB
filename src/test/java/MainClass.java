import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;
import java.net.URL;

public class MainClass {
    private static final String USERNAME = "dexautomation";
    private static final String PASSWORD = "dexautomation";
    private static final String URL = "jdbc:mysql://db4free.net:3306/dexautomation";
    private static String studentFirsnName = "Vlad";
    private static String studentLastName = "Smirnov";
    private static Integer studentAge = 30;
    private static Long studentPhone = 89121237654L;
    public static void main (String[] args) throws SQLException {
        ConnectDatabase dbconnect = new ConnectDatabase();
        Connection connection = dbconnect.getConnection(URL, USERNAME, PASSWORD);
        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
        } catch (SQLException ex) {
            System.out.println("Ошибка регистрации драйвера");
            return;
        }
        try (Connection connect = DriverManager.getConnection(URL, USERNAME, PASSWORD); Statement statement = connect.createStatement()) {
            statement.execute("insert into dexautomation.Students (firstName, lastName, age, phone) values (\"Vlad\", \"Smirnov\", 30, 89121237654)");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        String query = "select * from dexautomation.Students where age = " +
                studentAge + " and phone = " + studentPhone + " and firstName like '" +
                studentFirsnName + "' and lastName like '" + studentLastName + "'";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                String firstName;
                String lastName;
                int age;
                long phone;
                firstName = resultSet.getString("firstName");
                lastName = resultSet.getString("lastName");
                age = resultSet.getInt("age");
                phone = resultSet.getLong("phone");
                Students students = new Students(firstName, lastName, age, phone);
                System.out.println(students);
            }
        statement.close();
        connection.close();
    }
}