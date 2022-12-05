import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.TemporalAdjusters;

public class Monthly extends Tasks implements Repeatability{
    int repeatDayOfMonth = getDateOfCreation().getDayOfMonth();
    LocalTime timeOfRepeat = LocalTime.of(getDateOfCreation().getHour(), getDateOfCreation().getMinute());

    public Monthly(String heading, String description, LocalDateTime dateOfCreation, boolean typeTask) {
        super(heading, description, dateOfCreation, typeTask);
    }

    @Override
    public LocalDateTime getTime() {
        if (getDateOfCreation().isAfter(LocalDateTime.now())){
            return getDateOfCreation();}
        if(repeatDayOfMonth==getDateOfCreation().getDayOfMonth()&&timeOfRepeat.isAfter(LocalTime.now())) {
            return LocalDateTime.of(LocalDate.now(),timeOfRepeat);
        }
        if(repeatDayOfMonth>LocalDate.now().getDayOfMonth()){
            return LocalDateTime.of(LocalDate.now().plusDays(repeatDayOfMonth-LocalDate.now().getDayOfMonth()),timeOfRepeat);
        }
        if(repeatDayOfMonth<LocalDate.now().getDayOfMonth()){
            return LocalDateTime.of(LocalDate.now().with(TemporalAdjusters.firstDayOfNextMonth()).plusDays(repeatDayOfMonth-1),timeOfRepeat);
        }
        return null;
    }
    public boolean checkTask(LocalDateTime data) {
        if (getDateOfCreation().isAfter(data)) {
            return false;
        }
        return data.getDayOfMonth()==(repeatDayOfMonth);
    }

    }

