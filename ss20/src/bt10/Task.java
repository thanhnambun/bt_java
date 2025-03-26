package bt10;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Task {
    private int id;
    private String title;
    private User assignedTo;
    private LocalDate dueDate;
    private boolean completed;

    public Task(int id, String title, User assignedTo, LocalDate dueDate, boolean completed) {
        this.id = id;
        this.title = title;
        this.assignedTo = assignedTo;
        this.dueDate = dueDate;
        this.completed = completed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public User getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(User assignedTo) {
        this.assignedTo = assignedTo;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public void toDisplayString(){

    }

    public static void main(String[] args) {
        User u1 = new User(1, "Quý", "quy@example.com");

        User u2 = new User(2, "Lan", null);

        User u3 = new User(3, "Huyền", "huyen@example.com");
        List<Task> tasks = List.of(
                new Task(1, "Viết báo cáo", u1, LocalDate.of(2025, 3, 20), false),
                new Task(2, "Thiết kế slide", u1, LocalDate.of(2025, 3, 25), true),
                new Task(3, "Họp nhóm", u2, LocalDate.of(2025, 3, 18), false),
                new Task(4, "Nộp tài liệu", u3, LocalDate.of(2025, 3, 22), true),
                new Task(5, "Chuẩn bị thuyết trình", u2, LocalDate.of(2025, 3, 19), true));
        tasks.stream()
                .filter(task->!task.completed && task.dueDate.isBefore(LocalDate.of(2025,3,23)))
                .forEach(task-> System.out.println("Công việc: " + task.getTitle() +
                        " | Người thực hiện: " + task.getAssignedTo().getName() +
                        " | Hạn chót: " + task.getDueDate()));
        long completeTrue = tasks.stream()
                .filter(Task :: isCompleted).count();
        System.out.println("tổng số công việc hoàn thành " + completeTrue);

        List<User>  users = List.of(u1, u2, u3);
        users.forEach(u-> {
            long total = tasks.stream().filter(task ->  task.assignedTo.equals(u)).count();
            long overTotal = tasks.stream().filter(task ->!task.completed &&  task.assignedTo.equals(u)).count();
            System.out.println("tên"+u.getName() +"|| email" +u.getEmail()+"|| tổng vieecj : "+total+"|| Quá hạn"+overTotal );
        });

    }

}
