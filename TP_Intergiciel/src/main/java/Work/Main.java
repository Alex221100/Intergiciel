package Work;

import Work.Producers.Pr1;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
        Pr1 pr1 = new Pr1();
        /*APIController.getCountries().subscribe(country -> {
                        if (country.getClass() == Country.class) {
                            producer.sendMessage(country);
                        }
                    });*/
        /*APIController.getGlobal().subscribe(global -> {
            if (global.getClass() == Global.class) {
                producer.sendMessage(global);
            }
        });*/
        pr1.sendMessage();

    }
}