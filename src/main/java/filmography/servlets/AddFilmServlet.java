package filmography.servlets;

import filmography.model.Film;
import filmography.service.FilmService;
import filmography.service.impl.FilmServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addFilmServlet")
public class AddFilmServlet extends HttpServlet {

    FilmService filmService = new FilmServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/add.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        int year = Integer.valueOf(req.getParameter("year"));
        String genre = req.getParameter("genre");
        boolean watched = Boolean.TRUE == req.getAttribute("watched");
        Film film = new Film();
        film.setTitle(title);
        film.setYear(year);
        film.setGenre(genre);
        film.setWatched(watched);
        filmService.addFilm(film);
        resp.sendRedirect("/filmServlet");
    }
}
