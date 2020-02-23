package filmography.dao.jdbc;

import filmography.dao.FilmDAO;
import filmography.model.Film;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FilmDAOImpl implements FilmDAO {

    private static String url = "jdbc:mysql://localhost:3306/filmography?serverTimezone=UTC";
    private static String login = "root";
    private static String password = "root";
    private static Connection connection;
    private static final String insert = "INSERT INTO films (`title`, `year`, `genre`, watched) VALUES (?,?,?,?)";
    private static final String select = "SELECT * FROM films";
    private static final String remove = "DELETE FROM films WHERE title=?";
    private static final String getById = "SELECT * FROM films WHERE id=?";
    private static final String update = "UPDATE films SET genre=? WHERE title=?";

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
    public List<Film> getAll() {
        List<Film> result = new ArrayList<>();
        Statement statement = null;
        String query = select;
        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                String title = rs.getString("title");
                int year = rs.getInt("year");
                String genre = rs.getString("genre");
                boolean watched = rs.getBoolean("watched");
                Film film = new Film();
                film.setTitle(title);
                film.setYear(year);
                film.setGenre(genre);
                film.setWatched(watched);
                result.add(film);
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
        return result;
    }

    @Override
    public void addFilm(Film film) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(insert);
            statement.setString(1, film.getTitle());
            statement.setInt(2, film.getYear());
            statement.setString(3, film.getGenre());
            statement.setBoolean(4, film.isWatched());
            statement.execute();
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

    @Override
    public void deleteFilm(Film film) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(remove);
            statement.setString(1, film.getTitle());
            statement.executeUpdate();
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

    @Override
    public void editFilm(Film film) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(update);
            statement.setString(1, film.getGenre());
            statement.setString(2, film.getTitle());
            statement.execute();
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

    @Override
    public Film getFilmById(int id) {
        Statement statement = null;
        Film film = new Film();
        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(getById);
            while (rs.next()) {
                String title = rs.getString("title");
                int year = rs.getInt("year");
                String genre = rs.getString("genre");
                boolean watched = rs.getBoolean("watched");
                film.setTitle(title);
                film.setYear(year);
                film.setGenre(genre);
                film.setWatched(watched);
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
        return film;
    }
}
