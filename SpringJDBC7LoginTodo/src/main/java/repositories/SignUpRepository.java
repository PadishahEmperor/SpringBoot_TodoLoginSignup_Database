package repositories;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import model.User;

@Repository
public class SignUpRepository {
	// JDBC datasource
	private final JdbcTemplate jdbc;

	public SignUpRepository(JdbcTemplate jdbc) {
		super();
		this.jdbc = jdbc;
	}
	
	public void storeSignupData(User user) { // Pass the User Object here (From Controller)
		//Sql query
		String sql = "Insert into userDetails (name, email, password) values (?,?,?)";
		
		// jdbc update- insert etc operations
		jdbc.update(sql,user.getName(), user.getEmail(),user.getPassword() ); // (1,2,3) - (?,?,?)
	}
	
}
