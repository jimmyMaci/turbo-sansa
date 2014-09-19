package user.management.rowmapper;

import org.springframework.jdbc.core.BeanPropertyRowMapper;

import user.management.model.Contactmethods;

public class ContactmethodsRowMapper extends BeanPropertyRowMapper<Contactmethods> {

	public ContactmethodsRowMapper() {
		this(Contactmethods.class);
	}

	public ContactmethodsRowMapper(Class<Contactmethods> mappedClass) {
		super(mappedClass);
	}
}
