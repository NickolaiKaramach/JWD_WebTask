package by.etc.karamach.filter;

import by.etc.karamach.controller.JspPageName;
import by.etc.karamach.controller.SessionAttributeName;
import by.etc.karamach.utils.http.DispatchAssistant;
import by.etc.karamach.utils.http.DispatchException;
import by.etc.karamach.utils.http.SessionHelper;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@WebFilter(filterName = "UrlSecurityFilter", urlPatterns = {"/*"})
public class UrlSecurityFilter implements Filter {

    private Set<String> protectedUrl = new HashSet<>();

    @Override
    public void init(FilterConfig filterConfig) {
        protectedUrl.add("/jsp/userPage.jsp");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req;
        HttpServletResponse resp;

        req = (HttpServletRequest) servletRequest;
        resp = (HttpServletResponse) servletResponse;

        if (!protectedUrl.contains(req.getRequestURI())) {
            filterChain.doFilter(req, resp);
            return;
        }

        HttpSession existingSession = SessionHelper.getExistingSession(req);
        String userName = (String) existingSession.getAttribute(SessionAttributeName.NAME);

        if (userName == null) {
            try {
                DispatchAssistant.redirectToJsp(req, resp, JspPageName.LOGIN_PAGE);
            } catch (DispatchException e) {
                throw new ServletException(e);
            }

        } else {
            filterChain.doFilter(req, resp);
        }


    }
}
