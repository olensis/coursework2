import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Daily extends Tasks implements Repeatability {

    public Daily(String heading, String description, LocalDateTime dateOfCreation, boolean typeTask) {
        super(heading, description, dateOfCreation, typeTask);
    }
    LocalTime timeOfRepeat = LocalTime.of(getDateOfCreation().getHour(), getDateOfCreation().getMinute());

    @Override
    public LocalDateTime getTime() {
        if (getDateOfCreation().isAfter(LocalDateTime.now())){
            return getDateOfCreation();}
        if (timeOfRepeat.isAfter(LocalTime.now())){
            return LocalDateTime.of(LocalDate.now(),timeOfRepeat);}
        return LocalDateTime.of(LocalDate.now().plusDays(1),timeOfRepeat);
    }
    public boolean checkTask(LocalDateTime data) {
        return getDateOfCreation().isBefore(data);
    }
    }

