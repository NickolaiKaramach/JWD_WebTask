package by.etc.karamach.service.impl;

import by.etc.karamach.bean.Answer;
import by.etc.karamach.dao.AnswerDAO;
import by.etc.karamach.dao.DAOException;
import by.etc.karamach.dao.DAOFactory;
import by.etc.karamach.service.AnswerService;
import by.etc.karamach.service.ServiceException;
import by.etc.karamach.service.validator.AnswerDataValidator;
import by.etc.karamach.service.validator.UserDataValidator;

import java.util.List;

public class AnswerServiceImpl implements AnswerService {
    private static final AnswerDAO answerDAO = DAOFactory.getInstance().getAnswerDAO();

    @Override
    public List<Answer> getAnswersByQuestionId(int questionId, int userId) throws ServiceException {
        boolean isValidData = UserDataValidator.isValidUserId(userId);

        if (!isValidData) {
            throw new ServiceException("Invalid data to perform action");
        }

        List<Answer> answerList;

        try {

            answerList = answerDAO.getAnswersByQuestionIdAndUserId(questionId, userId);

        } catch (DAOException e) {

            throw new ServiceException(e);
        }


        return answerList;
    }

    @Override
    public boolean updateAnswer(int answerId, String description, boolean isRight, int userId) throws ServiceException {

        if (!AnswerDataValidator.isValidAnswerDescription(description)) {
            return false;
        }

        getAnswerById(answerId, userId);

        try {

            answerDAO.updateAnswer(answerId, description, isRight);

        } catch (DAOException e) {

            throw new ServiceException(e);

        }

        return true;
    }

    @Override
    public Answer getAnswerById(int answerId, int userId) throws ServiceException {
        boolean isValidData = UserDataValidator.isValidUserId(userId);

        if (!isValidData) {
            throw new ServiceException("Invalid data to perform action");
        }


        Answer answer;

        try {

            answer = answerDAO.getAnswerByAnswerIdAndUserId(answerId, userId);

            if (answer == null) {
                throw new ServiceException("Cannot edit not yours answer!");
            }

        } catch (DAOException e) {

            throw new ServiceException(e);
        }


        return answer;
    }
}
