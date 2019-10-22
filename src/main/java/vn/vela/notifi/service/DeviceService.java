package vn.vela.notifi.service;

import vn.vela.notifi.dto.DeviceAddDto;
import vn.vela.notifi.entity.Device;

public interface DeviceService {

  Device saveDevice(DeviceAddDto deviceDto);

  Device findOneById(Long id);
}
