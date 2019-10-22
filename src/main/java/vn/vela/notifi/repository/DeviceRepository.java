package vn.vela.notifi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.vela.notifi.entity.Device;

public interface DeviceRepository extends JpaRepository<Device, Long> {

  Device findByFirebaseDeviceToken(String tokenId);

}
