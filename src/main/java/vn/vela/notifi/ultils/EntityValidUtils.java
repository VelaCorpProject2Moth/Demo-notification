package vn.vela.notifi.ultils;

import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.BindingResult;
import vn.vela.notifi.exception.BizException;

public class EntityValidUtils {

  public static void processBindingResults(BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
      List<String> errors = new ArrayList<>();
      bindingResult.getAllErrors().forEach(
          err -> errors.add(err.getDefaultMessage())
      );
      throw new BizException(errors);
    }
  }

}
