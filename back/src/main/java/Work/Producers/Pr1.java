package Work.Producers;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


@Service
public class Pr1 {

    private static final String TOPIC = "Topic1";

    private KafkaTemplate<String, String> kafkaT;
    private static final WebClient webClient = WebClient.create("https://api.covid19api.com/");

    public void sendMessage() {
        String bootstrapServers = "127.0.0.1:9092";

        //create Producer properties
        Map<String, Object> properties = new HashMap<String, Object>();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,bootstrapServers);
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StringSerializer.class.getName());

        this.kafkaT = new KafkaTemplate<String, String>(new DefaultKafkaProducerFactory<String, String>(properties));


        webClient.get()
                .uri("summary")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(String.class)
                .subscribe(summary -> this.kafkaT.send(TOPIC, summary));

    }
}