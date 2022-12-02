import java.time.LocalDateTime;

public class Weekly extends Tasks implements Repeatability {

    public Weekly(String heading, String description, LocalDateTime dateOfCreation, boolean typeTask) {
        super(heading, description, dateOfCreation, typeTask);
    }

    @Override
    public LocalDateTime getTime() {
        return null;
    }
}
