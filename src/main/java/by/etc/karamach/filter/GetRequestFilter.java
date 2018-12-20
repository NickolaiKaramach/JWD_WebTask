package by.etc.karamach.filter;

import by.etc.karamach.controller.RequestAttributeName;
import by.etc.karamach.controller.command.CommandName;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(filterName = "GetRequestFilter", urlPatterns = {"/get/"})
public class GetRequestFilter implements Filter {

    private static final String PATH_COMMAND_TESTS = "/tests";
    private static final String PATH_COMMAND_MY_TESTS = "/tests/my";

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;

        String pathInfo = req.getPathInfo();

        //TODO: Simplify
        switch (pathInfo) {
            case PATH_COMMAND_TESTS:

                req.setAttribute(RequestAttributeName.COMMAND, CommandName.GET_TESTS.toString());
                break;

            case PATH_COMMAND_MY_TESTS:

                req.setAttribute(RequestAttributeName.COMMAND, CommandName.GET_MY_TESTS.toString());
                break;

        }

        filterChain.doFilter(req, servletResponse);

    }
}
