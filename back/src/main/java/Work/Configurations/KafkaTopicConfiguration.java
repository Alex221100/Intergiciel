package Work.Configurations;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfiguration {

    @Bean
    public NewTopic createTopic1() {
        return TopicBuilder.name("Topic1")
                .build();
    }

    @Bean
    public NewTopic createTopic2() {
        return TopicBuilder.name("Topic2")
                .build();
    }

    @Bean
    public NewTopic createTopic3() {
        return TopicBuilder.name("Topic3")
                .build();
    }
}