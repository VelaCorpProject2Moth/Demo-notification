package vn.vela.notifi.exception;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BizException extends RuntimeException {

  List<String> errCodes;

  public BizException buildException(List<String> errCodes) {
    return new BizException(errCodes);
  }
}
