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
public class Pr3 {
    private static Pr3 instance = null;
    private static KafkaProducer<Long, String> producer = null;

    private Pr3() {
        producer = new KafkaProducer<>(new HashMap<>() {{
            put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
            put(ProducerConfig.CLIENT_ID_CONFIG, "cs3");
            put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, LongSerializer.class.getName());
            put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        }});
    }

    public static Pr3 getInstance() {
        if (instance == null) {
            instance = new Pr3();
        }

        return instance;
    }

    public void displayResult(Object resultObject) {
        final ProducerRecord<Long, String> record = new ProducerRecord<Long, String>("Topic3", resultObject.toString());
        try {
            producer.send(record).get();
        } catch (ExecutionException | InterruptedException e) {
            System.err.println("Erreur dans l'envoi de l'enregistrement : " + e.getMessage());
        }
    }
}