package filmography.servlets;

import filmography.model.User;
import filmography.service.UserService;
import filmography.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MainPageServlet extends HttpServlet {

    UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/main.jsp").forward(req, resp);
    }

    @Override //Проверяет существует ли такой аккаунт
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("user_name");
        String password = req.getParameter("password");
        User user = new User(login, password);

        if (userService.checkIfExist(user)) {//если да то открывает страницу с фильмами
            req.getRequestDispatcher("/WEB-INF/views/films.jsp").forward(req, resp);
        }else{//Если нет то предлагает зарегистрироваться
            resp.setContentType("text/html");
            PrintWriter out = resp.getWriter();
            out.println("<html><head><title>Oops</title></head><body>");
            out.println("<h2>Can't find your account. Please sing up</h2>");
            out.println("</body></html>");
            out.println(" <button onclick=\"location.href='/signUp'\">Sing up</button>");
        }

    }
}
