package filmography.service.impl;

import filmography.dao.UserDAO;
import filmography.dao.jdbc.UserDAOImpl;
import filmography.model.User;
import filmography.service.UserService;

import java.util.Map;
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
    public boolean checkIfExist(User user) {
        Map<String, String> loginInfo = userDAO.checkIfExist(user);
        if (!loginInfo.isEmpty()) {
            return true;
        }
        return false;
    }
}
