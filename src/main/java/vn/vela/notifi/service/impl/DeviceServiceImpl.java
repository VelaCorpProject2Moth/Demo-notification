package vn.vela.notifi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.vela.notifi.dto.DeviceDto;
import vn.vela.notifi.entity.Device;
import vn.vela.notifi.repository.DeviceRepository;
import vn.vela.notifi.service.DeviceService;

@Service
@Transactional
public class DeviceServiceImpl implements DeviceService {

  @Autowired
  DeviceRepository deviceRepository;

  @Override
  public Device saveDevice(DeviceDto deviceDto) {
    Device device = Device.builder().firebaseDeviceToken(deviceDto.getFirebaseDeviceToken())
        .applicationKey(deviceDto.getApplicationKey()).createdBy(deviceDto.getCreatedBy())
        .endpoint(deviceDto.getEndpoint()).firebaseProjectName(deviceDto.getFirebaseProjectName())
        .oauth(deviceDto.getOauth()).p256dh(deviceDto.getP256dh())
        .updatedBy(deviceDto.getCreatedBy()).build();
    return deviceRepository.save(device);
  }
}
