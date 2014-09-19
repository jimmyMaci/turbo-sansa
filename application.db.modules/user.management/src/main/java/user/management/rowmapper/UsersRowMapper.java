package user.management.rowmapper;
import java.sql.ResultSet;  
import java.sql.SQLException;  
import org.springframework.jdbc.core.RowMapper; 

import user.management.model.UserData;
import user.management.model.Users;
  
public class UsersRowMapper implements RowMapper<Users> {  
  
 @Override  
 public Users mapRow(ResultSet resultSet, int line) throws SQLException {  
	 Users user = new Users();
	 user.setId(resultSet.getInt(1));
	 user.setActive(resultSet.getBoolean(2));
	 user.setLocked(resultSet.getBoolean(3));
	 user.setPw(resultSet.getString(4));
	 user.setSalt(resultSet.getString(5));
	 user.setUsername(resultSet.getString(6));
	 UserData userdata = new UserData();
	 userdata.setId(resultSet.getInt(7));
	 user.setUserData(userdata);
  return user;  
 }  
  
} 