package by.etc.karamach.dao;

import by.etc.karamach.bean.User;
import by.etc.karamach.dao.pool.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class UserDaoTest {
    private static final UserDAO userDao = DAOFactory.getInstance().getUserDAO();
    private static final Logger logger = LogManager.getLogger();

    //Static init on ConnectionPool
    private static final ConnectionPool connectionPool = ConnectionPool.getInstance();
    private User testingUser;

    @BeforeTest
    public void setupUser() {
        User user = new User();

        String userName = "userName";
        String userEmail = "bad@man.com";
        String userPassword = "userPassword";

        user.setName(userName);
        user.setPassword(userPassword);
        user.setEmail(userEmail);

        testingUser = user;

    }

    @AfterMethod
    public void removeUserFromDataSource() {

        try {

            User userByEmail = userDao.findUserByEmail(testingUser.getEmail());


            if (userByEmail != null) {

                userDao.deleteTestUser(userByEmail.getEmail());

            }

        } catch (DAOException e) {

            logger.error(e);
            throw new RuntimeException("Error during executing @AfterMethod", e);

        }
    }

    @Test(description = "Register user in data source", groups = {"UserDao"})
    public void saveUser() {
        User userFound;
        try {

            userDao.register(testingUser);

            userFound = userDao.findUserByEmail(testingUser.getEmail());

        } catch (DAOException e) {

            logger.error(e);
            throw new RuntimeException(e);

        }

        boolean actual = (userFound == null);
        boolean expected = false;

        Assert.assertEquals(actual, expected);
    }

    @Test(description = "Should return only one result", groups = {"UserDao"})
    public void findOneUserByEmail() {


        User userFound;
        try {

            userDao.register(testingUser);

            userFound = userDao.findUserByEmail(testingUser.getEmail());

        } catch (DAOException e) {

            logger.error(e);
            throw new RuntimeException(e);

        }

        Assert.assertEquals(userFound.getEmail(), testingUser.getEmail());
    }

    @Test(description = "Imitation of 'sign in' ", groups = {"UserDao"})
    public void findByEmailAndPassword() {
        User userFound;
        try {

            userDao.register(testingUser);

            userFound = userDao.signIn(testingUser.getEmail(), testingUser.getPassword());

        } catch (DAOException e) {

            logger.error(e);
            throw new RuntimeException(e);

        }

        Assert.assertEquals(userFound.getEmail(), testingUser.getEmail());
    }

    @Test(description = "Testing util method that delete testing user", groups = {"UserDao"})
    public void deleteTestingUser() {
        User userFound;
        try {

            userDao.register(testingUser);

            userDao.deleteTestUser(testingUser.getEmail());

            userFound = userDao.signIn(testingUser.getEmail(), testingUser.getPassword());

        } catch (DAOException e) {

            logger.error(e);
            throw new RuntimeException(e);

        }

        boolean actual = (userFound == null);
        boolean expected = true;

        Assert.assertEquals(actual, expected);
    }
}
