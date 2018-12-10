package by.etc.karamach.logic.ServiceImpl;

import by.etc.karamach.bean.User;
import by.etc.karamach.dao.DAOException;
import by.etc.karamach.dao.DAOFactory;
import by.etc.karamach.dao.UserDao;
import by.etc.karamach.logic.ServiceException;
import by.etc.karamach.logic.UserService;
import by.etc.karamach.validator.UserDataValidator;

public class UserServiceImpl implements UserService {
    @Override
    public User signIn(String email, String password) throws ServiceException {
        //TODO:Service - validation & logic

        User user;

        if (isValidData(email, password)) {
            user = getSignInStatus(email, password);
        } else {
            throw new ServiceException("Not valid data!");
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

    private User getSignInStatus(String email, String password) throws ServiceException {
        User user;

        try {
            user = DAOFactory.getInstance().getUserDAO().
                    signIn(email, password);
        } catch (DAOException e) {
            //TODO: LOG !
            throw new ServiceException("Cannot perform action with data source", e);
        }

        return user;
    }


    @Override
    public void register(User user) throws ServiceException {
        //TODO: Check user for his validness
        if (UserDataValidator.isValidUserData(user)) {

            UserDao userDAO = DAOFactory.getInstance().getUserDAO();

            try {
                if (userDAO.findUserByEmail(user.getEmail()) == null) {

                    userDAO.register(user);
                } else {
                    throw new ServiceException("Email is already taken!");
                }
            } catch (DAOException e) {
                //TODO: LOG !
                throw new ServiceException("Cannot perform action with data source", e);
            }
        } else {
            throw new ServiceException("Invalid user data");
        }
    }

}
