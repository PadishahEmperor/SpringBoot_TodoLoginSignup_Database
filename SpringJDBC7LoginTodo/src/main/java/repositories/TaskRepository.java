package repositories;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import model.Task;
import rowmapper.TaskRowMapper;

@Repository
public class TaskRepository {
	// Get the Datasource JDBC template
	private final JdbcTemplate jdbc;

	public TaskRepository(JdbcTemplate jdbc) {
		super();
		this.jdbc = jdbc;
	}
	
	//List of Tasks
	public List<Task> getTasks(long userId){
		//Sql query
		String sql = "Select tasks.id, user_id,email, task, completed from tasks join userDetails on userDetails.id = tasks.user_id where user_id=?"; 			
		// UserId will come from login Processor				   // UserId of the Guy who is loggedIn
		
		// Need a rowMapper for Select Query
		
		return jdbc.query(sql, new TaskRowMapper(), userId );
	}
	
	//Add Tasks
	public void addTask(long userId, String task) {
		//Query
		String sql = "Insert into tasks (user_id, task) values (?,?)";
		
		//Jdbc update, Insert Query!
		jdbc.update(sql,userId,task );
	}

	public void updateTask(int taskId,boolean completed) {
		//Sql Query
		String sql = "update tasks set completed=? where id=?";
		
		// Row Mapper needed?? 
		
		jdbc.update(sql,completed, taskId); // No dont think so! will upadate the dB with the opposite boolean
		
	}
	
	public void deleteTask(int taskId) {
		//Sql Query
		String sql = "delete from tasks where id=?";
		
		jdbc.update(sql,taskId);
	}
	
	
}
