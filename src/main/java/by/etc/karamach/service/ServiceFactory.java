package by.etc.karamach.service;

import by.etc.karamach.service.impl.*;

public class ServiceFactory {

    private static final ServiceFactory instance = new ServiceFactory();

    private final UserService userService = new UserServiceImpl();
    private final TestService testService = new TestServiceImpl();
    private final QuestionService questionService = new QuestionsServiceImpl();
    private final AnswerService answerService = new AnswerServiceImpl();
    private final GradeService gradeService = new GradeServiceImpl();
    private final ChoiceService choiceService = new ChoiceServiceImpl();

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

    public QuestionService getQuestionService() {
        return questionService;
    }

    public AnswerService getAnswerService() {
        return answerService;
    }

    public GradeService getGradeService() {
        return gradeService;
    }

    public ChoiceService getChoiceService() {
        return choiceService;
    }
}
