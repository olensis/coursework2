import java.time.LocalDateTime;
import java.time.LocalTime;
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
        if (getDateOfCreation().isAfter(LocalDateTime.now()))
            return getDateOfCreation()
                    ;
    }


}



