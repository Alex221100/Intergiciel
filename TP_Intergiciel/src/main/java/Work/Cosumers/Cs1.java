package Work.Cosumers;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class Cs1 {

    @KafkaListener(topics = "Topic1", groupId = "group_id")
    public void consume(String message) throws IOException {
        System.out.println("J'ai reçu : " + message);
    }
}
