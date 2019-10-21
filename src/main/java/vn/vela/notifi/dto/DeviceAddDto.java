package vn.vela.notifi.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeviceAddDto {

  @NotBlank(message = "err.add.device.firebaseProjectName-is-mandatory")
  private String firebaseProjectName;
  @NotBlank(message = "err.add.device.firebaseDeviceToken-is-mandatory")
  private String firebaseDeviceToken;
  @NotBlank(message = "err.add.device.endpoint-is-mandatory")
  private String endpoint;
  @NotBlank(message = "err.add.device.p256dh-is-mandatory")
  private String p256dh;
  @NotBlank(message = "err.add.device.oauth-is-mandatory")
  private String oauth;
  @NotBlank(message = "err.add.device.applicationKey-is-mandatory")
  private String applicationKey;
  @NotNull(message = "err.add.device.createdBy-is-mandatory")
  private Long createdBy;

}
