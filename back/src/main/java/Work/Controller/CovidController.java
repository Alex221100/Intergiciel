package Work.Controller;

import Model.Global;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping
public class CovidController {
    @GetMapping(value="/global")
    public ResponseEntity<String> getGlobalValues() {
        return ResponseEntity.ok("it works");
    }

    @GetMapping(value="/country")
    public ResponseEntity<String> getCountryValues() {
        return ResponseEntity.ok("it works");
    }

    @GetMapping(value="/country")
    public ResponseEntity<String> getConfirmedAvg() {
        return ResponseEntity.ok("it works");
    }

    @GetMapping(value="/death")
    public ResponseEntity<String> getDeathsAvg() {
        return ResponseEntity.ok("it works");
    }

    @GetMapping(value="/countryDeathsPercent")
    public ResponseEntity<String> getCountryDeathsPercent() {
        return ResponseEntity.ok("it works");
    }
}

