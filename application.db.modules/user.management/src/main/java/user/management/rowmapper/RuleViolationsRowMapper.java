package user.management.rowmapper;

import org.springframework.jdbc.core.BeanPropertyRowMapper;

import user.management.model.RuleViolations;

public class RuleViolationsRowMapper extends BeanPropertyRowMapper<RuleViolations> {

	public RuleViolationsRowMapper() {
		this(RuleViolations.class);
	}

	public RuleViolationsRowMapper(Class<RuleViolations> mappedClass) {
		super(mappedClass);
	}
}
