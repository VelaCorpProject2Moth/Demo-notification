package vn.vela.notifi.service.impl;

import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.vela.notifi.dto.DeviceAddDto;
import vn.vela.notifi.entity.Device;
import vn.vela.notifi.exception.BizException;
import vn.vela.notifi.repository.DeviceRepository;
import vn.vela.notifi.service.DeviceService;

@Service
@Transactional
public class DeviceServiceImpl implements DeviceService {

  @Autowired
  DeviceRepository deviceRepository;

  @Override
  public Device saveDevice(DeviceAddDto deviceDto) {
    // check neu token ton tai thi tra ve object --> truong hop refresh client
    Device deviceCheck = this.findByTokenId(deviceDto.getFirebaseDeviceToken());
    if (deviceCheck != null) {
      return deviceCheck;
    }
    Device device = Device.builder().firebaseDeviceToken(deviceDto.getFirebaseDeviceToken())
        .applicationKey(deviceDto.getApplicationKey()).createdBy(deviceDto.getCreatedBy())
        .endpoint(deviceDto.getEndpoint()).firebaseProjectName(deviceDto.getFirebaseProjectName())
        .oauth(deviceDto.getOauth()).p256dh(deviceDto.getP256dh())
        .updatedBy(deviceDto.getCreatedBy()).build();
    return deviceRepository.save(device);
  }

  @Override
  public Device findOneById(Long id) {
    return deviceRepository.findById(id).orElseThrow(
        () -> new BizException(Collections.singletonList("err.device.not-found"))
    );
  }

  private Device findByTokenId(String tokenId) {
    return deviceRepository.findByFirebaseDeviceToken(tokenId);
  }
}
