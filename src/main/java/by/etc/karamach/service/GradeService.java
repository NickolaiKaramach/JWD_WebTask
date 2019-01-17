package by.etc.karamach.service;

import by.etc.karamach.bean.Grade;

import java.util.List;

public interface GradeService {
    Grade startTest(int userId, int testId) throws ServiceException;

    void finishTest(Grade grade, int userId) throws ServiceException;

    List<Grade> takeUserGrades(Integer userId) throws ServiceException;

    void deleteUnusedGrades() throws ServiceException;
}
