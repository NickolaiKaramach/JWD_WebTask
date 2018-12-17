package by.etc.karamach.dao;

import by.etc.karamach.bean.User;

public interface UserDao {
    User signIn(String email, String password) throws DAOException;

    boolean register(User user) throws DAOException;

    User findUserByEmail(String email) throws DAOException;
}
