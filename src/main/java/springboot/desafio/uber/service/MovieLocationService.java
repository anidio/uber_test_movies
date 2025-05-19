package springboot.desafio.uber.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.reactive.function.client.WebClient;
import springboot.desafio.uber.model.MovieLocation;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class MovieLocationService {

    private final WebClient webClient;

    public MovieLocationService(WebClient.Builder builder){
        this.webClient = builder
                .baseUrl("https://data.sfgov.org/resource/yitu-d5am.json")
                .build();
    }

    public List<MovieLocation> getAllmovies(){
        return webClient.get()
                .retrieve()
                .bodyToFlux(MovieLocation.class)
                .collectList()
                .block();
    }

    public List<MovieLocation> filterByTitle(String query){
        return getAllmovies().stream()
                .filter(m -> m.getTitle() != null && m.getTitle().toLowerCase().contains(query.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<String> autocomplete(String prefix){
        return getAllmovies().stream()
                .map(MovieLocation::getTitle)
                .filter(Objects::nonNull)
                .filter(t -> t.toLowerCase().startsWith(prefix.toLowerCase()))
                .sorted().limit(10)
                .collect(Collectors.toList());
    }
}
