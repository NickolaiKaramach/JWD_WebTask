package by.etc.karamach.service.impl;

import by.etc.karamach.bean.User;
import by.etc.karamach.dao.DAOException;
import by.etc.karamach.dao.DAOFactory;
import by.etc.karamach.dao.UserDao;
import by.etc.karamach.service.ServiceException;
import by.etc.karamach.service.UserService;
import by.etc.karamach.utils.validator.UserDataValidator;

public class UserServiceImpl implements UserService {
    private UserDao userDAO = DAOFactory.getInstance().getUserDAO();

    @Override
    public User signIn(String email, String password) throws ServiceException {
        User user;

        if (!isValidData(email, password)) {
            throw new ServiceException("Not valid data!");
        }

        user = getSignInStatus(email, password);

        return user;
    }

    @Override
    public boolean register(User user) throws ServiceException {
        if (!UserDataValidator.isValidUserData(user)) {
            throw new ServiceException("Invalid user data");
        }


        try {

            boolean isBusyEmail =
                    !(userDAO.findUserByEmail(user.getEmail()) == null);

            if (isBusyEmail) {

                boolean saved = false;
                return saved;
            }


            userDAO.register(user);


        } catch (DAOException e) {
            //TODO: LOG !
            throw new ServiceException("Cannot perform action with data source", e);
        }


        boolean saved = true;
        return saved;
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


    private boolean isValidData(String email, String password) {
        boolean isValidEmail;
        boolean isValidPassword;

        isValidEmail = UserDataValidator.isValidEmail(email);
        isValidPassword = UserDataValidator.isValidPassword(password);


        return isValidEmail && isValidPassword;
    }

}
