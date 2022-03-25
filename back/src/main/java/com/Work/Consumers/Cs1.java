package com.Work.Consumers;

import com.Data.Entity.CountryDAO;
import com.Data.Entity.GlobalDAO;
import com.Data.Repository.IPostgreRepository;
import com.Work.Model.Country;
import com.Work.Model.Summary;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.sql.SQLException;

@Service
public class Cs1 {
    @Autowired
    private IPostgreRepository postgreRepository;

    @KafkaListener(topics = "Topic1", groupId = "group1")
    @Transactional
    public void consume(String message) throws IOException, SQLException {
        ObjectMapper objectMapper = new ObjectMapper();
        Reader reader = new StringReader(message);
        Summary summary = objectMapper.readValue(reader, Summary.class);
        System.out.println(summary);

        for (Country country : summary.getCountries()){
            CountryDAO countryDAO = new CountryDAO(country.getId(), country.getCountry(), country.getCountryCode(), country.getSlug(),
                    country.getNewConfirmed(), country.getTotalConfirmed(), country.getNewDeaths(), country.getTotalDeaths(),
                    country.getNewRecovered(), country.getTotalRecovered(), country.getDate());
            //TODO : gérer exception
            //ostgreRepository.save(countryDAO);
        }


        GlobalDAO globalDAO = new GlobalDAO(summary.getGlobal().getNewConfirmed(), summary.getGlobal().getTotalConfirmed(),
                summary.getGlobal().getNewDeaths(), summary.getGlobal().getTotalDeaths(), summary.getGlobal().getNewRecovered(),
                summary.getGlobal().getTotalRecovered(), summary.getGlobal().getDate());

        //TODO : gérer exception
        postgreRepository.save(globalDAO);
        }



    }

