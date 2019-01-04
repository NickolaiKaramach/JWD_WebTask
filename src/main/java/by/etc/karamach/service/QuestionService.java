package by.etc.karamach.service;

import by.etc.karamach.bean.Question;

import java.util.List;

public interface QuestionService {
    List<Question> getQuestionsByTestId(int testId) throws ServiceException;


    Question getQuestionById(int questionId, int userId) throws ServiceException;

    void deleteQuestion(int userId, int questionId) throws ServiceException;

    void updateQuestionName(int questionId, String newName, int userId) throws ServiceException;

    void createQuestion(int testId, String description, int userId) throws ServiceException;
}
