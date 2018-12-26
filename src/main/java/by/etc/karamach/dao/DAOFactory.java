package by.etc.karamach.dao;

import by.etc.karamach.dao.sql.impl.SQLQuestionDAO;
import by.etc.karamach.dao.sql.impl.SQLTestDAO;
import by.etc.karamach.dao.sql.impl.SQLUserDAO;

public class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();

    private final UserDAO sqlUserImpl = new SQLUserDAO();
    private final TestDAO sqlTestImpl = new SQLTestDAO();
    private final QuestionDAO sqlQuestionImpl = new SQLQuestionDAO();

    private DAOFactory() {

    }

    public static DAOFactory getInstance() {
        return instance;
    }

    public UserDAO getUserDAO() {
        return sqlUserImpl;
    }

    public TestDAO getTestDAO() {
        return sqlTestImpl;
    }

    public QuestionDAO getQuestionDAO() {
        return sqlQuestionImpl;
    }
}
