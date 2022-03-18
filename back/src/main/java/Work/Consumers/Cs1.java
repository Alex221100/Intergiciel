package Work.Consumers;

import Work.Model.Summary;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

@Service
public class Cs1 {

    @KafkaListener(topics = "Topic1", groupId = "group1")
    public void consume(String message) throws IOException {
        /*ObjectMapper objectMapper = new ObjectMapper();
        Reader reader = new StringReader(message);
        Summary summary = objectMapper.readValue(reader, Summary.class);
        System.out.println(summary);*/
    }
}
