package by.etc.karamach.service;

import by.etc.karamach.bean.User;

public interface UserService {
    User signIn(String login, String password) throws ServiceException;

    boolean register(User user) throws ServiceException;

}
