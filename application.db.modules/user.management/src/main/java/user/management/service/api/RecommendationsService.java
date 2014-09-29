package user.management.service.api;

import hbm.service.jpa.BusinessService;

import java.util.List;

import user.management.model.Recommendations;
import user.management.model.Users;

public interface RecommendationsService extends BusinessService<Recommendations, Integer> {
	List<Recommendations> find(Users user, Users recommended,  String email);
	Recommendations findRecommendations(Users user, Users recommended,  String email);
}