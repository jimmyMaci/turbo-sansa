package user.management.rowmapper;

import org.springframework.jdbc.core.BeanPropertyRowMapper;

import user.management.model.Recommendations;

public class RecommendationsRowMapper extends BeanPropertyRowMapper<Recommendations> {

	public RecommendationsRowMapper() {
		this(Recommendations.class);
	}

	public RecommendationsRowMapper(Class<Recommendations> mappedClass) {
		super(mappedClass);
	}
}
