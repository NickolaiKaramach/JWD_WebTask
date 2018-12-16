package by.etc.karamach.service.impl;

import by.etc.karamach.bean.User;
import by.etc.karamach.controller.SessionAttributeName;
import by.etc.karamach.dao.DAOException;
import by.etc.karamach.dao.DAOFactory;
import by.etc.karamach.dao.UserDao;
import by.etc.karamach.service.ServiceException;
import by.etc.karamach.service.UserService;
import by.etc.karamach.utils.validator.UserDataValidator;

import javax.servlet.http.HttpSession;

public class UserServiceImpl implements UserService {
    private UserDao userDAO = DAOFactory.getInstance().getUserDAO();

    @Override
    public User signIn(String email, String password) throws ServiceException {
        //TODO:Service - validation & service
        User user;

        if (!isValidData(email, password)) {
            throw new ServiceException("Not valid data!");
        }

        user = getSignInStatus(email, password);

        return user;
    }

    @Override
    public void saveUserToSession(HttpSession session, User user) {
        session.setAttribute(SessionAttributeName.EMAIL, user.getEmail());
        session.setAttribute(SessionAttributeName.PASSWORD, user.getPassword());
        session.setAttribute(SessionAttributeName.ACCESS_LEVEL, user.getAccessLevel());
        session.setAttribute(SessionAttributeName.NAME, user.getName());
    }

    //TODO: Change to boolean and remove exception email taken
    @Override
    public void register(User user) throws ServiceException {
        //TODO: Check user for his validness
        if (!UserDataValidator.isValidUserData(user)) {
            throw new ServiceException("Invalid user data");
        }


        try {
            if (userDAO.findUserByEmail(user.getEmail()) != null) {
                throw new ServiceException("Email is already taken!");
            }

            userDAO.register(user);
        } catch (DAOException e) {
            //TODO: LOG !
            throw new ServiceException("Cannot perform action with data source", e);
        }
    }

    private boolean isValidData(String email, String password) {
        boolean isValidEmail;
        boolean isValidPassword;

        isValidEmail = UserDataValidator.isValidEmail(email);
        isValidPassword = UserDataValidator.isValidPassword(password);


        return isValidEmail && isValidPassword;
    }

    private User getSignInStatus(String email, String password) throws ServiceException {
        User user;

        try {
            user = userDAO.signIn(email, password);
        } catch (DAOException e) {
            //TODO: LOG !
            throw new ServiceException("Cannot perform action with data source", e);
        }

        return user;
    }

}
