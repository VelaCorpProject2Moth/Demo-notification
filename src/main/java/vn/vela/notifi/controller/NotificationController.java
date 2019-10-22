package vn.vela.notifi.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.vela.notifi.dto.DeviceAddDto;
import vn.vela.notifi.dto.MessageDto;
import vn.vela.notifi.entity.Device;
import vn.vela.notifi.service.DeviceService;
import vn.vela.notifi.service.NotificationService;
import vn.vela.notifi.ultils.EntityValidUtils;

@RestController
@RequestMapping("/api/v1/notification")
public class NotificationController {

  @Autowired
  private DeviceService deviceService;

  @Autowired
  private NotificationService notificationService;

  @PostMapping("/save-device")
  public Device createNewDevice(@Valid @RequestBody DeviceAddDto deviceDto,
      BindingResult bindingResult) {
    EntityValidUtils.processBindingResults(bindingResult);
    return deviceService.saveDevice(deviceDto);
  }

  @PostMapping("/send-it-appp")
  public void sendNotiInApp(@RequestBody MessageDto messageDto) {
    notificationService.sendNotiInApp(messageDto);
  }

  @PostMapping("/send-out-app")
  public void sendNotiOutApp(@RequestBody MessageDto messageDto) {
    notificationService.sendOutApp(messageDto);
  }

}
