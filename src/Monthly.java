import java.time.LocalDateTime;
import java.time.LocalTime;

public class Monthly extends Tasks implements Repeatability{
    int repeatDayOfMonth = getDateOfCreation().getDayOfMonth();
    LocalTime timeOfRepeat = LocalTime.of(getDateOfCreation().getHour(), getDateOfCreation().getMinute());

    public Monthly(String heading, String description, LocalDateTime dateOfCreation, boolean typeTask) {
        super(heading, description, dateOfCreation, typeTask);
    }

    @Override
    public LocalDateTime getTime() {
        if ()
        return null;
    }
}
