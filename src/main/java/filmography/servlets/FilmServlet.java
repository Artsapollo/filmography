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
import java.util.List;

@WebServlet("/filmServlet")
public class FilmServlet extends HttpServlet {
    FilmService filmService = new FilmServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Film> films = filmService.getAll();
        req.setAttribute("films", films);
        req.getRequestDispatcher("/WEB-INF/views/films.jsp").forward(req, resp);
    }
}
