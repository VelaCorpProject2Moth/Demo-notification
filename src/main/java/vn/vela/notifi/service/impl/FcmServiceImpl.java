package vn.vela.notifi.service.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import vn.vela.notifi.dto.FcmResponseDto;
import vn.vela.notifi.dto.MessageDto;
import vn.vela.notifi.entity.Device;
import vn.vela.notifi.service.DeviceService;
import vn.vela.notifi.service.FcmService;

@Service
@Transactional
@Log4j2
public class FcmServiceImpl implements FcmService {

  @Value("${firebase.url}")
  private String url;

  @Value(("${firebase.server_key}"))
  private String serverKey;

  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private DeviceService deviceService;

  @Override
  public void sendNotiWithApiFcm(MessageDto messageDto) {
    JsonObject fcmObject = buildMessage(messageDto);
    HttpEntity<String> entity = new HttpEntity<>(fcmObject.toString(), buildHeaders());
    ResponseEntity<FcmResponseDto> result = restTemplate
        .postForEntity(url, entity, FcmResponseDto.class);
    log.info("Send message result : " + result.toString() + "with body : " + result.getBody());
  }


  // xay dung object de send to fcm api
  private JsonObject buildMessage(MessageDto messageDto) {
    Gson gson = new GsonBuilder().create();
    JsonElement messElement = gson.toJsonTree(messageDto);
    String tokenId = getTokenId(messageDto.getDeviceId());
    JsonObject infoJson = new JsonObject();
    infoJson.add("notification", messElement);
    infoJson.addProperty("to", tokenId);
    return infoJson;
  }

  private String getTokenId(Long deviceId) {
    Device device = deviceService.findOneById(deviceId);
    return device.getFirebaseDeviceToken();
  }

  private HttpHeaders buildHeaders() {
    HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.setContentType(MediaType.APPLICATION_JSON);
    httpHeaders.add("Authorization", "key=" + serverKey);
    return httpHeaders;
  }
}
