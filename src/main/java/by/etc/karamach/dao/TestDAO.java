package by.etc.karamach.dao;

import by.etc.karamach.bean.Test;

import java.util.List;

public interface TestDAO {
    List<Test> getAllTests() throws DAOException;

    List<Test> getMyTests(int userId) throws DAOException;

    void saveNewTest(Test test) throws DAOException;

    Test getTest(int testId) throws DAOException;

    void deleteTest(int testId) throws DAOException;
}
