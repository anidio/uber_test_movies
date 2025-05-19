package springboot.desafio.uber.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springboot.desafio.uber.model.MovieLocation;
import springboot.desafio.uber.service.MovieLocationService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movies")
public class MovieLocationController {

    private final MovieLocationService service;

    public MovieLocationController(MovieLocationService service){
        this.service = service;
    }

    @GetMapping
    public List<MovieLocation> getAll(@RequestParam Optional<String> title){
        return title.map(service::filterByTitle)
                .orElseGet(service::getAllmovies);
    }

    @GetMapping("/autocomplete")
    public List<String> autocomplete(@RequestParam("q") String prefix){
        return service.autocomplete(prefix);
    }
}
