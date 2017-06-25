package au.com.recommendation;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Rohitha Wanni Achchige on 28/2/17.
 * In flight movie recommendation
 */
public class InFlightMovie {
    private final String movieResourceLocation;

    public InFlightMovie(String movieResourceLocation) {
        this.movieResourceLocation = movieResourceLocation;
    }

    /**
     * Return recommended movies for given flight duration
     *
     * @param flightDuration flight duration
     * @return List<Movie>
     */
    public List<Movie> getRecommendationByDuration(int flightDuration) throws RecommendationException {
        List<Movie> movies = new ArrayList<>();
        try {
            ObjectMapper mapper = new ObjectMapper();
            List<Movie> movieList = mapper.readValue(new File(movieResourceLocation),
                    new TypeReference<List<Movie>>() {
                    });

            while (!movieList.isEmpty()) {
                int totalDuration = movies.stream().collect(Collectors.summingInt(Movie::getRuntime));
                movieList = movieList.stream().filter(movie -> movie.getRuntime() <= (flightDuration - totalDuration))
                        .sorted((Movie o1, Movie o2) -> o2.getRuntime() - o1.getRuntime()).collect(Collectors.toList());
                if (!movieList.isEmpty()) {
                    movies.add(movieList.get(0));
                    movieList.remove(0);
                }
            }
        } catch (IOException e) {
            throw new RecommendationException(e.getMessage());
        }
        return movies;
    }
}
