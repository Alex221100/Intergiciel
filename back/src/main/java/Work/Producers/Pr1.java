package Work.Producers;

import Work.APIController;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.LongSerializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.concurrent.ExecutionException;


@Service
public class Pr1 {

    private static Pr1 instance = null;
    private static final KafkaProducer<Long, String> producer = new KafkaProducer<>(new HashMap<>() {{
        put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        put(ProducerConfig.CLIENT_ID_CONFIG, "cs1");
        put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, LongSerializer.class.getName());
        put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
    }});

    private Pr1() {

    }

    public static Pr1 getInstance() {
        if (instance == null) {
            instance = new Pr1();
        }

        return instance;
    }

    public void sendCovidSummary() {
        APIController.getSummaryToJson().subscribe(summary -> {
                    final ProducerRecord<Long, String> record = new ProducerRecord<Long, String>("Topic1", summary);
                    try {
                        producer.send(record).get();
                    }
                    catch (ExecutionException | InterruptedException e) {
                        System.out.println("Erreur dans l'envoi de l'enregistrement");
                        System.out.println(e);
                    }
                });
    }
}