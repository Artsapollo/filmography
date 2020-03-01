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
import java.util.List;

@WebServlet("/filmServlet")
public class FilmServlet extends HttpServlet {
    FilmService filmService = new FilmServiceImpl();
    UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        for (Cookie cookie : req.getCookies()) {
            if (cookie.getName().equals("USER_TOKEN")) {
                User user = userService.getByToken(cookie.getValue());
                if (user.getUserName() != null) {
                    List<Film> films = filmService.getAll();
                    req.setAttribute("films", films);
                    req.getRequestDispatcher("/WEB-INF/views/films.jsp").forward(req, resp);
                } else {
                    resp.sendRedirect("/mainPageServlet");
                }
            }
        }

    }
}
