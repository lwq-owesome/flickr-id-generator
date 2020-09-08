package cn.jorden.flickr.generate;

import cn.jorden.flickr.properties.FlickrBusinessProperties;
import cn.jorden.flickr.properties.FlickrDatasourceProperties;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * <p>
 *
 * </p>
 *
 * @author jorden.li
 * @version 1.0
 * @since 2020-09-07 18:24
 */
@Component
@RequiredArgsConstructor
public class FlickrIdGenerate {

  private final JdbcTemplate flickrJdbcTemplate;

  private final FlickrBusinessProperties flickrBusinessProperties;

  private final FlickrDatasourceProperties flickrDatasourceProperties;

  private final   AtomicInteger atomicInteger=new AtomicInteger();

  public  static volatile boolean isNext= true;

  public Integer generateId() {

    if (!isNext){
      Integer  cunter = flickrJdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
      atomicInteger.set(cunter);
    }

    String businessKey = flickrBusinessProperties.getBusinessKey();

    String sql =
        "REPLACE INTO " + flickrDatasourceProperties.getTable() + " (stub) VALUES ('" + businessKey
            + "'); ";
    flickrJdbcTemplate.execute(sql);

    Integer cunter;
    if (atomicInteger.longValue()==0){
      cunter = flickrJdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
      atomicInteger.set(cunter);
     }else{
      cunter=atomicInteger.incrementAndGet();
    }

    return cunter;
  }
}
