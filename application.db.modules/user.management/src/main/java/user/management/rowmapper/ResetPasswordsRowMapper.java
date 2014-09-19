package user.management.rowmapper;

import org.springframework.jdbc.core.BeanPropertyRowMapper;

import user.management.model.ResetPasswords;

public class ResetPasswordsRowMapper extends BeanPropertyRowMapper<ResetPasswords> {

	public ResetPasswordsRowMapper() {
		this(ResetPasswords.class);
	}

	public ResetPasswordsRowMapper(Class<ResetPasswords> mappedClass) {
		super(mappedClass);
	}
}
