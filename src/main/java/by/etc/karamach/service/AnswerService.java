package by.etc.karamach.service;

import by.etc.karamach.bean.Answer;

import java.util.List;

public interface AnswerService {
    List<Answer> getAnswersByQuestionId(int questionId, int userId) throws ServiceException;

    Answer getAnswerById(int answerId, int userId) throws ServiceException;
}
