package by.etc.karamach.service.impl;

import by.etc.karamach.bean.Question;
import by.etc.karamach.dao.DAOException;
import by.etc.karamach.dao.DAOFactory;
import by.etc.karamach.dao.QuestionDAO;
import by.etc.karamach.service.QuestionService;
import by.etc.karamach.service.ServiceException;
import by.etc.karamach.service.validator.TestDataValidator;

import java.util.List;

public class QuestionsServiceImpl implements QuestionService {

    private static final QuestionDAO questionDAO = DAOFactory.getInstance().getQuestionDAO();

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
