package lutchat;

public abstract class Task {
    boolean done;
    String desc;

    public Task(String d) {
        desc = d;
        done = false;
    }

    public boolean isDone() {
        return done;
    }

    public void markAsDone() {
        this.done = true;
    }

    public void markAsUndone() {
        this.done = false;
    }

    public String toFileFormat() {
        return getTaskType() + " | "
                + (done ? "1" : "0") + " | "
                + desc
                + additionalDescDetailsToFileFormat();
    }

    public boolean contains(String str) {
        if (desc.contains(str)) {
            return true;
        }
        return false;
    }

    public abstract String getTaskType();
    public abstract String additionalDescDetailsToFileFormat();

    @Override
    public String toString() {
        if (done) {
            return "[X] " + desc;
        } else
            return "[ ] " + desc;
    }
}
