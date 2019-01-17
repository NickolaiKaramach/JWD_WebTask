package by.etc.karamach.dao;

import by.etc.karamach.bean.User;

public interface UserDAO {
    User signIn(String email, String password) throws DAOException;

    void register(User user) throws DAOException;

    User findUserByEmail(String email) throws DAOException;

    void deleteTestUser(String userEmail) throws DAOException;
}
