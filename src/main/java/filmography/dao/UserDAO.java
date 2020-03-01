package filmography.dao;

import filmography.model.User;

public interface UserDAO {
    boolean signUp(User user);

    User checkIfExist(String login, String password);

    User getByToken(String value);
}
