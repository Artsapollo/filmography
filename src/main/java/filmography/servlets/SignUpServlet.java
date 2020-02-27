package filmography.servlets;

import filmography.dao.UserDAO;
import filmography.dao.jdbc.UserDAOImpl;
import filmography.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/signUpServlet")
public class SignUpServlet extends HttpServlet {
    UserDAO userDAO = new UserDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/signUp.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("user_name");
        String password = req.getParameter("password");
        User user = new User(username, password);
        if (userDAO.signUp(user)) {
            resp.sendRedirect("/mainPageServlet");
        }
    }
}
