package vn.vela.notifi.dto;

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
public class DeviceDto {

  private String firebaseProjectName;
  private String firebaseDeviceToken;
  private String endpoint;
  private String p256dh;
  private String oauth;
  private String applicationKey;
  private Long createdBy;

}
