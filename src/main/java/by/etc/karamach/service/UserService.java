package by.etc.karamach.service;

import by.etc.karamach.bean.User;

import javax.servlet.http.HttpSession;

public interface UserService {
    User signIn(String login, String password) throws ServiceException;

    void register(User user) throws ServiceException;

    //TODO: QUESTION: In which class shell we place it?
    void saveUserToSession(HttpSession session, User user);
}
