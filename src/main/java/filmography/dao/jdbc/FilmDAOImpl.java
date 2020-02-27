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
        PreparedStatement statement = null;
        String query = "SELECT * FROM films";
        try {
            statement = connection.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                int year = rs.getInt("year");
                String genre = rs.getString("genre");
                boolean watched = rs.getBoolean("watched");
                Film film = new Film();
                film.setId(id);
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
            statement = connection.prepareStatement("INSERT INTO films (`title`, `year`, `genre`, watched) VALUES (?,?,?,?)");
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
    public void editFilm(Film film) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("UPDATE films SET title = ?, year = ?, genre = ?, watched = ? WHERE id = ?");
            statement.setString(1, film.getTitle());
            statement.setInt(2, film.getYear());
            statement.setString(3, film.getGenre());
            statement.setBoolean(4, film.isWatched());
            statement.setInt(5, film.getId());
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
    public void deleteFilm(int id) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("DELETE FROM films WHERE id = ?");
            statement.setInt(1, id);
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
    public Film getFilmById(int id) {
        PreparedStatement statement = null;
        Film film = new Film();
        try {
            statement = connection.prepareStatement("SELECT * FROM films WHERE id = ?");
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String title = rs.getString("title");
                int year = rs.getInt("year");
                String genre = rs.getString("genre");
                boolean watched = rs.getBoolean("watched");
                film.setId(id);
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
