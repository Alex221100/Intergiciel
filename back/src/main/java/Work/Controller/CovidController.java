package Work.Controller;

import Work.Config.EnumCommand;
import Work.Consumers.Cs3;
import Work.Producers.Pr2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping
public class CovidController {

    @Autowired
    private Pr2 pr2;

    @Autowired
    private Cs3 cs3;

    @GetMapping(value="/global")
    public ResponseEntity<String> getGlobalValues() throws ExecutionException, InterruptedException {
        System.out.println("je suis dans CovidController");
        pr2.sendCommand(EnumCommand.GLOBAL);
        return ResponseEntity.ok(cs3.getResult().get());
    }

    @GetMapping(value="/country")
    public ResponseEntity<String> getCountryValues(String countryName) throws ExecutionException, InterruptedException {
        pr2.sendCommandWithParameters(EnumCommand.COUNTRY, new ArrayList<>() {{
            add(countryName);
        }});
        return ResponseEntity.ok(cs3.getResult().get());
    }

    @GetMapping(value="/confirmedAvg")
    public ResponseEntity<String> getConfirmedAvg() throws ExecutionException, InterruptedException {
        pr2.sendCommand(EnumCommand.CONFIRMEDAVG);
        return ResponseEntity.ok(cs3.getResult().get());
    }

    @GetMapping(value="/deathsAvg")
    public ResponseEntity<String> getDeathsAvg() throws ExecutionException, InterruptedException {
        pr2.sendCommand(EnumCommand.DEATHSAVG);
        return ResponseEntity.ok(cs3.getResult().get());
    }

    @GetMapping(value="/countriesDeathsPercent")
    public ResponseEntity<String> getCountriesDeathsPercent() throws ExecutionException, InterruptedException {
        pr2.sendCommand(EnumCommand.COUNTRIESDEATHSPERCENT);
        return ResponseEntity.ok(cs3.getResult().get());
    }

    @GetMapping(value="/export")
    public ResponseEntity<String> getExport() {
        pr2.sendCommand(EnumCommand.EXPORT);
        return ResponseEntity.ok("it works");
    }
}

