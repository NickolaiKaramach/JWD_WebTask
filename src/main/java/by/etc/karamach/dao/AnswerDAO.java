package by.etc.karamach.dao;

import by.etc.karamach.bean.Answer;

import java.util.List;

public interface AnswerDAO {
    List<Answer> getAnswersByQuestionIdAndUserId(int questionId, int userId) throws DAOException;

    Answer getAnswerByAnswerIdAndUserId(int answerId, int userId) throws DAOException;

    void updateAnswer(int answerId, String description, boolean isRight) throws DAOException;

    void saveAnswer(int questionId, String description, boolean isRight) throws DAOException;

    void deleteAnswer(int answerId) throws DAOException;
}
