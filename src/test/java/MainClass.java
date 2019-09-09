import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;
import java.net.URL;

public class MainClass {
    private static final String USERNAME = "dexautomation";
    private static final String PASSWORD = "dexautomation";
    private static final String URL = "jdbc:mysql://db4free.net:3306/dexautomation";
    private static String studentFirsnName = "Vladimir";
    private static String studentLastName = "Sidorov";
    private static Integer studentAge = 20;
    private static Long studentPhone = 89121234567L;
    public static void main (String[] args) throws SQLException {
        ConnectDatabase dbconnect = new ConnectDatabase();
        Connection connection = dbconnect.getConnection(URL, USERNAME, PASSWORD);
        String query = "select * from dexautomation.Students where age = " +
                studentAge + " and phone = " + studentPhone + " and firstName like '" +
                studentFirsnName + "' and lastName like '" + studentLastName + "'";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        //if (resultSet.next()){
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
      //  }
       // else{
       //     System.out.println("Искомая запись не найдена");
       // }

        statement.close();
        connection.close();
        /*try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
        } catch (SQLException ex) {
            System.out.println("Ошибка регистрации драйвера");
            return;
        }
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD); Statement statement = connection.createStatement()) {
            statement.execute("insert into dexautomation.Students (firstName, lastName, age, phone) values (\"Vladimir\", \"Sidorov\", 20, 89121234567)");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }*/
    }
}