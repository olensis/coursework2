import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Main {
    static TaskWork taskManager = new TaskWork();
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            label:
            while (true) {
                printMenu();
                System.out.print("Выберите пункт меню: ");
                if (scanner.hasNextInt()) {
                    int menu = scanner.nextInt();
                    switch (menu) {
                        case 1:
                            inputTask(scanner);
                            break;
                        case 2:
                            inputDeleteTask ( scanner);
                            break;
                        case 3:
                            inputDay (scanner);
                            break;
                        case 0:
                            break label;
                    }
                } else {
                    scanner.next();
                    System.out.println("Выберите пункт меню из списка!");
                }
            }
        }
    }


    private static void inputTask(Scanner scanner) {
        scanner.nextLine();
        System.out.print("Введите заголовок задачи: ");
        String taskName = scanner.nextLine();
        System.out.print("Введите описание: ");
        String description = scanner.nextLine();
        System.out.println("Введите тип задачи:\n" +
                "Если задача личная, то введите: 0 \t" +
                "Если задача рабочая, то введите: 1");
        System.out.print("Вы ввели: ");
        boolean isWork = taskManager.createIsWork(scanner.nextInt());
        System.out.println("Введите число от 0 до 4 для выбора повторяемости:\n" +
                "0. Однократня \t 1. Ежедневная \t 2. Еженедельная \t 3. Ежемесячная \t 4. Ежегодная");
        System.out.print("Вы ввели: ");
        int repeatable = scanner.nextInt();
        System.out.println("Введите дату начала задачи в формате дд.мм.гггг : ");
        String date = scanner.next();
        System.out.println("Введите время начала задачи в формате чч:мм : ");
        String time = scanner.next();
        LocalDateTime localDateTime = taskManager.createDateAndTime(date, time);
        Tasks task = taskManager.createTask( description,taskName, localDateTime, isWork, repeatable);
        taskManager.addTask(task);
        System.out.println("Созданная задача:");
        System.out.println(task.toString());
        System.out.print("Для выхода в меню нажмите Enter");
        scanner.nextLine();
        scanner.nextLine();
    }

    public static void inputDeleteTask(Scanner scanner) {
        System.out.println("На данный момент доступны следующие задачи: ");
        taskManager.printTasks();
        if (taskManager.getTasks().isEmpty()) {
            return;
        }
        System.out.print(" Введите id доступных для удаления задач: ");
        int taskId = scanner.nextInt();
        taskManager.removalTask(taskId);
        System.out.println("Задача успешно удалена");
        System.out.println("Для выхода в меню нажмите Enter");
        scanner.nextLine();
        scanner.nextLine();
    }

    public static void inputDay(Scanner scanner) {
        if (taskManager.getTasks().isEmpty()) {
            System.out.println("Ни одна задача еще не добавлена в ежедневник!");
            return;
        }
        System.out.print("Введите день в формате дд.мм.гггг: ");
        String date = scanner.next();
        LocalDateTime dateAndTime = taskManager.createDateAndTime(date, "23:59");
        System.out.println("Задачи на :" + dateAndTime.toLocalDate() + ", " + dateAndTime.toLocalDate().getDayOfWeek());
        taskManager.printTasksOf(dateAndTime);
        System.out.println("Для выхода в меню нажмите Enter");
        scanner.nextLine();
        scanner.nextLine();
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



