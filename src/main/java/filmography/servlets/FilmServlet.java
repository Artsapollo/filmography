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
import java.util.List;

@WebServlet("/filmServlet")
public class FilmServlet extends HttpServlet {
    FilmDAO filmDAO = new FilmDAOImpl();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Film> films = filmDAO.getAll();
        req.setAttribute("films", films);
        req.getRequestDispatcher("/WEB-INF/views/films.jsp").forward(req, resp);
    }
}
