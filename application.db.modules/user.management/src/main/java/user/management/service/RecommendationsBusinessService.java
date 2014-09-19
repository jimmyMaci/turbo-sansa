package user.management.service;

import hbm.service.jpa.AbstractBusinessService;

import java.util.List;

import javax.persistence.Query;

import net.sourceforge.jaulp.collections.ListUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import user.management.daos.RecommendationsDao;
import user.management.model.Recommendations;
import user.management.model.Users;
import user.management.service.api.RecommendationsService;
import user.management.service.utils.HqlStringCreator;

@Transactional
@Service("recommendationsService")
public class RecommendationsBusinessService extends AbstractBusinessService<Recommendations, Integer, RecommendationsDao> implements RecommendationsService {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	public void setRecommendationsDao(RecommendationsDao recommendationsDao) {
		setDao(recommendationsDao);
	}	
	
	public Recommendations findRecommendations(Users user, Users recommended,  String email) {
		return ListUtils.getFirst(find(user, recommended, email));
	}
	
	@SuppressWarnings("unchecked")
	public List<Recommendations> find(Users user, Users recommended,  String email) {
		String hqlString = HqlStringCreator.forRecommendations(user, recommended, email);
		final Query query = getQuery(hqlString);
		if(user != null){
			query.setParameter("user", user);
		}
		if(recommended != null){
			query.setParameter("recommended", recommended);
		}
		if(email != null){
			query.setParameter("email", email);			
		}
		final List<Recommendations> recommendations = query.getResultList();
		return recommendations;		
	}

}