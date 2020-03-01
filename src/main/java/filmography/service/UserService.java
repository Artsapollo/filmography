package filmography.service;

import filmography.model.User;

public interface UserService {
    boolean signUp(User user);

    User checkIfExist(String login, String password);

    User getByToken(String value);

}
