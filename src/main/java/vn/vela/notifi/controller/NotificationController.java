package vn.vela.notifi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.vela.notifi.dto.DeviceDto;
import vn.vela.notifi.entity.Device;
import vn.vela.notifi.service.DeviceService;

@RestController
@RequestMapping("/api/v1/notification")
public class NotificationController {

  @Autowired
  private DeviceService deviceService;

  @PostMapping("/save-device")
  public Device createNewDevice(@RequestBody DeviceDto deviceDto) {
    return deviceService.saveDevice(deviceDto);
  }

}
