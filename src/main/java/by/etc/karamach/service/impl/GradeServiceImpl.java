package by.etc.karamach.service.impl;

import by.etc.karamach.bean.Grade;
import by.etc.karamach.dao.ChoiceDAO;
import by.etc.karamach.dao.DAOException;
import by.etc.karamach.dao.DAOFactory;
import by.etc.karamach.dao.GradeDAO;
import by.etc.karamach.service.GradeService;
import by.etc.karamach.service.ServiceException;
import by.etc.karamach.service.validator.TestDataValidator;
import by.etc.karamach.service.validator.UserDataValidator;

import java.sql.Timestamp;
import java.util.List;

public class GradeServiceImpl implements GradeService {

    private static final GradeDAO gradeDAO = DAOFactory.getInstance().getGradeDAO();
    private static final ChoiceDAO choiceDAO = DAOFactory.getInstance().getChoiceDAO();

    private static final int SECOND = 1000;
    private static final int MINUTES = 60 * SECOND;
    private static final int TIME_FOR_TEST = MINUTES * 60;
    private static final double PERCENTS = 100.0;

    @Override
    public void deleteUnusedGrades() throws ServiceException {
        try {

            choiceDAO.deleteUnusedChoices();

            gradeDAO.deleteUnusedGrades();

        } catch (DAOException e) {

            throw new ServiceException(e);

        }
    }

    @Override
    public List<Grade> takeUserGrades(Integer userId) throws ServiceException {
        boolean isValidUserId = UserDataValidator.isValidUserId(userId);

        if (!isValidUserId) {
            throw new ServiceException("Illegal data found!");
        }

        List<Grade> gradeList;

        try {

            gradeList = gradeDAO.takeUserGrades(userId);

        } catch (DAOException e) {

            throw new ServiceException(e);

        }

        return gradeList;
    }

    @Override
    public void finishTest(Grade grade, int userId) throws ServiceException {
        boolean isValidUserId = UserDataValidator.isValidUserId(userId);

        if (((grade == null) || (grade.getUserId() != userId)) || !isValidUserId) {
            throw new ServiceException("Illegal data found!");
        }

        try {
            int allChoicesCount;
            allChoicesCount = choiceDAO.getCountAllChoicesByGrade(grade);

            int rightChoicesCount;
            rightChoicesCount = choiceDAO.getCountRightChoicesByGrade(grade);


            if ((allChoicesCount < 0) || (rightChoicesCount < 0)) {

                throw new ServiceException("Test was finished illegally");

            }

            double finishingGrade = rightChoicesCount * PERCENTS / allChoicesCount;
            int finishingDegree = (int) Math.round(finishingGrade);

            long currentTime = System.currentTimeMillis();
            Timestamp currentTimestamp = new Timestamp(currentTime);


            gradeDAO.finishGrade(finishingDegree, currentTimestamp, grade.getId());
        } catch (DAOException e) {

            throw new ServiceException(e);

        }
    }

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
