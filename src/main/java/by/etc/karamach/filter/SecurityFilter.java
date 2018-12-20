package by.etc.karamach.filter;

import by.etc.karamach.controller.JspPageName;
import by.etc.karamach.controller.RequestParameterName;
import by.etc.karamach.controller.SessionAttributeName;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@WebFilter(filterName = "SecurityFilter", urlPatterns = {"/*"})
public class SecurityFilter implements Filter {

    private static final boolean DONT_CREATE_NEW_SESSION = false;
    private Set<String> notPublicCommands = new HashSet<>();

    @Override
    public void init(FilterConfig filterConfig) {
        notPublicCommands.add("CREATE_TEST");
        notPublicCommands.add("GET_MY_TESTS");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req;
        HttpServletResponse resp;

        req = (HttpServletRequest) servletRequest;
        resp = (HttpServletResponse) servletResponse;

        String command = req.getParameter(RequestParameterName.COMMAND_NAME);

        boolean continueChain = true;


        //TODO: Simplify
        if ((command != null) && (notPublicCommands.contains(command))) {

            HttpSession session = req.getSession(DONT_CREATE_NEW_SESSION);

            boolean isNotLoggedIn =
                    (session == null) ||
                            (session.getAttribute(SessionAttributeName.ID) == null);

            if (isNotLoggedIn) {
                redirectToJsp(req, resp, JspPageName.LOGIN_PAGE);
                continueChain = false;

            }

        }

        if (continueChain) {
            filterChain.doFilter(req, resp);
        }
    }

    private void redirectToJsp(HttpServletRequest req, HttpServletResponse resp, String jspPageName) {

        RequestDispatcher dispatcher = req.getRequestDispatcher(jspPageName);

        try {
            dispatcher.forward(req, resp);

        } catch (ServletException | IOException e) {
            //TODO: LOG!
        }
    }


}
