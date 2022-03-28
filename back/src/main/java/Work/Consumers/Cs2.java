package Work.Consumers;

import Data.Requests.PostegreSQLRepository;
import Data.Model.CountryDAO;
import Work.Model.Country;
import Work.Model.Global;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class Cs2 {

    @KafkaListener(topics = "Topic2", groupId = "group2")
    public void consume(String message) throws IOException {

        System.out.println("J'ai reçu : " + message);
    }

    private static Global getGlobal() {
        PostegreSQLRepository.getGlobal();
        return null;
    }

    private static Country getCountry(String v_pays) {
        PostegreSQLRepository.getCountry(v_pays);
        return null;
    }

    private static int getConfirmedAvg() {
        return 0;
    }

    private static int getDeathsAvg() {
        return 0;
    }

    private static int getCountriesDeathsPercent() {
        return 0;
    }

    private static void getExport() {

    }

}
