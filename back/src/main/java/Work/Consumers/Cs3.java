package Work.Consumers;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class Cs3 {
    @KafkaListener(topics = "Topic3", groupId = "group3")
    public void consume(String message) throws IOException {
        System.out.println("Message final : " + message);
    }
}
