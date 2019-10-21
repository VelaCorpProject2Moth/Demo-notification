package vn.vela.notifi.service;

import vn.vela.notifi.dto.DeviceDto;
import vn.vela.notifi.entity.Device;

public interface DeviceService {

  Device saveDevice(DeviceDto deviceDto);
}
