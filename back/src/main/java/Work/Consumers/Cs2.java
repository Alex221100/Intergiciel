package Work.Consumers;

import Data.Requests.PostegreSQLRepository;
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

        switch(message) {
            case "GLOBAL":
                getGlobal();
                break;

            default:
                System.err.println("Commande inconnue : " + message);
                break;
        }
    }

    private static void getGlobal() {
        Global result = new Global(PostegreSQLRepository.getGlobal());
    }

    private static void getCountry(String v_pays) {
        Country result = new Country(PostegreSQLRepository.getCountry(v_pays));
    }

    private static void getConfirmedAvg() {

    }

    private static void getDeathsAvg() {

    }

    private static void getCountriesDeathsPercent() {

    }

    private static void getExport() {

    }

}
