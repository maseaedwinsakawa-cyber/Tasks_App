
import java.util.ArrayList;
import java.util.Scanner;

class ToDoList {

    private ArrayList<String> tasks;
    private int taskCount;

    public ToDoList() {
        tasks = new ArrayList<>();
        taskCount = 0;
    }

    //Method to add a new task to the list 
    public void createTask(String task) {
        System.out.println("Welcome to our adding interface" + task);
        tasks.add(task);
        taskCount++;
        System.out.println("Task added: " + task);
    }

    //Method to view all available tasks in the list 
    public void viewTasks() {
        System.out.println("Welcome to our viewing interface");
        if (taskCount == 0) {
            System.out.println("No tasks available.");
        } else {
            System.out.println("Here are the Available Tasks:");
            for (int i = 0; i < taskCount; i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    //Method to delete  a task from the list
    public void deleteTask(int taskNumber) {
        System.out.println("Welcome to our deleting interface");
        if (taskNumber < 1 || taskNumber > taskCount) {
            System.out.println("Invalid task number.");
        } else {
            String removedTask = tasks.remove(taskNumber - 1);
            taskCount--;
            System.out.println("Task deleted: " + removedTask);
        }
    }

    // Method to mark task as done 
    public void markTaskAsDone(int taskNumber) {
        System.out.println("Welcome to the marking as done interface");
        if (taskNumber < 1 || taskNumber > taskCount) {
            System.out.println(" Invalid task number.");

        } else {
            String task = tasks.get(taskNumber - 1);
            tasks.set(taskNumber - 1, task + " (Done)");
            System.out.println("Task marked as Done " + task);
        }
    }

    // Method to exit the application 
    public void exitApp() {
        System.out.println("Thank you for your time using our application");
        System.exit(0);
    }

    // Method to open the menu with all the app functions 
    public void openMenu() {
        Scanner user = new Scanner(System.in);
        while (true) {
            System.out.println("*****Welcome to our App****");
            System.out.println("-----Options-----");
            System.out.println(" 1. Create Task ");
            System.out.println(" 2. View Tasks ");
            System.out.println(" 3. Delete Task ");
            System.out.println(" 4. Mark as done ");
            System.out.println(" 5. Exit the application ");
            System.out.println("Enter your choice of action \n");
            int select = user.nextInt();
            user.nextLine();

            if (select == 1) {
                System.out.println("Enter the task you wanna add \n");
                String task = user.nextLine();
                createTask(task);
                System.out.println("**Task added Successfully**");

            } else if (select == 2) {
                viewTasks();
            } else if (select == 3) {
                System.out.println("Enter the task number ");
                int taskNumber = user.nextInt();
                user.nextLine();
                deleteTask(taskNumber);
                System.out.println("***Task deleted successfully***");
            } else if (select == 4) {
                System.out.println("Enter the task number you want to mark as done \n");
                int taskNumber = user.nextInt();
                user.nextLine();
                markTaskAsDone(taskNumber);
                System.out.println("****Task marked as done successfully***");

            } else {
                exitApp();
            }
        }
    }

    public static void main(String[] args) {
        ToDoList mylist = new ToDoList();
        mylist.openMenu();
    }
}
