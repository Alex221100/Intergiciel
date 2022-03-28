package Work.Consumers;

import Data.Model.CountryDAO;
import Data.Model.GlobalDAO;
import Data.Requests.PostegreSQLRepository;
import Work.Model.Country;
import Work.Model.Summary;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class Cs1 {

    @KafkaListener(topics = "Topic1", groupId = "group1")
    public void consume(String message) throws IOException, SQLException {
        System.out.println("je suis dans Cs1");
        ObjectMapper objectMapper = new ObjectMapper();
        Reader reader = new StringReader(message);
        Summary summary = objectMapper.readValue(reader, Summary.class);
        List<CountryDAO> countriesDAO = new ArrayList<>();

        for (Country country : summary.getCountries()){
            CountryDAO countryDAO = new CountryDAO(country.getCountry(), country.getCountryCode(), country.getSlug(),
                    country.getNewConfirmed(), country.getTotalConfirmed(), country.getNewDeaths(), country.getTotalDeaths(),
                    country.getNewRecovered(), country.getTotalRecovered(), country.getDate());

            countriesDAO.add(countryDAO);
        }

        PostegreSQLRepository.insertCountries(countriesDAO);


        GlobalDAO globalDAO = new GlobalDAO(summary.getGlobal().getNewConfirmed(), summary.getGlobal().getTotalConfirmed(),
                summary.getGlobal().getNewDeaths(), summary.getGlobal().getTotalDeaths(), summary.getGlobal().getNewRecovered(),
                summary.getGlobal().getTotalRecovered(), summary.getGlobal().getDate());

        PostegreSQLRepository.insertGlobal(globalDAO);
    }
}
