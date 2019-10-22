package vn.vela.notifi.service;

import vn.vela.notifi.dto.MessageDto;

public interface FcmService {

  void sendNotiWithApiFcm(MessageDto messageDto);

}
