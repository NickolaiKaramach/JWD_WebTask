package by.etc.karamach.filter;

import by.etc.karamach.controller.command.CommandName;
import by.etc.karamach.controller.util.*;

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

    private Set<String> protectedCommands = new HashSet<>();


    @Override
    public void init(FilterConfig filterConfig) {
        //TODO: Add all protected commands
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
        protectedCommands.add(CommandName.GET_MY_TESTS.toString());
        protectedCommands.add(CommandName.UPDATE_ANSWER.toString());
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

            DispatchAssistant.redirectToJsp(req, resp, JspPageName.LOGIN_PAGE);

            return;
        }


        filterChain.doFilter(req, resp);
    }

    private boolean isGuest(HttpSession session) {
        return (session == null) ||
                (session.getAttribute(SessionAttributeName.ID) == null);
    }


}
