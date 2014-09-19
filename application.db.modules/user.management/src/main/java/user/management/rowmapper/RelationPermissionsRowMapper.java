package user.management.rowmapper;

import org.springframework.jdbc.core.BeanPropertyRowMapper;

import user.management.model.RelationPermissions;

public class RelationPermissionsRowMapper extends BeanPropertyRowMapper<RelationPermissions> {

	public RelationPermissionsRowMapper() {
		this(RelationPermissions.class);
	}

	public RelationPermissionsRowMapper(Class<RelationPermissions> mappedClass) {
		super(mappedClass);
	}
}
