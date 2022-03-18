package Work;


import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public class APIProvider {

    private static final WebClient webClient = WebClient.create("https://api.covid19api.com/");

    public static Mono<String> getSummaryToJson() {
        return webClient.get()
                .uri("summary")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(String.class);
    }

}
