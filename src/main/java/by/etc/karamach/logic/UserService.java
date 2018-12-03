package by.etc.karamach.logic;

import by.etc.karamach.bean.User;

public interface UserService {
    boolean SignIn(String login, String password) throws ServiceException;

    boolean Registration(User user) throws ServiceException;
}
