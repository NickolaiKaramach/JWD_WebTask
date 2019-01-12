package by.etc.karamach.filter;

import by.etc.karamach.controller.util.DispatchAssistant;
import by.etc.karamach.controller.util.JspPageName;
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
        String userEmail = (String) existingSession.getAttribute(SessionAttributeName.PASSWORD);

        if (userEmail == null) {

            resp.sendRedirect(req.getContextPath() + JspPageName.LOGIN_PAGE);

        } else {
            filterChain.doFilter(req, resp);
        }


    }
}
