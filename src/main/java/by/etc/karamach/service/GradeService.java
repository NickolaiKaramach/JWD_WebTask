package by.etc.karamach.service;

import by.etc.karamach.bean.Grade;

public interface GradeService {
    Grade startTest(int userId, int testId) throws ServiceException;

    void finishTest(Grade grade, int userId) throws ServiceException;
}
