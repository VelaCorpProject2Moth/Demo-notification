package vn.vela.notifi.exception.handler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import vn.vela.notifi.exception.BizException;
import vn.vela.notifi.exception.Error;
import vn.vela.notifi.exception.ErrorResponse;

@RestControllerAdvice
@Order(1)
public class BusinessExceptionHandler extends ResponseEntityExceptionHandler {

  @Autowired
  private MessageSource messageSource;


  @ExceptionHandler(BizException.class)
  public ErrorResponse handlerBusinessException(BizException ex, HttpServletRequest request) {
    List<Error> errors = new ArrayList<>();
    ex.getErrCodes().forEach(
        errCode -> {
          String errMessage = messageSource
              .getMessage(errCode, null, LocaleContextHolder.getLocale());
          errors.add(new Error(errCode, errMessage));
        }
    );

    return ErrorResponse.builder().errors(errors)
        .httpStatus(HttpStatus.OK.value()).url(request.getRequestURL().toString()).time(
            LocalDateTime.now()).build();
  }

}
