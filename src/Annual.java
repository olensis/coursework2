import java.time.LocalDateTime;

public class Annual extends  Tasks implements Repeatability{

    public Annual(String heading, String description, LocalDateTime dateOfCreation, boolean typeTask) {
        super(heading, description, dateOfCreation, typeTask);
    }

    @Override
    public LocalDateTime getTime() {
        return null;
    }
}
