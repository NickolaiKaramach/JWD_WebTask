package by.etc.karamach.service;

import by.etc.karamach.service.impl.TestServiceImpl;
import by.etc.karamach.service.impl.UserServiceImpl;

public class ServiceFactory {

    private static final ServiceFactory instance = new ServiceFactory();

    private final UserService userService = new UserServiceImpl();
    private final TestService testService = new TestServiceImpl();

    private ServiceFactory() {
    }

    public static ServiceFactory getInstance() {
        return instance;
    }

    public UserService getUserService() {
        return userService;
    }

    public TestService getTestService() {
        return testService;
    }
}
