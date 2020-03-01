package filmography.service.impl;

import filmography.dao.UserDAO;
import filmography.dao.jdbc.UserDAOImpl;
import filmography.model.User;
import filmography.service.UserService;

import java.util.UUID;

public class UserServiceImpl implements UserService {

    private static UserDAO userDAO = new UserDAOImpl();

    @Override
    public boolean signUp(User user) {
        user.setToken(getToken());
        return userDAO.signUp(user);
    }

    private String getToken() {
        return UUID.randomUUID().toString();
    }

    @Override
    public User checkIfExist(String login, String password) {
        User user = userDAO.checkIfExist(login, password);
        if (user.getUserName() != null) {
            return user;
        } else {
            throw new RuntimeException("User not found");
        }
    }

    @Override
    public User getByToken(String value) {
        return userDAO.getByToken(value);
    }
}
