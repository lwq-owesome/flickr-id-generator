package cn.jorden.flickr.autoconfigure;

import cn.jorden.flickr.generate.FlickrIdGenerate;
import cn.jorden.flickr.listener.ApplicationReadyEventListener;
import cn.jorden.flickr.listener.CloseListener;
import cn.jorden.flickr.properties.FlickrBusinessProperties;
import cn.jorden.flickr.properties.FlickrDatasourceProperties;
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
 * @since 2020-09-07 17:37
 */
@Configuration
@Import({FlickrDataSourceAutoConfiguration.class,
    ApplicationReadyEventListener.class,
    CloseListener.class
})
public class FlickrAutoConfiguration {

  @Bean
  public FlickrIdGenerate flickrIdGenerate(JdbcTemplate flickrJdbcTemplate,
      FlickrBusinessProperties flickrBusinessProperties,
      FlickrDatasourceProperties flickrDatasourceProperties) {
    FlickrIdGenerate flickrIdGenerate = new FlickrIdGenerate(flickrJdbcTemplate,flickrBusinessProperties,flickrDatasourceProperties);
    return flickrIdGenerate;
  }

}
