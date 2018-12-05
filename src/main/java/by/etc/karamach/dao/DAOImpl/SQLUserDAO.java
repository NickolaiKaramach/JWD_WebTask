package by.etc.karamach.dao.DAOImpl;

import by.etc.karamach.bean.User;
import by.etc.karamach.dao.UserDao;

public class SQLUserDAO implements UserDao {
    @Override
    public boolean signIn(String login, String password) {
        //TODO:DAO - Use connectionpool
        return (login.equals("1")) && (password.equals("1"));
    }

    @Override
    public boolean register(User user) {
        return false;
    }
}
