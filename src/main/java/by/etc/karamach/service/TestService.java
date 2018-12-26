package by.etc.karamach.service;

import by.etc.karamach.bean.Test;

import java.util.List;

public interface TestService {
    List<Test> getAllTests() throws ServiceException;

    List<Test> getMyTests(int userId) throws ServiceException;

    void saveNewTest(Test test) throws ServiceException;

    void deleteTest(int userId, int testId) throws ServiceException;
}
