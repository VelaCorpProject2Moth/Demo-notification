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
  @NotNull(message = "err.send.notification.url-is-mandatory")
  private String url;
  @NotNull(message = "err.send.notification.icon-is-mandatory")
  private String icon;
  @NotNull(message = "err.send.notification.title-is-mandatory")
  private String title;
  private Long deviceId;
  @NotNull(message = "err.send.notification.platform-is-mandatory")
  private int platform;

}
