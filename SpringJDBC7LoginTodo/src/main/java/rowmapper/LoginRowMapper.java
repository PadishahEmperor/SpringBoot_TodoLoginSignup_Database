package rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import model.User;

public class LoginRowMapper implements RowMapper<User> { // Generics class, type defined as User

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		// Define a new User Object
		User user = new User(); // New Instance of User, different from what we created in different classes.
		
		user.setId(rs.getLong("id"));
		user.setEmail(rs.getString("email"));
		//user.setName(rs.getString("name")); Not needed, and Query only returing id, email, password
		user.setPassword(rs.getString("password"));
		return user;
	}
	
}
