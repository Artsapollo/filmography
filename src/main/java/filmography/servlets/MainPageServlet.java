package filmography.servlets;

import filmography.model.User;
import filmography.service.UserService;
import filmography.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
        User user = new User(login, password);

        if (userService.checkIfExist(user)) {
            resp.sendRedirect("/filmServlet");
            Cookie cookie = new Cookie("Login", user.getToken());
            resp.addCookie(cookie);
            resp.sendRedirect(req.getContextPath() + "/indexServlet");
        } else {
            req.setAttribute("errorMsg", "Incorrect login or password");
            req.getRequestDispatcher("/WEB-INF/views/main.jsp").forward(req, resp);

        }

    }
}
