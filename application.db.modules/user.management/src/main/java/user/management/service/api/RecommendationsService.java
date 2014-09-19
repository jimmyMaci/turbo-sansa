package user.management.service.api;

import java.util.List;

import hbm.service.jpa.BusinessService;
import user.management.model.Recommendations;
import user.management.model.Users;

public interface RecommendationsService extends BusinessService<Recommendations, Integer> {
	List<Recommendations> find(Users user, Users recommended,  String email);
	Recommendations findRecommendations(Users user, Users recommended,  String email);
}