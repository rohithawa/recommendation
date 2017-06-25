package au.com.recommendation;

import java.util.List;

/**
 * Created by Rohitha Wanni Achchige on 28/2/17.
 *
 */
public class MainApp {
    public static void main(String[] args) {
        // In flight movie recommendation
        System.out.println("In flight movie recommendation------------------");
        try {
            InFlightMovie inFlightMovie = new InFlightMovie("src/main/resources/movies.json");
            List<Movie> movies = inFlightMovie.getRecommendationByDuration(92);
            System.out.print("Flight duration " + 92 + " min: ");
            for (Movie movie : movies) {
                System.out.print(movie.toString());
            }
            System.out.println();
            movies = inFlightMovie.getRecommendationByDuration(325);
            System.out.print("Flight duration " + 325 + " min: ");
            for (Movie movie : movies) {
                System.out.print(movie.toString());
            }
            System.out.println();
            movies = inFlightMovie.getRecommendationByDuration(45);
            System.out.print("Flight duration " + 45 + " min: ");
            for (Movie movie : movies) {
                System.out.print(movie.toString());
            }
        } catch (RecommendationException e) {
            System.out.println(e.getErrorMessage());
        }
    }
}
