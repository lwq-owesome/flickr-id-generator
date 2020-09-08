package cn.jorden.flickr.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * <p>
 *
 * </p>
 *
 * @author jorden.li
 * @version 1.0
 * @since 2020-09-07 17:24
 */
@ConfigurationProperties(prefix = "jorden.flickr.business")
@Data
public class FlickrBusinessProperties {

  /**
   * 业务key，比如说 用户业务: user_center_business_key
   */
  private String businessKey;


}
