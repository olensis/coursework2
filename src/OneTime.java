import java.time.LocalDateTime;

public class OneTime extends Tasks implements Repeatability {

    public OneTime(String heading, String description, LocalDateTime dateOfCreation, boolean typeTask) {
        super(heading, description, dateOfCreation, typeTask);
    }

    @Override
    public LocalDateTime getTime() {
        return getDateOfCreation();
    }
    public boolean checkTask(LocalDateTime data) {
        return getDateOfCreation().isBefore(data);
    }
}
