package cn.jorden.flickr.autoconfigure;

import cn.jorden.flickr.properties.FlickrBusinessProperties;
import cn.jorden.flickr.properties.FlickrDatasourceProperties;
import com.alibaba.druid.pool.DruidDataSource;
import javax.sql.DataSource;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * <p>
 *
 * </p>
 *
 * @author jorden.li
 * @version 1.0
 * @since 2020-09-07 17:44
 */

@Configuration
@Import({FlickrDatasourceProperties.class, FlickrBusinessProperties.class})
@RequiredArgsConstructor
@Slf4j
public class FlickrDataSourceAutoConfiguration {

  private final FlickrDatasourceProperties flickrDatasourceProperties;


  @Bean
  public DataSource flickrDataSource() {
    log.info("flickrDataSource  init ....");
    DruidDataSource dataSource = new DruidDataSource();
    dataSource.setUrl(flickrDatasourceProperties.getUrl());
    dataSource.setUsername(flickrDatasourceProperties.getUsername());
    dataSource.setPassword(flickrDatasourceProperties.getPassword());
    dataSource.setDriverClassName(flickrDatasourceProperties.getDriverClassName());
    return dataSource;
  }

  @Bean
  @ConditionalOnMissingBean
  public JdbcTemplate flickrJdbcTemplate(DataSource flickrDataSource ){
    log.info("flickrDataSource  flickrJdbcTemplate ....");
    JdbcTemplate jdbc = new JdbcTemplate(flickrDataSource);
    return jdbc;
  }

}
