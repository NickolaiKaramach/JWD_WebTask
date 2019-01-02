package by.etc.karamach.service.impl;

import by.etc.karamach.bean.Answer;
import by.etc.karamach.bean.Question;
import by.etc.karamach.dao.AnswerDAO;
import by.etc.karamach.dao.DAOException;
import by.etc.karamach.dao.DAOFactory;
import by.etc.karamach.dao.QuestionDAO;
import by.etc.karamach.service.QuestionService;
import by.etc.karamach.service.ServiceException;
import by.etc.karamach.service.validator.TestDataValidator;
import by.etc.karamach.service.validator.UserDataValidator;

import java.util.List;

public class QuestionsServiceImpl implements QuestionService {

    private static final QuestionDAO questionDAO = DAOFactory.getInstance().getQuestionDAO();

    private static final AnswerDAO answerDAO = DAOFactory.getInstance().getAnswerDAO();

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
}
