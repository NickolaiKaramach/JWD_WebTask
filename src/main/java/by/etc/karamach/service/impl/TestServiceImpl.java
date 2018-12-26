package by.etc.karamach.service.impl;

import by.etc.karamach.bean.Test;
import by.etc.karamach.dao.DAOException;
import by.etc.karamach.dao.DAOFactory;
import by.etc.karamach.dao.TestDAO;
import by.etc.karamach.service.ServiceException;
import by.etc.karamach.service.TestService;
import by.etc.karamach.utils.validator.TestDataValidator;
import by.etc.karamach.utils.validator.UserDataValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class TestServiceImpl implements TestService {

    private static final TestDAO testDAO = DAOFactory.getInstance().getTestDAO();
    private static final Logger logger = LogManager.getLogger();

    @Override
    public List<Test> getAllTests() throws ServiceException {
        List<Test> resultTest;

        try {
            resultTest = testDAO.getAllTests();
        } catch (DAOException e) {

            logger.error(e.getMessage(), e);


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
        boolean isValidData =
                UserDataValidator.isValidUserId(userId) &&
                        TestDataValidator.isValidTestId(testId);

        if (!isValidData) {

            throw new ServiceException("Cannot delete test with giving data");
        }

        try {
            Test test = testDAO.getTest(testId);

            if ((test == null) || (test.getOwnerId() != userId)) {
                throw new ServiceException("Cannot delete test using your account");
            }

            testDAO.deleteTest(testId);


        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
}
