package Work.Consumers;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Service
public class Cs3 {

    private final ExecutorService executor = Executors.newSingleThreadExecutor();
    private String pendingMessage;

    @KafkaListener(topics = "Topic3", groupId = "group3")
    public void consume(String message) {

        System.out.println("Message final : " + message);
        pendingMessage = message;
    }

    public Future<String> getResult() {
        return this.executor.submit(() -> {
            if (this.pendingMessage != null) {
                String message = this.pendingMessage;
                this.pendingMessage = null;
                return message;
            }
            else {
                return getResult().get();
            }
        });
    }


}
