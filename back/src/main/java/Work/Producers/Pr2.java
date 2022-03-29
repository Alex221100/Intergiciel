package Work.Producers;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.LongSerializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.concurrent.ExecutionException;


@Service
public class Pr2 {

    private static Pr2 instance = null;
    private static KafkaProducer<Long, String> producer = null;

    private Pr2() {
        producer = new KafkaProducer<>(new HashMap<>() {{
            put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
            put(ProducerConfig.CLIENT_ID_CONFIG, "cs2");
            put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, LongSerializer.class.getName());
            put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        }});
    }

    public static Pr2 getInstance() {
        if (instance == null) {
            instance = new Pr2();
        }

        return instance;
    }

    public void sendCommand(String args) {
        System.out.println("je suis dans la Pr2");
        final ProducerRecord<Long, String> record = new ProducerRecord<>("Topic2", args);
        try {
            producer.send(record).get();
        } catch (ExecutionException | InterruptedException e) {
            System.err.println("Erreur dans l'envoi de l'enregistrement : " + e.getMessage());
        }
    }
}