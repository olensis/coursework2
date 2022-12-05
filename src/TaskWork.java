import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

public class TaskWork {
    private HashMap<Integer, Tasks> tasks = new HashMap<>();

    public HashMap<Integer, Tasks> getTasks() {
        return tasks;
    }

    public void addTask(Tasks task) {
        tasks.put(task.getId(), task);
    }

    public void removalTask(int taskId) {
        tasks.remove(taskId);
    }

    public void printTasks() {
        if (tasks.isEmpty()) {
            System.out.println("Пока что ни одна задача не была создана");
            return;
        }
        for (Tasks task : tasks.values()) {
            System.out.println(task);
        }
    }

    public void printTasksOf(LocalDateTime date) {
        boolean haveDailyTask = false;
        for (Tasks task : tasks.values()) {
            if (task.isTypeTask()) {
                haveDailyTask = true;
                System.out.println(task);
            }
        }
        if (!haveDailyTask) {
            System.out.println("На данный день нет никаких запланированных задач");
        }

    }

    public boolean createIsWork(int isWork) {
        if (isWork == 1) {
            return true;
        }
        if (isWork == 0) {
            return false;
        }
        throw new IllegalArgumentException("Не правильно введен тип задачи!");
    }

    public Tasks createTask(String header, String description, LocalDateTime dateOfCreation, boolean typeTask, int repeatable) {
        return switch (repeatable) {
            case 0 -> new OneTime(header, description, dateOfCreation, typeTask);
            case 1 -> new Daily(header, description, dateOfCreation, typeTask);
            case 2 -> new Weekly(header, description, dateOfCreation, typeTask);
            case 3 -> new Monthly(header, description, dateOfCreation, typeTask);
            case 4 -> new Annual(header, description, dateOfCreation, typeTask);
            default -> throw new IllegalArgumentException("Неправильно был выбран тип повторяемости задача");
        };
    }

    public LocalDateTime createDateAndTime(String date, String time) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("d.MM.yyyy");
        LocalDate localDate = LocalDate.parse(date, dateFormatter);
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime localTime = LocalTime.parse(time, timeFormatter);
        return LocalDateTime.of(localDate, localTime);
    }

    private static void printMenu() {
        System.out.println("" +
                "1. Добавить задачу\n" +
                "2. Удалить задачу\n" +
                "3. Получить задачи на указанный день\n" +
                "4. Получить все удаленные задачи\n" +
                "5. Редактировать задачу\n" +
                "6. Вывод всех задач, сортированных по дате\n" +
                "0. Выход");


    }
}
