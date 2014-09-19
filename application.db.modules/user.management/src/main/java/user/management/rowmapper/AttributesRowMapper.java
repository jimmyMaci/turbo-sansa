package user.management.rowmapper;

import org.springframework.jdbc.core.BeanPropertyRowMapper;

import user.management.model.Attributes;

public class AttributesRowMapper extends BeanPropertyRowMapper<Attributes> {

	public AttributesRowMapper() {
		this(Attributes.class);
	}

	public AttributesRowMapper(Class<Attributes> mappedClass) {
		super(mappedClass);
	}
}
