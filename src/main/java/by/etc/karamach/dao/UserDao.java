package by.etc.karamach.dao;

import by.etc.karamach.bean.User;

public interface UserDao {
    User signIn(String login, String password) throws DAOException;

    void register(User user) throws DAOException;

    User findUserByLogin(String login) throws DAOException;
}
