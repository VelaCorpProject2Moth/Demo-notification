package vn.vela.notifi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BeanConfiguration {

  /**
   * Rest template rest template.
   *
   * @return the rest template
   */
// khai bao bean de su dung rest template dung de call api trong spring
  @Bean
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }

}
