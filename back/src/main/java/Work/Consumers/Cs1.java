package Work.Consumers;

import Model.Summary;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.LongDeserializer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Collections;
import java.util.Properties;

@Service
public class Cs1 {

    @KafkaListener(topics = "Topic1", groupId = "group1")
    public void consume(String message) throws IOException {
        Summary result = new ObjectMapper().readValue(message, Summary.class);
        System.out.println("J'ai reçu : " + message);
    }
}
