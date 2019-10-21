package vn.vela.notifi.exception.handler;

import java.time.LocalDateTime;
import java.util.Collections;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Profile;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import vn.vela.notifi.exception.Error;
import vn.vela.notifi.exception.ErrorResponse;

@RestControllerAdvice
@Profile({"prod", "uat"})
@Order(2)
public class ProductionExceptionHandler {

  @Autowired
  private MessageSource messageSource;


  @ExceptionHandler(Exception.class)
  public ErrorResponse handleSystemError(Exception ex, HttpServletRequest request) {
    String errCode = "err.internal-server-error";
    String errMessage = messageSource.getMessage(errCode, null, LocaleContextHolder.getLocale());
    return ErrorResponse.builder().errors(Collections.singletonList(new Error(errCode, errMessage)))
        .httpStatus(
            HttpStatus.INTERNAL_SERVER_ERROR.value()).url(request.getRequestURL().toString()).time(
            LocalDateTime.now()).build();
  }
}
