package vn.vela.notifi.entity;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.vela.notifi.entity.base.BaseEntity;
import vn.vela.notifi.entity.listen.BaseEntityListener;

@Entity
@Table(name = "device")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EntityListeners(BaseEntityListener.class)
public class Device extends BaseEntity {

  private String firebaseProjectName;
  private String firebaseDeviceToken;
  private String endpoint;
  private String p256dh;
  private String oauth;
  private String applicationKey;
  private Long createdBy;
  private Long updatedBy;

}
