package lesson207.config;


import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.relational.core.mapping.event.BeforeSaveEvent;

import java.util.UUID;

@Configuration
public class PersistenceConfig {
    @Bean
    public ApplicationListener<BeforeSaveEvent> idGenerator() {
        return event -> {
            var entity = event.getEntity();
            if (entity instanceof GeneratedId) {
                var objEntity = ((GeneratedId) entity);
                if (objEntity.getId() == null ){
                    objEntity.setId(UUID.randomUUID().toString());
                }
            }
        };
    }
}
