package by.etc.karamach.dao;

import by.etc.karamach.bean.User;

public interface UserDao {
    boolean signIn(String login, String password) throws DAOException;

    boolean register(User user) throws DAOException;
}
