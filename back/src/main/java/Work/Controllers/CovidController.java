package Work.Controllers;

import Work.Configurations.EnumCommand;
import Work.Consumers.Cs3;
import Work.Producers.Pr2;
import Work.Producers.Pr3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping
public class CovidController {

    @GetMapping(value="/global")
    public ResponseEntity<String> getGlobalValues() throws ExecutionException, InterruptedException {
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
    public ResponseEntity<String> getExport() throws FileNotFoundException, ExecutionException, InterruptedException {
        Pr2.getInstance().sendCommand(EnumCommand.EXPORT);
        return ResponseEntity.ok(Cs3.getResult());
    }

    @GetMapping(value="/help")
    public ResponseEntity<String> getHelp() {
        String help = "/global : Retourne les valeurs globales du Covid19.<br/>" +
                "/country : Retoune les valeurs du Covid19 pour un pays souhaité.<br/>" +
                "/confirmedAvg : Retourne une moyenne des cas confirmés du Covid19.<br/>" +
                "/deathsAvg : Retourne une moyenne des décès du Covid19.<br/>" +
                "/countriesDeathsPercent : Retourne le pourcentage de décès par rapport aux cas confirmés.<br/>" +
                "/export : Retourne un export des données de la base en XML.<br/>" +
                "/help : Affiche les commandes et leurs explications.";
        return ResponseEntity.ok(help);
    }
}

