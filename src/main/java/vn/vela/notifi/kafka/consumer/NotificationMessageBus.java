package vn.vela.notifi.kafka.consumer;

import lombok.extern.log4j.Log4j2;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.MessagingException;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;
import vn.vela.notifi.dto.MessageDto;
import vn.vela.notifi.service.FcmService;

@Component
@Log4j2
public class NotificationMessageBus {

  @Value("spring.kafka.consumer.group_id")
  private String groupId;

  private static final String CHANEL = "/topic/notifications";

  @Autowired
  private SimpMessagingTemplate template;

  @Autowired
  private FcmService fcmService;


  @KafkaListener(topics = "${spring.kafka.properties.topics.notification-topic}",
      groupId = "${spring.kafka.consumer.group-id}",
      containerFactory = "kafkaListenerContainerFactory")
  public void processMessage(ConsumerRecord pushMessage) {
    try {
      log.info("Consume message with event " + pushMessage.toString());
      MessageDto messageDto = (MessageDto) pushMessage.value();
      sendMessageSocket(messageDto);
    } catch (MessagingException e) {
      log.error("Convert and send message fail: " + e);
    }
  }

  @KafkaListener(topics = "${spring.kafka.properties.topics.out-app-topic}",
      groupId = "${spring.kafka.consumer.group-id}",
      containerFactory = "kafkaListenerContainerFactory")
  public void sendOutApp(ConsumerRecord pushMessage) {
    try {
      log.info("Consume message with event " + pushMessage.toString());
      MessageDto messageDto = (MessageDto) pushMessage.value();
      sendFcmApi(messageDto);
    } catch (MessagingException e) {
      log.error("Convert and send message fail: " + e);
    }
  }

  private void sendMessageSocket(MessageDto messageDto) {
    this.template
        .convertAndSend(CHANEL , messageDto);
  }

  private void sendFcmApi(MessageDto messageDto) {
    fcmService.sendNotiWithApiFcm(messageDto);
  }
}
