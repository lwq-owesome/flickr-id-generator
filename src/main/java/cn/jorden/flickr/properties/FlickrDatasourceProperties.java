package cn.jorden.flickr.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * <p>
 *
 * </p>
 *
 * @author jorden.li
 * @version 1.0
 * @since 2020-09-07 17:24
 */
@ConfigurationProperties(prefix = "jorden.flickr.datasource")
@Data
public class FlickrDatasourceProperties {

  private  String password;


  private  String url;


  private  String username;


  private  String driverClassName;


  private  String table;

}
