package by.etc.karamach.logic.ServiceImpl;

import by.etc.karamach.bean.User;
import by.etc.karamach.cypher.PasswordDeCypher;
import by.etc.karamach.dao.DAOException;
import by.etc.karamach.dao.DAOFactory;
import by.etc.karamach.dao.UserDao;
import by.etc.karamach.logic.ServiceException;
import by.etc.karamach.logic.UserService;
import by.etc.karamach.validator.UserDataValidator;

public class UserServiceImpl implements UserService {
    @Override
    public User signIn(String login, String password) throws ServiceException {
        //TODO:Service - validation & logic
        password = PasswordDeCypher.decipherPassword(password);

        User user;

        if (isValidData(login, password)) {
            user = getSignInStatus(login, password);
        } else {
            throw new ServiceException("Not valid data!");
        }


        return user;
    }

    private boolean isValidData(String login, String password) {
        boolean isValidLogin;
        boolean isValidPassword;

        isValidLogin = UserDataValidator.isValidLogin(login);
        isValidPassword = UserDataValidator.isValidPassword(password);


        return isValidLogin && isValidPassword;
    }

    private User getSignInStatus(String login, String password) throws ServiceException {
        User user;

        try {
            user = DAOFactory.getInstance().getUserDAO().
                    signIn(login, password);
        } catch (DAOException e) {
            //TODO: LOG !
            throw new ServiceException("Cannot perform action with data source", e);
        }

        return user;
    }


    @Override
    public void register(User user) throws ServiceException {
        //TODO: Check user for his validness

        UserDao userDAO = DAOFactory.getInstance().getUserDAO();

        user.setPassword(PasswordDeCypher.decipherPassword(user.getPassword()));


        try {
            if (userDAO.findUserByLogin(user.getLogin()) == null) {

                userDAO.register(user);
            } else {
                throw new ServiceException("Login is already taken!");
            }
        } catch (DAOException e) {
            //TODO: LOG !
            throw new ServiceException("Cannot perform action with data source", e);
        }

    }

}
