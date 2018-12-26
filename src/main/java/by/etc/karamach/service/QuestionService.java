package by.etc.karamach.service;

import by.etc.karamach.bean.Question;

import java.util.List;

public interface QuestionService {
    List<Question> getQuestionsByTestId(int testId) throws ServiceException;
}
