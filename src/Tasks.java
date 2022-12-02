import java.time.LocalDateTime;
import java.util.Objects;

public class Tasks {
    private String heading;
    private String description;
    private final int id;
    private static int count = 0;
    private LocalDateTime dateOfCreation;
    private boolean typeTask ;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tasks tasks = (Tasks) o;
        return id == tasks.id && Objects.equals(heading, tasks.heading);
    }

    @Override
    public int hashCode() {
        return Objects.hash(heading, id);
    }

    public Tasks(String heading, String description, LocalDateTime dateOfCreation, boolean typeTask) {
        this.heading = heading;
        this.description = description;
        this.dateOfCreation = dateOfCreation;
        this.typeTask = typeTask;
        id = count++;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public static int getCount() {
        return count;
    }

    public LocalDateTime getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(LocalDateTime dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public boolean isTypeTask() {
        return typeTask;
    }

    public void setTypeTask(boolean typeTask) {
        this.typeTask = typeTask;
    }
}
