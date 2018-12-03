package by.etc.karamach.dao.DAOImpl;

import by.etc.karamach.bean.User;
import by.etc.karamach.dao.DAOException;
import by.etc.karamach.dao.UserDao;

public class SQLUserDAO implements UserDao {
    @Override
    public boolean SignIn(String login, String password) throws DAOException {
        //TODO:DAO - Use db
        //TODO:Encrypt password
        return (login.equals("1")) && (password.equals("1"));
    }

    @Override
    public boolean Registration(User user) throws DAOException {
        return false;
    }
}
