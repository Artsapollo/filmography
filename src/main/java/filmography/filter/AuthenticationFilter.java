package filmography.filter;

import filmography.model.User;
import filmography.service.UserService;
import filmography.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

public class AuthenticationFilter implements Filter {
    private static final Logger logger = Logger.getLogger(AuthenticationFilter.class.getName());
    UserService userService = new UserServiceImpl();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        if (req.getCookies().length < 2) {
            for (Cookie cookie : req.getCookies()) {
                if (cookie.getName().equals("USER_TOKEN")) {
                    User user = userService.getByToken(cookie.getValue());
                    if (user.getUserName() != null) {
                        logger.info("User " + user.getUserName() + " was authenticated!");
                        filterChain.doFilter(servletRequest, servletResponse);
                    } else {
                        logger.info("User was not authenticated!");
                        processUnAuthenticated(resp);
                    }
                }
            }
        } else {
            processUnAuthenticated(resp);
        }
    }

    private void processUnAuthenticated(HttpServletResponse resp) {
        try {
            resp.sendRedirect("/mainPageServlet");
        } catch (IOException e) {
            logger.info("Can't get cookies from request!");
        }
    }

    @Override
    public void destroy() {

    }
}
