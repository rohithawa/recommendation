package au.com.recommendation;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Created by Rohitha Wanni Achchige on 28/2/17.
 * In flight movie recommendation tester
 */
@RunWith(Parameterized.class)
public class InFlightMovieTest {
    @Parameterized.Parameter
    public int duration;
    @Parameterized.Parameter(1)
    public String expectedResult;
    @Parameterized.Parameter(2)
    public Class<? extends Exception> expectedException;
    @Parameterized.Parameter(3)
    public String movieResourceLocation;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Parameterized.Parameters
    public static Collection durationCollection() {
        return Arrays.asList(new Object[][]{
                {92, "The Secret Life of Pets (91 min)", null, "src/main/resources/movies.json"},
                {325, "Suicide Squad (130 min) Jason Bourne (123 min) Batman: The Killing Joke (72 min)",
                        null, "src/main/resources/movies.json"},
                {45, "", null, "src/main/resources/movies.json"},
                {45, "", RecommendationException.class, "src/main/resource/movies.json"}
        });
    }

    @Test
    public void testGetRecommendationByDuration() throws RecommendationException {
        InFlightMovie inFlightMovie = new InFlightMovie(movieResourceLocation);
        if (expectedException != null) {
            thrown.expect(expectedException);
        }
        List<Movie> movies = inFlightMovie.getRecommendationByDuration(duration);
        StringBuilder result = new StringBuilder();
        for (Movie movie : movies) {
            if (!result.toString().isEmpty()) result.append(" ");
            result.append(movie.toString());
        }
        Assert.assertEquals(expectedResult, result.toString());
    }
}
