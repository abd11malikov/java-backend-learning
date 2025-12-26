package taskflow.model;

public class Feature extends Task{
    private String deadline;

    public Feature(int id, String title, Priority priority, String deadline) {
        super(id, title, priority);
        this.deadline = deadline;
    }

    @Override
    public String getDetails() {
        return "✨ FEATURE [ID:" + getId() + "] " + getTitle() +
                " | Priority: " + getPriority() +
                " | Deadline: " + deadline +
                " | Status: " + getStatus();
    }
}
