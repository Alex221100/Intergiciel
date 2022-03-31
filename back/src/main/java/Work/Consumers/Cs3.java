package Work.Consumers;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Service
public class Cs3 {

    private static final ExecutorService executor = Executors.newSingleThreadExecutor();
    private static String pendingMessage;

    @KafkaListener(topics = "Topic3", groupId = "group3")
    public void consume(String message) {
        System.out.println("Message final : " + message);
        pendingMessage = message;
    }


    /*public static Future<String> getResult() {
        return executor.submit(() -> {
            if (pendingMessage != null) {
                String message = pendingMessage;
                pendingMessage = null;
                return message;
            }
            else {
                return getResult().get();
            }
        });*/

    public static String getResult() throws ExecutionException, InterruptedException {
        Future<String> futureTask = executor.submit(() -> test());

        while (!futureTask.isDone()) {
            System.out.println("FutureTask is not finished yet...");
        }
        pendingMessage = null;
        return futureTask.get();
    }

    public static String test() {
        while(pendingMessage == null){
            System.out.println("Message is in progress");
        }
        return pendingMessage;
    }
}
