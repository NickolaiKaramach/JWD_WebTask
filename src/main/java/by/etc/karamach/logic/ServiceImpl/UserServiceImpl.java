package by.etc.karamach.logic.ServiceImpl;

import by.etc.karamach.bean.User;
import by.etc.karamach.cypher.PasswordDeCypher;
import by.etc.karamach.dao.DAOException;
import by.etc.karamach.dao.DAOFactory;
import by.etc.karamach.logic.ServiceException;
import by.etc.karamach.logic.UserService;
import by.etc.karamach.validator.UserDataValidator;

public class UserServiceImpl implements UserService {
    @Override
    public boolean signIn(String login, String password) throws ServiceException {
        //TODO:Service - validation & logic

        password = PasswordDeCypher.decipherPassword(password);

        boolean isValidLogin;
        boolean isValidPassword;

        isValidLogin = UserDataValidator.isValidLogin(login);
        isValidPassword = UserDataValidator.isValidPassword(password);

        boolean status;

        if (isValidLogin && isValidPassword) {
            status = getSignInStatus(login, password);
        } else {
            throw new ServiceException("Not correct data!");
        }



        return status;
    }

    private boolean getSignInStatus(String login, String password) throws ServiceException {
        boolean status;

        try {

            status = DAOFactory.getInstance().getUserDAO().
                    signIn(login, password);
        } catch (DAOException e) {
            //TODO: LOG !
            throw new ServiceException("Cannot perform action with data source");
        }

        return status;
    }


    @Override
    public boolean register(User user) throws ServiceException {
        //TODO: Check user for his validness

        boolean status;

        status = getRegistrationStatus(user);

        return status;
    }

    private boolean getRegistrationStatus(User user) throws ServiceException {
        boolean status;

        try {

            status = DAOFactory.getInstance().getUserDAO().
                    register(user);
        } catch (DAOException e) {
            //TODO: LOG !
            throw new ServiceException("Cannot perform action with data source");
        }

        return status;
    }
}
