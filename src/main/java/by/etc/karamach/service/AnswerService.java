package by.etc.karamach.service;

import by.etc.karamach.bean.Answer;

import java.util.List;

public interface AnswerService {
    List<Answer> getAnswersByQuestionId(int questionId, int userId) throws ServiceException;

    Answer getAnswerById(int answerId, int userId) throws ServiceException;

    boolean updateAnswer(int answerId, String description, boolean isRight, int userId) throws ServiceException;

    void saveAnswer(int questionId, String description, boolean isRight, int userId) throws ServiceException;

    void deleteAnswer(int answerId, int userId) throws ServiceException;
}
