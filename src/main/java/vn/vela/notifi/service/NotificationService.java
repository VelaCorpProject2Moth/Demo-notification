package vn.vela.notifi.service;

import vn.vela.notifi.dto.MessageDto;

public interface NotificationService {

  void sendNotiInApp(MessageDto messageDto);
}
