package springboot.desafio.uber.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class MovieLocation {

    @JsonProperty("title")
    private String title;

    @JsonProperty("release_year")
    private String release_year;

    @JsonProperty("locations")
    private String locations;

    @JsonProperty("actor_1")
    private String actor_1;

    @JsonProperty("actor_2")
    private String actor_2;

    @JsonProperty("actor_3")
    private String actor_3;
}