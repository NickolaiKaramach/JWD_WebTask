package by.etc.karamach.dao;

import by.etc.karamach.bean.Test;
import by.etc.karamach.bean.TestStatus;

import java.util.List;

public interface TestDAO {
    List<Test> getAllTests() throws DAOException;

    List<Test> getMyTests(int userId) throws DAOException;

    void saveNewTest(Test test) throws DAOException;

    Test getTest(int testId) throws DAOException;

    void deleteTest(int testId) throws DAOException;

    void updateTestName(int testId, String newName) throws DAOException;

    void changeTestStatus(int testId, TestStatus published) throws DAOException;
}
