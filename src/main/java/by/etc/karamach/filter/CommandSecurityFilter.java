package by.etc.karamach.filter;

import by.etc.karamach.controller.command.CommandName;
import by.etc.karamach.controller.util.JspPageName;
import by.etc.karamach.controller.util.RequestParameterName;
import by.etc.karamach.controller.util.SessionAttributeName;
import by.etc.karamach.controller.util.SessionHelper;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;


@WebFilter(filterName = "SecurityFilter", urlPatterns = {"/*"})

public class CommandSecurityFilter implements Filter {

    private static final String ERROR_MSG_PATH_PARAM = "?errmsg=";
    private static final String LOGIN_REDIRECT_ERRMSG = "You should be logged in!";
    private Set<String> protectedCommands = new HashSet<>();


    @Override
    public void init(FilterConfig filterConfig) {
        protectedCommands.add(CommandName.CHANGE_QUESTION_NAME.toString());
        protectedCommands.add(CommandName.CHANGE_TEST_NAME.toString());

        protectedCommands.add(CommandName.CREATE_ANSWER.toString());
        protectedCommands.add(CommandName.CREATE_QUESTION.toString());
        protectedCommands.add(CommandName.CREATE_TEST.toString());

        protectedCommands.add(CommandName.DELETE_ANSWER.toString());
        protectedCommands.add(CommandName.DELETE_QUESTION.toString());
        protectedCommands.add(CommandName.DELETE_TEST.toString());

        protectedCommands.add(CommandName.EDIT_ANSWER.toString());
        protectedCommands.add(CommandName.EDIT_QUESTION.toString());
        protectedCommands.add(CommandName.EDIT_TEST.toString());

        protectedCommands.add(CommandName.TAKE_MY_TESTS.toString());
        protectedCommands.add(CommandName.TAKE_NEXT_QUESTION.toString());
        protectedCommands.add(CommandName.TAKE_USER_GRADES.toString());

        protectedCommands.add(CommandName.UPDATE_ANSWER.toString());
        protectedCommands.add(CommandName.PUBLISH_TEST.toString());
        protectedCommands.add(CommandName.PREPARE_FOR_TEST.toString());
        protectedCommands.add(CommandName.START_TEST.toString());
        protectedCommands.add(CommandName.MAKE_CHOICE.toString());
        protectedCommands.add(CommandName.FINISH_TEST.toString());
        protectedCommands.add(CommandName.LOGOUT.toString());
        protectedCommands.add(CommandName.GET_CURRENT_ASSESSMENT.toString());

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req;
        HttpServletResponse resp;

        req = (HttpServletRequest) servletRequest;
        resp = (HttpServletResponse) servletResponse;


        String command = req.getParameter(RequestParameterName.COMMAND_NAME);

        if ((command == null) || (!protectedCommands.contains(command.toUpperCase()))) {
            filterChain.doFilter(req, resp);
            return;
        }


        HttpSession existingSession = SessionHelper.getExistingSession(req);

        if (isGuest(existingSession)) {

            resp.sendRedirect(req.getContextPath() + JspPageName.LOGIN_PAGE + ERROR_MSG_PATH_PARAM + LOGIN_REDIRECT_ERRMSG);

            return;
        }


        filterChain.doFilter(req, resp);
    }

    private boolean isGuest(HttpSession session) {
        return (session == null) ||
                (session.getAttribute(SessionAttributeName.ID) == null);
    }


}
