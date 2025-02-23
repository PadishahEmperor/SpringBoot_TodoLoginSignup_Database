package repositories;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import model.User;
import rowmapper.LoginRowMapper;


@Repository
public class LoginDataRepository {
	// DI JDBC datasource
	private final JdbcTemplate jdbc;

	public LoginDataRepository(JdbcTemplate jdbc) {
		super();
		this.jdbc = jdbc;
	}
	
	public User getUser(User user) { // 
		// Sql Query
		String sql = "Select id, email, password from userDetails where email=? and password=?";
		
		// Jdbc with row mapper with try catch
		try {
			return jdbc.queryForObject(sql, new LoginRowMapper(),user.getEmail(),user.getPassword());
		}catch(EmptyResultDataAccessException e) { //Throws EmptyResultDataAccessException if no user is found and Spring Catches it
			return null; // If no user was found.
		}
		
	}
	
}
