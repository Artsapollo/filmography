package filmography.servlets;

import filmography.dao.FilmDAO;
import filmography.dao.jdbc.FilmDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deletingServlet")
public class DeletingServlet extends HttpServlet {
    FilmDAO filmDAO = new FilmDAOImpl();


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.valueOf(req.getParameter("id"));
        filmDAO.deleteFilm(id);
        resp.sendRedirect("/filmServlet");
    }
}
