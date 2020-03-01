package filmography.servlets;

import filmography.model.Film;
import filmography.model.User;
import filmography.service.FilmService;
import filmography.service.UserService;
import filmography.service.impl.FilmServiceImpl;
import filmography.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/editPageServlet")
public class EditPageServlet extends HttpServlet {
    FilmService filmService = new FilmServiceImpl();
    UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.valueOf(req.getParameter("id"));
        req.setAttribute("film", filmService.getFilmById(id));
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
        filmService.editFilm(film);
        resp.sendRedirect("/filmServlet");
    }
}
