package by.etc.karamach.logic;

import by.etc.karamach.bean.User;

public interface UserService {
    boolean signIn(String login, String password) throws ServiceException;

    boolean register(User user) throws ServiceException;
}
