package vn.vela.notifi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.vela.notifi.dto.MessageDto;
import vn.vela.notifi.service.NotificationService;

@Service
@Transactional
public class NotificationServiceImpl implements NotificationService {

  @Autowired
  private KafkaTemplate kafkaTemplate;

  @Value("${spring.kafka.properties.topics.notification-topic}")
  private String inAppTopic;

  @Value("${spring.kafka.properties.topics.out-app-topic}")
  private String outAppTopic;

  @Override
  public void sendNotiInApp(MessageDto messageDto) {
    kafkaTemplate.send(inAppTopic, messageDto);
  }

  @Override
  public void sendOutApp(MessageDto messageDto) {
    kafkaTemplate.send(outAppTopic, messageDto);
  }
}
