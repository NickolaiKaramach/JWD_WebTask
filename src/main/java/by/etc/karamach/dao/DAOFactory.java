package by.etc.karamach.dao;

import by.etc.karamach.dao.sql.impl.*;

public class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();

    private final UserDAO sqlUserImpl = new SQLUserDAO();
    private final TestDAO sqlTestImpl = new SQLTestDAO();
    private final QuestionDAO sqlQuestionImpl = new SQLQuestionDAO();
    private final AnswerDAO sqlAnswerImpl = new SQLAnswerDAO();
    private final GradeDAO sqlGradeImpl = new SQLGradeDAO();
    private final ChoiceDAO sqlChoiceImpl = new SQLChoiceDAO();

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

    public AnswerDAO getAnswerDAO() {
        return sqlAnswerImpl;
    }

    public GradeDAO getGradeDAO() {
        return sqlGradeImpl;
    }

    public ChoiceDAO getChoiceDAO() {
        return sqlChoiceImpl;
    }
}
