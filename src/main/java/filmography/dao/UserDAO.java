package filmography.dao;

import filmography.model.User;

import java.util.Map;

public interface UserDAO {
    boolean signUp(User user);

    Map<String, String> checkIfExist(User user);
}
