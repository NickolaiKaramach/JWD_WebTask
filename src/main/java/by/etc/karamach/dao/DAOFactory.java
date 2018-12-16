package by.etc.karamach.dao;

import by.etc.karamach.dao.impl.SQLUserDAO;

public class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();

    private final UserDao sqlUserImpl = new SQLUserDAO();

    private DAOFactory() {

    }

    public static DAOFactory getInstance() {
        return instance;
    }

    public UserDao getUserDAO() {
        return sqlUserImpl;
    }
}
