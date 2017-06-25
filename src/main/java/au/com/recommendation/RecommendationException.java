package au.com.recommendation;

/**
 * Created by Rohitha Wanni Achchige on 1/3/17.
 * Exception handling
 */
public class RecommendationException extends Exception {
    private final String errorMessage;

    /**
     * RecommendationException constructor.
     *
     * @param errorMessage errorMessage
     */
    public RecommendationException(final String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
