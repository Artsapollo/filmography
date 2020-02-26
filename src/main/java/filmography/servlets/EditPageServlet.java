package filmography.servlets;

import filmography.dao.FilmDAO;
import filmography.dao.jdbc.FilmDAOImpl;
import filmography.model.Film;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/editPageServlet")
public class EditPageServlet extends HttpServlet {
    FilmDAO filmDAO = new FilmDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.valueOf(req.getParameter("id"));
        req.setAttribute("film", filmDAO.getFilmById(id));
        req.getRequestDispatcher("/WEB-INF/views/edit.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.valueOf(req.getParameter("id"));
        String title = req.getParameter("title");
        int year = Integer.valueOf(req.getParameter("year"));
        String genre = req.getParameter("genre");
        boolean watched = Boolean.TRUE == req.getAttribute("watched");
        Film film = new Film();
        film.setId(id);
        film.setTitle(title);
        film.setYear(year);
        film.setGenre(genre);
        film.setWatched(watched);
        filmDAO.editFilm(film);
        resp.sendRedirect("/filmServlet");
    }
}
