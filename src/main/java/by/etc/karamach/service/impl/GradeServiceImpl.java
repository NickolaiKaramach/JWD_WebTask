package by.etc.karamach.service.impl;

import by.etc.karamach.bean.Grade;
import by.etc.karamach.dao.DAOException;
import by.etc.karamach.dao.DAOFactory;
import by.etc.karamach.dao.GradeDAO;
import by.etc.karamach.service.GradeService;
import by.etc.karamach.service.ServiceException;
import by.etc.karamach.service.validator.TestDataValidator;
import by.etc.karamach.service.validator.UserDataValidator;

import java.sql.Timestamp;

public class GradeServiceImpl implements GradeService {

    private static final GradeDAO gradeDAO = DAOFactory.getInstance().getGradeDAO();

    private static final int SECOND = 1000;
    private static final int MINUTES = 60 * SECOND;
    private static final int TIME_FOR_TEST = MINUTES * 60;

    @Override
    public Grade startTest(int userId, int testId) throws ServiceException {
        boolean isValidData =
                UserDataValidator.isValidUserId(userId) &&
                        TestDataValidator.isValidTestId(testId);

        if (!isValidData) {
            throw new ServiceException("Please be logged in, and access only available tests!");
        }

        Grade grade = new Grade();

        grade.setTestId(testId);
        grade.setUserId(userId);

        long currentTime = System.currentTimeMillis();
        Timestamp finishTime = new Timestamp(currentTime + TIME_FOR_TEST);

        grade.setFinishTime(finishTime);

        try {

            gradeDAO.saveNewGrade(grade);

        } catch (DAOException e) {

            throw new ServiceException(e);

        }

        return grade;
    }
}
