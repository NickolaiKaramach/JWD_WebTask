package by.etc.karamach.filter;

import by.etc.karamach.controller.util.RequestParameterName;
import by.etc.karamach.controller.util.SessionAttributeName;
import by.etc.karamach.controller.util.SessionHelper;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "SaveLastRequestFilter", urlPatterns = {"/*"})
public class SaveLastRequestFilter implements Filter {

    private static final String JS_FILE_REGEX = "(.*)\\.js$";
    private static final String CSS_FILE_REGEX = "(.*)\\.css$";
    private static final String COMMAND_PATH_PARAM = "?command=";
    private static final String LOCALE_REQUEST = "?locale=";

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        filterChain.doFilter(servletRequest, servletResponse);

        HttpServletRequest request = (HttpServletRequest) servletRequest;

        HttpSession session = SessionHelper.createOrGetSession(request);


        StringBuffer requestURL = request.getRequestURL();

        if (((!requestURL.toString().matches(JS_FILE_REGEX)) &&
                (!requestURL.toString().matches(CSS_FILE_REGEX))) &&
                (!requestURL.toString().contains(LOCALE_REQUEST))) {

            String lastCommand = request.getParameter(RequestParameterName.COMMAND_NAME);

            if (lastCommand != null) {

                requestURL.append(COMMAND_PATH_PARAM).append(lastCommand);

            }

            session.setAttribute(SessionAttributeName.LAST_URL, requestURL.toString());

        }
    }
}
