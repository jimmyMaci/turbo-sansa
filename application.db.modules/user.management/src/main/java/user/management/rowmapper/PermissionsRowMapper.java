package user.management.rowmapper;

import org.springframework.jdbc.core.BeanPropertyRowMapper;

import user.management.model.Permissions;

public class PermissionsRowMapper extends BeanPropertyRowMapper<Permissions> {

	public PermissionsRowMapper() {
		this(Permissions.class);
	}

	public PermissionsRowMapper(Class<Permissions> mappedClass) {
		super(mappedClass);
	}
}
