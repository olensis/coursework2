import java.time.LocalDateTime;

public class OneTime extends Tasks implements Repeatability {

    public OneTime(String heading, String description, LocalDateTime dateOfCreation, boolean typeTask) {
        super(heading, description, dateOfCreation, typeTask);
    }

    @Override
    public LocalDateTime getTime() {
        return null;
    }
}
