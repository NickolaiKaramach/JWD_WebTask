package by.etc.karamach.service.impl;

import by.etc.karamach.bean.Test;
import by.etc.karamach.bean.TestStatus;
import by.etc.karamach.dao.DAOException;
import by.etc.karamach.dao.DAOFactory;
import by.etc.karamach.dao.TestDAO;
import by.etc.karamach.service.ServiceException;
import by.etc.karamach.service.TestService;
import by.etc.karamach.service.validator.TestDataValidator;
import by.etc.karamach.service.validator.UserDataValidator;

import java.util.List;

public class TestServiceImpl implements TestService {

    private static final TestDAO testDAO = DAOFactory.getInstance().getTestDAO();

    @Override
    public void publishTest(int testId, int userId) throws ServiceException {

        if (!isTestOwner(userId, testId)) {

            throw new ServiceException("Permission denied to that user!");

        }

        try {

            testDAO.changeTestStatus(testId, TestStatus.PUBLISHED);

        } catch (DAOException e) {

            throw new ServiceException(e);

        }
    }

    @Override
    public void updateTestName(int testId, String newName, int userId) throws ServiceException {

        if (!isTestOwner(userId, testId)) {
            throw new ServiceException("Permission denied!");
        }

        try {

            testDAO.updateTestName(testId, newName);

        } catch (DAOException e) {

            throw new ServiceException(e);

        }


    }

    @Override
    public List<Test> getAllTests() throws ServiceException {
        List<Test> resultTest;

        try {
            resultTest = testDAO.getAllTests();
        } catch (DAOException e) {

            throw new ServiceException(e);
        }

        return resultTest;
    }

    @Override
    public List<Test> getMyTests(int userId) throws ServiceException {

        boolean isValidUserId =
                UserDataValidator.isValidUserId(userId);

        if (!isValidUserId) {
            throw new ServiceException("Wrong user id!");
        }

        List<Test> resultTest;

        try {
            resultTest = testDAO.getMyTests(userId);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }

        return resultTest;
    }

    @Override
    public void saveNewTest(Test test) throws ServiceException {

        boolean isValidTestName =
                TestDataValidator.isValidTestName(test.getName());

        boolean isValidTestId =
                UserDataValidator.isValidUserId(test.getOwnerId());


        if ((!isValidTestId) || (!isValidTestName)) {
            throw new ServiceException("Wrong test data");
        }

        try {
            testDAO.saveNewTest(test);
        } catch (DAOException e) {

            throw new ServiceException(e);

        }

    }

    @Override
    public void deleteTest(int userId, int testId) throws ServiceException {

        if (!isTestOwner(userId, testId)) {
            throw new ServiceException("Cannot delete test using your account");
        }


        try {

            testDAO.deleteTest(testId);

        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean isTestOwner(int userId, int testId) throws ServiceException {

        boolean isValidData =
                UserDataValidator.isValidUserId(userId) &&
                        TestDataValidator.isValidTestId(testId);

        if (!isValidData) {

            throw new ServiceException("Cannot perform action with giving data");
        }

        Test test;

        try {

            test = testDAO.getTest(testId);

        } catch (DAOException e) {

            throw new ServiceException(e);
        }

        return ((test != null) && (test.getOwnerId() == userId));
    }

    @Override
    public Test getTestById(int testId) throws ServiceException {
        if (!TestDataValidator.isValidTestId(testId)) {

            throw new ServiceException("Cannot get test with giving data");
        }

        Test test;

        try {

            test = testDAO.getTest(testId);

        } catch (DAOException e) {

            throw new ServiceException(e);
        }

        return test;
    }
}
