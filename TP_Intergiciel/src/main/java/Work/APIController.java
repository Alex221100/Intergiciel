package Work;

import Data.Country;
import Data.Global;
import Data.Summary;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class APIController {

    private static final WebClient webClient = WebClient.create("https://api.covid19api.com/");

    public static Mono<Global> getGlobal() {
        return webClient.get()
                .uri("summary")
                .retrieve()
                .bodyToMono(Global.class);
    }

    public static Flux<Country> getCountries() {
        return webClient.get()
                .uri("countries")
                .retrieve()
                .bodyToFlux(Country.class);
    }

    public static Mono<String> getSummaryToJson() {
        return webClient.get()
                .uri("summary")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(String.class);
    }

}
