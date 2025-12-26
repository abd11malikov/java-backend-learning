package taskflow.model;

public class Bug extends Task{
    private String severity;

    public Bug(int id, String title, Priority priority, String severity) {
        super(id, title, priority);
        this.severity = severity;
    }

    @Override
    public String getDetails() {
        return "🐞 BUG [ID:" + getId() + "] " + getTitle() +
                " | Priority: " + getPriority() +
                " | Severity: " + severity +
                " | Status: " + getStatus();
    }
}
