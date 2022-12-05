import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;
import java.util.Timer;

public class Annual extends  Tasks implements Repeatability {
    int repeatDayOfYear = getDateOfCreation().getDayOfYear();
    LocalTime timeOfRepeat = LocalTime.of(getDateOfCreation().getHour(), getDateOfCreation().getMinute());


    public Annual(String heading, String description, LocalDateTime dateOfCreation, boolean typeTask) {
        super(heading, description, dateOfCreation, typeTask);
    }


    @Override
    public LocalDateTime getTime() {
        if (getDateOfCreation().isAfter(LocalDateTime.now())){
            return getDateOfCreation();}
        if(repeatDayOfYear==getDateOfCreation().getDayOfYear()&&timeOfRepeat.isAfter(LocalTime.now())) {
            return LocalDateTime.of(LocalDate.now(),timeOfRepeat);
        }
        if(repeatDayOfYear>LocalDate.now().getDayOfYear()){
            return LocalDateTime.of(LocalDate.now().plusDays(repeatDayOfYear-LocalDate.now().getDayOfYear()),timeOfRepeat);
        }
        if(repeatDayOfYear<LocalDate.now().getDayOfYear()){
            return LocalDateTime.of(LocalDate.now().with(TemporalAdjusters.firstDayOfNextYear()).plusDays(repeatDayOfYear-1),timeOfRepeat);
        }
        return null;
    }
    public boolean checkTask(LocalDateTime data) {
        if (getDateOfCreation().isAfter(data)) {
            return false;
        }
        return data.getDayOfYear()==(repeatDayOfYear);
    }
    }





