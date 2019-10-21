package vn.vela.notifi.dto;

import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MessageDto {

  @NotNull(message = "err.send.notification.productId-is-mandatory")
  private Long productId;
  private String url;
  private String icon;
  private String title;
  private Long deviceId;
  private int platform;

}
