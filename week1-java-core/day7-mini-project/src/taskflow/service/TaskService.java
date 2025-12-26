package taskflow.service;

import taskflow.model.Status;
import taskflow.model.Task;
import taskflow.exceptions.TaskNotFoundException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class TaskService {
    private List<Task> tasks = new ArrayList<>();

    public void addTask(Task task){
        tasks.add(task);
        System.out.println("Task added ");
    }

    public List<Task> getAllTasksSorted(){
        Collections.sort(tasks);
        return tasks;
    }

    public List<Task> getTasksByStatus(Status status) {
        return tasks.stream()
                .filter(task -> task.getStatus()==(status)).collect(Collectors.toList());
    }

    public void markTaskAsDone(int id){
        Task task = findById(id);
        task.setStatus(Status.DONE);
        System.out.println("Task "+id+" completed");
    }

    private Task findById(int id) {
        return tasks.stream().filter(task -> task.getId() == id)
                .findFirst().orElseThrow(()-> new TaskNotFoundException("Tash with and id "+id+" not found"));
    }

    public void printStatistics(){
        long bugs = tasks.stream().filter(task -> task.getDetails().contains("\uD83D\uDC1E")).count();
        long done = tasks.stream().filter(task -> task.getStatus()==Status.DONE).count();

        System.out.println("Statistics");
        System.out.println("Total tasks : "+tasks.size());
        System.out.println("Bugs : "+bugs);
        System.out.println("Completed : "+done);
    }

}
