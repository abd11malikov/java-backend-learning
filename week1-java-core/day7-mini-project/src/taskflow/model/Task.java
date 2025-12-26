package taskflow.model;


public abstract class Task implements Comparable<Task>
{
    private int id;
    private String title;
    private Priority priority;
    private Status status;

    public Task(int id, String title, Priority priority) {
        this.id = id;
        this.title = title;
        this.priority = priority;
        this.status = Status.PENDING;
    }

    public abstract String getDetails();

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Priority getPriority() {
        return priority;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }


    @Override
    public int compareTo(Task other) {
        return other.priority.compareTo(this.priority);
    }


}
