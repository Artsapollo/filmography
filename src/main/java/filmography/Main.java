package filmography;

import filmography.model.User;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private static String url = "jdbc:mysql://localhost:3306/filmography?serverTimezone=UTC";
    private static String login = "root";
    private static String password = "root";
    private static Connection connection;
    private static final String insert = "INSERT INTO films (title, year, genre, watched) values (?,?,?,?)";
    String select = "SELECT * FROM user WHERE user_name = 'username' and password = 'password'";

    static {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, login, password);
            System.out.println("Connected!");
        } catch (Exception e) {
            System.out.println("Couldn't connect");
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        User user = new User("username", "password");
        PreparedStatement statement = null;
        try {


            statement = connection.prepareStatement("SELECT * FROM user WHERE user_name = ? and password = ?");
            statement.setString(1, user.getUserName());
            statement.setString(2, user.getPassword());
            ResultSet rs = statement.executeQuery();
            System.out.println();





        } catch (SQLException e) {
            System.out.println("SQL exception");
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    System.out.println("SQL exception when closing connection");
                }
            }
        }
    }
}
