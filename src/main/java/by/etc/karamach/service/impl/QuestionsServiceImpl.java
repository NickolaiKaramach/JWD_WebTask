package by.etc.karamach.service.impl;

import by.etc.karamach.bean.Answer;
import by.etc.karamach.bean.Question;
import by.etc.karamach.bean.Test;
import by.etc.karamach.dao.*;
import by.etc.karamach.service.QuestionService;
import by.etc.karamach.service.ServiceException;
import by.etc.karamach.service.validator.QuestionDataValidator;
import by.etc.karamach.service.validator.TestDataValidator;
import by.etc.karamach.service.validator.UserDataValidator;

import java.util.List;

public class QuestionsServiceImpl implements QuestionService {

    private static final QuestionDAO questionDAO = DAOFactory.getInstance().getQuestionDAO();

    private static final AnswerDAO answerDAO = DAOFactory.getInstance().getAnswerDAO();

    private static final TestDAO testDAO = DAOFactory.getInstance().getTestDAO();

    @Override
    public void createQuestion(int testId, String description, int userId) throws ServiceException {

        //TODO: Maybe implement type of errors in error classes? By creating common super-class
        if (!QuestionDataValidator.isValidDescription(description)) {

            throw new ServiceException("Cannot operate with current description");

        }


        try {

            Test changingTest = testDAO.getTest(testId);


            if (changingTest.getOwnerId() != userId) {

                throw new ServiceException("Permission denied!");

            }

            questionDAO.createQuestion(testId, description, userId);


        } catch (DAOException e) {

            throw new ServiceException(e);

        }
    }

    @Override
    public void updateQuestionName(int questionId, String newName, int userId) throws ServiceException {
        getQuestionById(questionId, userId);

        try {

            questionDAO.updateQuestionName(questionId, newName);

        } catch (DAOException e) {

            throw new ServiceException(e);

        }
    }

    @Override
    public void deleteQuestion(int userId, int questionId) throws ServiceException {
        if (!isQuestionOwner(userId, questionId)) {
            throw new ServiceException("Cannot delete this test using your account");
        }


        try {

            questionDAO.deleteTest(questionId);

        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }


    @Override
    public Question getQuestionById(int questionId, int userId) throws ServiceException {
        boolean isValidData = UserDataValidator.isValidUserId(userId);

        if (!isValidData) {
            throw new ServiceException("Invalid data to perform action");
        }

        Question question;

        try {

            question = questionDAO.getQuestionByQuestionsIdAndUserId(questionId, userId);

            if (question == null) {
                throw new ServiceException("Such user don't have such question!");
            }


            List<Answer> answerList = answerDAO.getAnswersByQuestionIdAndUserId(questionId, userId);

            question.setAnswerList(answerList);


        } catch (DAOException e) {

            throw new ServiceException(e);
        }

        return question;
    }


    @Override
    public List<Question> getQuestionsByTestId(int testId) throws ServiceException {

        if (!TestDataValidator.isValidTestId(testId)) {
            throw new ServiceException("Invalid data!");
        }

        List<Question> questions;

        try {

            questions = questionDAO.getQuestionsByTestId(testId);

        } catch (DAOException e) {
            throw new ServiceException(e);
        }

        return questions;
    }

    private boolean isQuestionOwner(int userId, int questionId) throws ServiceException {

        boolean isValidData =
                UserDataValidator.isValidUserId(userId) &&
                        QuestionDataValidator.isValidQuestionId(questionId);

        if (!isValidData) {

            throw new ServiceException("Cannot perform action with giving data");
        }

        Question question;

        try {

            question = questionDAO.getQuestionByQuestionsIdAndUserId(questionId, userId);

        } catch (DAOException e) {

            throw new ServiceException(e);
        }

        return (question != null);
    }
}
