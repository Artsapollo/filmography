package filmography.service;

import filmography.model.User;

public interface UserService {
    boolean signUp(User user);

    boolean checkIfExist(User user);

}
