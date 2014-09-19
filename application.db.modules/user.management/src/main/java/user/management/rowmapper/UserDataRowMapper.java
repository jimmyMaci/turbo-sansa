package user.management.rowmapper;

import org.springframework.jdbc.core.BeanPropertyRowMapper;

import user.management.model.UserData;

public class UserDataRowMapper extends BeanPropertyRowMapper<UserData> {

	public UserDataRowMapper() {
		this(UserData.class);
	}

	public UserDataRowMapper(Class<UserData> mappedClass) {
		super(mappedClass);
	}
}
