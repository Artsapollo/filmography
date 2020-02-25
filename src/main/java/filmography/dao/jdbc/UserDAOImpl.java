package filmography.dao.jdbc;

import filmography.dao.UserDAO;
import filmography.model.User;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class UserDAOImpl implements UserDAO {
    private static String url = "jdbc:mysql://localhost:3306/filmography?serverTimezone=UTC";
    private static String login = "";
    private static String password = "";
    private static Connection connection;
    private static final String insert = "INSERT INTO user (`user_name`, `password`) VALUES (?,?)";

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

    @Override
    public boolean signUp(User user) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(insert);
            statement.setString(1, user.getUserName());
            statement.setString(2, user.getPassword());
            statement.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    System.out.println("SQL exception when closing connection");
                }
            }
        }
        return true;
    }

    @Override
    public Map<String, String> checkIfExist(User user) {
        PreparedStatement statement = null;
        Map<String, String> info = new HashMap<>();
        try {
            statement = connection.prepareStatement("SELECT * FROM user WHERE user_name = ? and password = ?");
            statement.setString(1, user.getUserName());
            statement.setString(2, user.getPassword());
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String login = rs.getString("user_name");
                String password = rs.getString("password");
                info.put(login, password);
            }
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
        return info;
    }
}
