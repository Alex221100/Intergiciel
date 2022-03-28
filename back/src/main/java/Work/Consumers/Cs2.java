package Work.Consumers;

import Data.Requests.PostegreSQLRepository;
import Data.Model.CountryDAO;
import Work.Model.Country;
import Work.Model.Global;
import Work.Producers.Pr3;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@Service
public class Cs2 {

    @KafkaListener(topics = "Topic2", groupId = "group2")
    public void consume(String args) {

        String command = args.split(",")[0].trim().toUpperCase(Locale.ROOT);
        String parameters = args.split(",")[1].trim().replace(" ", "").toUpperCase(Locale.ROOT);

        System.out.println("J'ai reçu : " + command);

        Object result = null;
        switch (command) {
            case "GLOBAL" -> result = getGlobal();
            case "COUNTRY" -> result = getCountry(parameters.split(",", 30)[0]);
            case "CONFIRMEDAVG" -> result = getConfirmedAvg();
            case "DEATHSAVG" -> result = getDeathsAvg();
            case "COUNTRIESDEATHSPERCENT" -> result = getCountriesDeathsPercent();
            case "EXPORT" -> result = getExport();
            default -> System.err.println("Commande inconnue : " + command);
        }

        if (result != null) {
            Pr3.getInstance().displayResult(result);
        }
    }

    private static Global getGlobal() {
        return new Global(PostegreSQLRepository.getGlobal());
    }

    private static Country getCountry(String v_pays) {
        return new Country(PostegreSQLRepository.getCountry(v_pays));
    }

    private static int getConfirmedAvg() {
        int result = 0;
        List<CountryDAO> countries = PostegreSQLRepository.getCountries();
        for(CountryDAO country : countries) {
            result += country.getNewConfirmed();
        }

        return result / countries.size();
    }

    private static int getDeathsAvg() {
        int result = 0;
        List<CountryDAO> countries = PostegreSQLRepository.getCountries();
        for(CountryDAO country : countries) {
            result += country.getNewDeaths();
        }

        return result / countries.size();
    }

    private static Map<String, Integer> getCountriesDeathsPercent() {
        HashMap<String, Integer> result = new HashMap<>();
        List<CountryDAO> countries = PostegreSQLRepository.getCountries();
        for(CountryDAO country : countries) {
            result.put(country.getCountry(), country.getTotalDeaths() / country.getTotalConfirmed());
        }

        return result;
    }

    private static Object getExport() {
        return null;
    }

}
