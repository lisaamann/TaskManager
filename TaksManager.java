package taskmanagement;

import java.util.List;
import java.util.Scanner;

public class TaksManager {
    private Scanner scanner;
    private TaskDAO taskDAO;

    public TaksManager() {
        this.scanner = new Scanner(System.in);
        this.taskDAO = new TaskDAO();
    }

    public void readInput() {
        System.out.println("Willkommen");
        printAllTasks();
        System.out.println("Befehle: a Hinzufügen, p Drucken, d Löschen, u Update, b Beenden");
        while (true) {
            System.out.println("Bitte gib den gewünschten Befehl ein!");
            String input = this.scanner.nextLine();

            if (input.equals("a")) {
                System.out.println("Bitte Task eingeben: ");
                addTask();

            }
            if (input.equals("p")) {
                printAllTasks();

            }
            if (input.equals("d")) {
                removeTask();

            }
            if (input.equals("b")) {
                System.out.println("Beenden");
                System.exit(0);
            } else {
                System.out.println("Eingabe nicht zulässig.");
            }
        }
    }

    public void addTask() {
        String input = this.scanner.nextLine();
        TaskVO task = new TaskVO(0, input);
        this.taskDAO.insertTask(task);
        printAllTasks();
    }

    public void printAllTasks() {
        // System.out.println("printing");
        List<TaskVO> tasks = this.taskDAO.getAllTasks();

        for (TaskVO task : tasks) {
            System.out.println("id: " + task.getId() + " name: " + task.getName());
        }
    }

    public void removeTask() {
        System.out.println("Welcher Task soll gelöscht werden? Eingabe per ID");
        printAllTasks();
        int input = this.scanner.nextInt();
        TaskVO task = new TaskVO(input, "");
        this.taskDAO.deleteTask(task);

    }
}
