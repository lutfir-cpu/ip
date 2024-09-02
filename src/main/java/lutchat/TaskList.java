package lutchat;

import java.util.ArrayList;

public class TaskList {
    private final ArrayList<Task> tasks;

    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    private boolean isValidIndex(int index) {
        return index >= 0 && index < tasks.size();
    }

    public void addTask(Task task, Ui ui) {
        tasks.add(task);
        ui.showTaskAdded(task, tasks.size());
    }

    public void deleteTask(int index, Ui ui) {
        if (!isValidIndex(index)) {
            ui.showError("Invalid task index. Please try again.");
            return;
        }
        Task task = tasks.remove(index);
        ui.showTaskRemoved(task, tasks.size());
    }

    public void markTaskAsDone(int index, Ui ui) {
        if (!isValidIndex(index)) {
            ui.showError("Invalid task index. Please try again.");
            return;
        }
        Task task = tasks.get(index);
        task.markAsDone();
        ui.showTaskMarked(task);
    }

    public void markTaskAsUndone(int index, Ui ui) {
        if (!isValidIndex(index)) {
            ui.showError("Invalid task index. Please try again.");
            return;
        }
        Task task = tasks.get(index);
        task.markAsUndone();
        ui.showTaskUnmarked(task);
    }
}
