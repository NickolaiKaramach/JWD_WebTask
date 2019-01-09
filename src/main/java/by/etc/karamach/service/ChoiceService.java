package by.etc.karamach.service;

import by.etc.karamach.bean.Grade;

public interface ChoiceService {
    void makeChoice(Grade grade, int answerId, int userId, int questionId) throws ServiceException;
}
