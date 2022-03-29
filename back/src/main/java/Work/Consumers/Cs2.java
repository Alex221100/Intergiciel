package Work.Consumers;

import Data.Model.CountryDAO;
import Data.Requests.PostegreSQLRepository;
import Work.Model.Country;
import Work.Model.Global;
import Work.Producers.Pr3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

@Service
public class Cs2 {

    @Autowired
    private Pr3 pr3;

    @KafkaListener(topics = "Topic2", groupId = "group2")
    public void consume(String data) throws IOException {
        String command = data.contains(",") ? data.split(",")[0] : data;
        List<String> parameters = data.contains(",") ? Arrays.asList(data.split(",").clone()).subList(1, data.split(",").length) : new ArrayList<>();

        Object result = null;
        switch (command.toUpperCase(Locale.ROOT).trim()) {
            case "GLOBAL" -> result = getGlobal();
            case "COUNTRY" -> result = getCountry(parameters.get(0));
            case "CONFIRMEDAVG" -> result = getConfirmedAvg();
            case "DEATHSAVG" -> result = getDeathsAvg();
            case "COUNTRIESDEATHSPERCENT" -> result = getCountriesDeathsPercent();
            case "EXPORT" -> result = getExport();
            default -> System.err.println("Commande inconnue : " + command);
        }

        if (result != null) {
            pr3.displayResult(result);
        }
    }

    public static Global getGlobal() {
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
