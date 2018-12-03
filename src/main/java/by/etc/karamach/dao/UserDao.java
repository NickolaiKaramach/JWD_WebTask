package by.etc.karamach.dao;

import by.etc.karamach.bean.User;

public interface UserDao {
    boolean SignIn(String login, String password) throws DAOException;

    boolean Registration(User user) throws DAOException;
}
