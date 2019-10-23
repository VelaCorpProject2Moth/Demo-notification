package vn.vela.notifi.config;

import javax.sql.DataSource;
import liquibase.integration.spring.SpringLiquibase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LiquibaseConfiguration {

  /**
   * The Application context.
   */
//  khai bao aplication context de lay thong tin bean spring sinh ra
  @Autowired
  ApplicationContext applicationContext;

  /**
   * Liquibase spring liquibase.
   *
   * @return the spring liquibase
   */
  @Bean
  public SpringLiquibase liquibase() {
    SpringLiquibase liquibase = new SpringLiquibase();
    liquibase.setChangeLog("classpath:liquibase/db.changelog-master.xml");
//    lay thong tin datasource ma spring da sinh ra, neu ko co phai khai bao bean de dung database
    liquibase.setDataSource((DataSource) applicationContext.getBean("dataSource"));
    return liquibase;
  }

}
