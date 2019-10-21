package vn.vela.notifi.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import java.time.LocalDateTime;
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
public class ErrorResponse {

  private int httpStatus;
  private List<Error> errors;
  private String url;
  @JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
  private LocalDateTime time;
}
