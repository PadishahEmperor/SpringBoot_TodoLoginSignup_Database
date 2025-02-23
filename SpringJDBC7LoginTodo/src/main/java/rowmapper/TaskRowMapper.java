package rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import model.Task;

public class TaskRowMapper implements RowMapper<Task> {

	@Override
	public Task mapRow(ResultSet rs, int rowNum) throws SQLException {
		// Create new isntance of  Task();
		Task task = new Task();
		
		task.setTaskId(rs.getInt("id"));
		task.setCompleted(rs.getBoolean("completed"));
		task.setEmail(rs.getString("email"));
		task.setUserId(rs.getLong("user_id"));
		task.setTask(rs.getString("task"));
		
		return task;
	}

}
