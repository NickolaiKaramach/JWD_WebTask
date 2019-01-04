package by.etc.karamach.dao;

import by.etc.karamach.bean.Question;

import java.util.List;

public interface QuestionDAO {
    List<Question> getQuestionsByTestId(int testId) throws DAOException;

    Question getQuestionByQuestionsIdAndUserId(int questionId, int userId) throws DAOException;

    void deleteTest(int questionId) throws DAOException;

    void updateQuestionName(int questionId, String newName) throws DAOException;

    void createQuestion(int testId, String description, int userId) throws DAOException;
}
