package filmography.servlets;

import filmography.service.FilmService;
import filmography.service.impl.FilmServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deletingServlet")
public class DeletingServlet extends HttpServlet {
    FilmService filmService = new FilmServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.valueOf(req.getParameter("id"));
        filmService.deleteFilm(id);
        resp.sendRedirect("/filmServlet");
    }
}
