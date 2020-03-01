package filmography.dao.jdbc;

import filmography.dao.UserDAO;
import filmography.model.User;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class UserDAOImpl implements UserDAO {
    private static String url = "jdbc:mysql://localhost:3306/filmography?serverTimezone=UTC";
    private static String login = "root";
    private static String password = "root";
    private static Connection connection;
    private static final String insert = "INSERT INTO user (`user_name`, `password`, `token`) VALUES (?,?,?)";

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
            statement.setString(3, user.getToken());
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
    public User checkIfExist(String login, String password) {
        PreparedStatement statement = null;
        Map<String, String> info = new HashMap<>();
        User user = new User();
        try {
            statement = connection.prepareStatement("SELECT * FROM user WHERE user_name = ? and password = ?");
            statement.setString(1, login);
            statement.setString(2, password);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                user.setUserName(rs.getString("user_name"));
                user.setPassword(rs.getString("password"));
                user.setToken(rs.getString("token"));
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
        return user;
    }

    @Override
    public User getByToken(String value) {
        PreparedStatement statement = null;
        User user = new User();
        try {
            statement = connection.prepareStatement("SELECT * FROM user WHERE token = ?");
            statement.setString(1, value);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                user.setUserName(rs.getString("user_name"));
                user.setPassword(rs.getString("password"));
                user.setToken(rs.getString("token"));
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
        return user;
    }

}
