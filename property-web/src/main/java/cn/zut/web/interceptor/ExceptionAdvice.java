package cn.zut.web.interceptor;

import cn.zut.common.exception.UserTokenException;
import cn.zut.common.generic.GenericResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author DaoyuanWang
 */
@ControllerAdvice
public class ExceptionAdvice {

    private final static Logger LOGGER = LoggerFactory.getLogger(ExceptionAdvice.class);

    @ResponseBody
    @ExceptionHandler(value = UserTokenException.class)
    public GenericResponse handleThrowable(UserTokenException e) {
        LOGGER.error(e.getMessage(), e);
        return GenericResponse.ILLEGAL_REQUEST;
    }

    @ResponseBody
    @ExceptionHandler(value = Throwable.class)
    public GenericResponse handleThrowable(Throwable e) {
        LOGGER.error(e.getMessage(), e);
        return GenericResponse.FAIL;
    }
}
