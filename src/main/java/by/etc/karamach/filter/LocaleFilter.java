package by.etc.karamach.filter;

import by.etc.karamach.controller.util.RequestParameterName;
import by.etc.karamach.controller.util.SessionAttributeName;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "LocaleFilter", urlPatterns = {"/*"})
public class LocaleFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        String locale = req.getParameter(RequestParameterName.LOCALE);
        if (locale != null) {

            HttpSession session = req.getSession();

            session.setAttribute(SessionAttributeName.LOCALE, locale);

            String lastUrl = (String) session.getAttribute(SessionAttributeName.LAST_URL);
            if (lastUrl != null) {
                resp.sendRedirect(lastUrl);
                return;
            }

        }

        filterChain.doFilter(servletRequest, servletResponse);

    }

}
