package by.etc.karamach.logic;

import by.etc.karamach.bean.User;

public interface UserService {
    User signIn(String login, String password) throws ServiceException;

    void register(User user) throws ServiceException;
}
