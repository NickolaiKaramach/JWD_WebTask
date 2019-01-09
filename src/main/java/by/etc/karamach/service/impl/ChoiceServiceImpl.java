package by.etc.karamach.service.impl;

import by.etc.karamach.bean.Grade;
import by.etc.karamach.dao.ChoiceDAO;
import by.etc.karamach.dao.DAOException;
import by.etc.karamach.dao.DAOFactory;
import by.etc.karamach.service.ChoiceService;
import by.etc.karamach.service.ServiceException;
import by.etc.karamach.service.validator.AnswerDataValidator;
import by.etc.karamach.service.validator.UserDataValidator;

public class ChoiceServiceImpl implements ChoiceService {
    private static final ChoiceDAO choiceDAO = DAOFactory.getInstance().getChoiceDAO();

    @Override
    public void makeChoice(Grade grade, int answerId, int userId, int questionId) throws ServiceException {
        boolean isValidData =
                AnswerDataValidator.isValidAnswerId(answerId) && UserDataValidator.isValidUserId(userId);

        if (!isValidData || (grade.getUserId() != userId)) {
            throw new ServiceException("Invalid request!");
        }

        try {

            choiceDAO.saveNewChoice(questionId, answerId, grade.getId());

        } catch (DAOException e) {

            throw new ServiceException(e);

        }


    }
}
