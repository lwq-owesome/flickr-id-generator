package cn.jorden.flickr.listener;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CloseListener implements ApplicationListener<ContextClosedEvent> {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        logger.info("程序停止");
    }
}
