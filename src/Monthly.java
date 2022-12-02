import java.time.LocalDateTime;

public class Monthly extends Tasks implements Repeatability{

    public Monthly(String heading, String description, LocalDateTime dateOfCreation, boolean typeTask) {
        super(heading, description, dateOfCreation, typeTask);
    }

    @Override
    public LocalDateTime getTime() {
        return null;
    }
}
