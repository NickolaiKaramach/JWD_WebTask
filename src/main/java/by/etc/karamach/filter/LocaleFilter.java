package by.etc.karamach.filter;

import by.etc.karamach.controller.RequestParameterName;
import by.etc.karamach.controller.SessionAttributeName;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "LocaleFilter", urlPatterns = {"/*"})
public class LocaleFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;

        String locale = req.getParameter(RequestParameterName.LOCALE);
        if (locale != null) {

            HttpSession session = req.getSession();

            session.setAttribute(SessionAttributeName.LOCALE, locale);

        }

        filterChain.doFilter(servletRequest, servletResponse);

    }

}
