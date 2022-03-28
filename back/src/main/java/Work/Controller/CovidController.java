package Work.Controller;

import Work.Producers.Pr2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class CovidController {
    @GetMapping(value="/global")
    public ResponseEntity<String> getGlobalValues() {
        Pr2.getInstance().sendCommand("GLOBAL");
        return ResponseEntity.ok("it works");
    }

    @GetMapping(value="/country")
    public ResponseEntity<String> getCountryValues(String countryName) {
        Pr2.getInstance().sendCommand("COUNTRY," + countryName);
        return ResponseEntity.ok("it works");
    }

    @GetMapping(value="/confirmedAvg")
    public ResponseEntity<String> getConfirmedAvg() {
        Pr2.getInstance().sendCommand("CONFIRMEDAVG");
        return ResponseEntity.ok("it works");
    }

    @GetMapping(value="/deathsAvg")
    public ResponseEntity<String> getDeathsAvg() {
        Pr2.getInstance().sendCommand("DEATHSAVG");
        return ResponseEntity.ok("it works");
    }

    @GetMapping(value="/countriesDeathsPercent")
    public ResponseEntity<String> getCountriesDeathsPercent() {
        Pr2.getInstance().sendCommand("COUNTRIESDEATHSPERCENT");
        return ResponseEntity.ok("it works");
    }

    @GetMapping(value="/export")
    public ResponseEntity<String> getExport() {
        Pr2.getInstance().sendCommand("EXPORT");
        return ResponseEntity.ok("it works");
    }
}

