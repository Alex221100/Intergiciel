package Work.Controller;

import Work.Config.EnumCommand;
import Work.Consumers.Cs3;
import Work.Producers.Pr2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@RestController
@RequestMapping
public class CovidController {

    @GetMapping(value="/global")
    public ResponseEntity<String> getGlobalValues() throws ExecutionException, InterruptedException {
        System.out.println("je suis dans CovidController");
        Pr2.getInstance().sendCommand(EnumCommand.GLOBAL);
        return ResponseEntity.ok(Cs3.getResult());
    }

    @GetMapping(value="/country")
    public ResponseEntity<String> getCountryValues(@RequestParam String countryName) throws ExecutionException, InterruptedException {
        Pr2.getInstance().sendCommandWithParameters(EnumCommand.COUNTRY, new ArrayList<>() {{
            add(countryName);
        }});
        return ResponseEntity.ok(Cs3.getResult());
    }

    @GetMapping(value="/confirmedAvg")
    public ResponseEntity<String> getConfirmedAvg() throws ExecutionException, InterruptedException {
        Pr2.getInstance().sendCommand(EnumCommand.CONFIRMEDAVG);
        return ResponseEntity.ok(Cs3.getResult());
    }

    @GetMapping(value="/deathsAvg")
    public ResponseEntity<String> getDeathsAvg() throws ExecutionException, InterruptedException {
        Pr2.getInstance().sendCommand(EnumCommand.DEATHSAVG);
        return ResponseEntity.ok(Cs3.getResult());
    }

    @GetMapping(value="/countriesDeathsPercent")
    public ResponseEntity<String> getCountriesDeathsPercent() throws ExecutionException, InterruptedException {
        Pr2.getInstance().sendCommand(EnumCommand.COUNTRIESDEATHSPERCENT);
        return ResponseEntity.ok(Cs3.getResult());
    }

    @GetMapping(value="/export")
    public ResponseEntity<String> getExport() {
        Pr2.getInstance().sendCommand(EnumCommand.EXPORT);
        return ResponseEntity.ok("it works");
    }
}

