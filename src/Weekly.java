import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.TemporalAdjusters;

public class Weekly extends Tasks implements Repeatability {

    LocalTime timeOfRepeat = LocalTime.of(getDateOfCreation().getHour(), getDateOfCreation().getMinute());
    DayOfWeek repeatDayOfWeekly = getDateOfCreation().getDayOfWeek();

    public Weekly(String heading, String description, LocalDateTime dateOfCreation, boolean typeTask) {
        super(heading, description, dateOfCreation, typeTask);
    }

    @Override
    public LocalDateTime getTime() {
        if (getDateOfCreation().isAfter(LocalDateTime.now())){
            return getDateOfCreation();}
        if (repeatDayOfWeekly.equals(LocalDate.now().getDayOfWeek())&&timeOfRepeat.isAfter(LocalTime.now())){
            return LocalDateTime.of(LocalDate.now(),timeOfRepeat);
        }
        return LocalDateTime.of(LocalDate.now().with(TemporalAdjusters.next(repeatDayOfWeekly)), timeOfRepeat);
    }
    public boolean checkTask(LocalDateTime data) {
        if (getDateOfCreation().isAfter(data)) {
            return false;
        }
        return data.getDayOfWeek().equals(repeatDayOfWeekly);
    }

}
