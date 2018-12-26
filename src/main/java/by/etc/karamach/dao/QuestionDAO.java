package by.etc.karamach.dao;

import by.etc.karamach.bean.Question;

import java.util.List;

public interface QuestionDAO {
    List<Question> getQuestionsByTestId(int testId) throws DAOException;
}
