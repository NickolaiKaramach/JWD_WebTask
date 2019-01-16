package by.etc.karamach.filter;

import by.etc.karamach.controller.util.RequestParameterName;
import by.etc.karamach.controller.util.SessionAttributeName;
import by.etc.karamach.controller.util.SessionHelper;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static by.etc.karamach.controller.util.SessionAttributeName.LOCALE;

@WebFilter(filterName = "LocaleFilter", urlPatterns = {"/*"})
public class LocaleFilter implements Filter {

    private static final String DEFAULT_LANG = "en";

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        HttpSession session = SessionHelper.createOrGetSession(req);

        String lastUrl;
        String locale = req.getParameter(RequestParameterName.LOCALE);
        if (locale != null) {

            session.setAttribute(LOCALE, locale);

            lastUrl = (String) session.getAttribute(SessionAttributeName.LAST_URL);
            if (lastUrl != null) {
                resp.sendRedirect(lastUrl);
                return;
            }

        } else {

            if (session.getAttribute(LOCALE) == null) {

                session.setAttribute(LOCALE, DEFAULT_LANG);

            }
        }

        filterChain.doFilter(servletRequest, servletResponse);

    }

}
