package filmography.dao;

import filmography.model.User;

import java.util.Map;

public interface UserDAO {
    boolean signUp(User user);

    boolean checkIfExist(User user);
}
