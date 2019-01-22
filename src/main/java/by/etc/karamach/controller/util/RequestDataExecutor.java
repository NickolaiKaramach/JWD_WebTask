package by.etc.karamach.controller.util;


import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

public final class RequestDataExecutor {

    private static final String CHECKED_STATUS = "on";

    private RequestDataExecutor() {
    }


    public static Optional<String> getStringByName(String parameterName, HttpServletRequest req) {

        String string = req.getParameter(parameterName);

        return Optional.ofNullable(string);
    }

    public static Optional<Integer> getIntegerByName(String parameterName, HttpServletRequest req) {

        String object = req.getParameter(parameterName);

        Integer integer;
        if (object != null) {

            integer = Integer.valueOf(object);

        } else {


            integer = null;
        }

        return Optional.ofNullable(integer);
    }

    public static Optional<Boolean> getBooleanByName(String parameterName, HttpServletRequest req) {

        String parameter = req.getParameter(parameterName);

        return Optional.of((parameter != null) && (parameter.equals(CHECKED_STATUS)));
    }
}
