package controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.Task;
import services.LoginManagementService;
import services.TaskService;

@Controller
public class TaskController {
	//DI
	private final TaskService taskService;
	private final LoginManagementService loginManagementService;

	public TaskController(TaskService taskService, LoginManagementService loginManagementService) {
		super();
		this.taskService = taskService;
		this.loginManagementService = loginManagementService;
		
	}
	
	//Create... Read...
	@GetMapping("/taskManager")
	public String getAllTasks(@RequestParam(required=false) String logout, Model model){ //when logout clicked not clicked its null by default
		
		if(logout != null) { // Meanning some string came, or the button logout was clicked
			this.loginManagementService.setUsername(null);
			this.loginManagementService.setUserId(0);
		}
		
		// Normal request came or logout was clicked...
		if(this.loginManagementService.getUsername() == null) { // This is only checking if the username is null(meaning new request) from the ManagementService
			return "redirect:/";								// This is not checking if the logout is null or not, if it was not null(meaning btn was clicked) username was set to null
		}
		
		//get List of user Task objects and populate the Model with it
		long userId = this.loginManagementService.getUserId();
		List <Task> tasks = this.taskService.getTasks(userId);
		model.addAttribute("taskList", tasks);
		//System.out.println(tasks.get(0).getTask() + ": " + tasks.get(0).getTaskId());
		return "task.html";
	}
	
	// Add...
	@PostMapping("/taskManager")
	public String postTask(@RequestParam String task, Model model) {
		long userId = this.loginManagementService.getUserId();
		this.taskService.addTask(userId, task);
		List<Task> tasks = this.taskService.getTasks(userId);
		model.addAttribute("taskList",tasks);
		return "task.html";
	}
	
	// Update...
	@PostMapping("/taskManager/updateTaskStatus")
	public String updateStatus(@RequestParam(required = false) int taskId, @RequestParam(required = false) boolean completed, Model model) {
		
		long userId = this.loginManagementService.getUserId();
		
		//updating the task status
		this.taskService.updateTaskStatus(taskId, completed);
		List<Task> tasks = this.taskService.getTasks(userId);  // Sending tasks for only that particular user!
		model.addAttribute("taskList",tasks);
		
		return "task.html";
	}
	
	//Delete...
	@PostMapping("/taskManager/deleteTask")
	public String taskDelete(@RequestParam(required = false) int taskId, Model model) {
		long userId = this.loginManagementService.getUserId();
		
		this.taskService.deleteTask(taskId);
		List<Task> tasks = this.taskService.getTasks(userId);  // Sending tasks for only that particular user!
		model.addAttribute("taskList",tasks);
		
		return "task.html";
	}
	
}
