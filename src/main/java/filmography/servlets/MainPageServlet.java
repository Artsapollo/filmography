package filmography.servlets;

import filmography.model.User;
import filmography.service.UserService;
import filmography.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/mainPageServlet")
public class MainPageServlet extends HttpServlet {

    UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/main.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("user_name");
        String password = req.getParameter("password");

        try {
            User user = userService.checkIfExist(login, password);
            Cookie cookie = new Cookie("USER_TOKEN", user.getToken());
            cookie.setMaxAge(1 * 60);
            resp.addCookie(cookie);
            resp.sendRedirect("/filmServlet");
        } catch (RuntimeException e) {
            req.setAttribute("errorMsg", "Incorrect login or password");
            req.getRequestDispatcher("/WEB-INF/views/main.jsp").forward(req, resp);
        }

    }
}
