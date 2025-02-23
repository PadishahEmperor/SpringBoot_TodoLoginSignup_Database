package services;


import java.util.List;

import org.springframework.stereotype.Service;

import model.Task;
import repositories.TaskRepository;

@Service
public class TaskService {
	//private List<Task> tasks = new ArrayList<>();
	//DI TaskRepo
	private final TaskRepository taskRepository;
	
	
	public TaskService(TaskRepository taskRepository) {
		super();
		this.taskRepository = taskRepository;
	}


	public void addTask(long userId, String task) {
		this.taskRepository.addTask(userId, task);
	}
	
	public List<Task> getTasks(long userId){
		return this.taskRepository.getTasks(userId);
	}


	public void updateTaskStatus(int taskId, boolean completed) {
		this.taskRepository.updateTask(taskId,completed);
		
	}
	
	public void deleteTask(int taskId) {
		this.taskRepository.deleteTask(taskId);
	}
	
}
