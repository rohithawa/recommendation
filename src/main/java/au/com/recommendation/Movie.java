package au.com.recommendation;

/**
 * Created by Rohitha Wanni Achchige on 28/2/17.
 * Movie object
 */
public class Movie {
    private String title;
    private int runtime;

    public String getTitle() {
        return title;
    }

    public int getRuntime() {
        return runtime;
    }

    public String toString() {
        return title + " (" + runtime + " min)";
    }
}
