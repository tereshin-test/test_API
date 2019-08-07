public class Task {

    private String content;

    private int priority;

    public Task(String content) {
        this.content = content;
        this.priority = 1;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Task[Content:" + content + ", Priority: " + priority + "]";
    }
}
