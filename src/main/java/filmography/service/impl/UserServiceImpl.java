package filmography.service.impl;

import filmography.dao.UserDAO;
import filmography.dao.jdbc.UserDAOImpl;
import filmography.model.User;
import filmography.service.UserService;

import java.util.Map;

public class UserServiceImpl implements UserService {

    private static UserDAO userDAO = new UserDAOImpl();

    @Override
    public boolean signUp(User user) {
        return userDAO.signUp(user);
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
