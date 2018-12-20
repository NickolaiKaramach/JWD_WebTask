package by.etc.karamach.dao;

import by.etc.karamach.bean.Test;

import java.util.List;

public interface TestDAO {
    List<Test> getAllTests() throws DAOException;

    List<Test> getMyTests(int userId) throws DAOException;
}
