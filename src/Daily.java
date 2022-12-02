import java.time.LocalDateTime;

public class Daily extends Tasks implements Repeatability {

    public Daily(String heading, String description, LocalDateTime dateOfCreation, boolean typeTask) {
        super(heading, description, dateOfCreation, typeTask);
    }

    @Override
    public LocalDateTime getTime() {
        return null;
    }
}
