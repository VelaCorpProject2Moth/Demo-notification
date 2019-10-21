package vn.vela.notifi.entity.listen;

import java.time.LocalDateTime;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import vn.vela.notifi.entity.base.BaseEntity;

public class BaseEntityListener {

  @PrePersist
  public void prepareBeforeCreate(BaseEntity baseEntity) {
    baseEntity.setCreatedAt(LocalDateTime.now());
    baseEntity.setUpdatedAt(LocalDateTime.now());
    baseEntity.setIsActive(true);
    baseEntity.setIsDeleted(false);
  }

  @PreUpdate
  public void prepareBeforeUpdate(BaseEntity baseEntity) {
    baseEntity.setUpdatedAt(LocalDateTime.now());
  }
}
