package by.etc.karamach.filter;

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
        protectedCommands.add("CREATE_TEST");
        protectedCommands.add("GET_MY_TESTS");
        protectedCommands.add("DELETE_TEST");
        protectedCommands.add("EDIT_TEST");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req;
        HttpServletResponse resp;

        req = (HttpServletRequest) servletRequest;
        resp = (HttpServletResponse) servletResponse;


        String command = req.getParameter(RequestParameterName.COMMAND_NAME);

        if ((command == null) || (!protectedCommands.contains(command))) {
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
