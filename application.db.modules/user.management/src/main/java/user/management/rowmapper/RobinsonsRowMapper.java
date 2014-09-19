package user.management.rowmapper;

import org.springframework.jdbc.core.BeanPropertyRowMapper;

import user.management.model.Robinsons;

public class RobinsonsRowMapper extends BeanPropertyRowMapper<Robinsons> {

	public RobinsonsRowMapper() {
		this(Robinsons.class);
	}

	public RobinsonsRowMapper(Class<Robinsons> mappedClass) {
		super(mappedClass);
	}
}
