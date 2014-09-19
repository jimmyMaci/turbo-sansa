package user.management.rowmapper;

import org.springframework.jdbc.core.BeanPropertyRowMapper;

import user.management.model.Roles;

public class RolesRowMapper extends BeanPropertyRowMapper<Roles> {

	public RolesRowMapper() {
		this(Roles.class);
	}

	public RolesRowMapper(Class<Roles> mappedClass) {
		super(mappedClass);
	}
}
