package flirt.and.date.hbm.service;

import flirt.and.date.hbm.daos.ProfileVisitorsDao;
import flirt.and.date.hbm.model.ProfileVisitors;
import flirt.and.date.hbm.model.UserProfile;
import flirt.and.date.hbm.service.api.ProfileVisitorsService;
import flirt.and.date.hbm.service.utils.HqlStringCreator;
import hbm.service.jpa.AbstractBusinessService;

import java.util.List;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import user.management.model.Users;

@Transactional
@Service("profileVisitorsService")
public class ProfileVisitorsBusinessService extends AbstractBusinessService<ProfileVisitors, Integer, ProfileVisitorsDao> implements ProfileVisitorsService {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	public void setProfileVisitorsDao(ProfileVisitorsDao profileVisitorsDao) {
		setDao(profileVisitorsDao);
	}
	

	
	public ProfileVisitors find(Users visitor, UserProfile visitedProfile) {
		final List<ProfileVisitors> profileVisitors = findAll(visitor, visitedProfile);
		if(profileVisitors != null && !profileVisitors.isEmpty()){
			return profileVisitors.get(0);
		}
		return null;	
	}
	
	@SuppressWarnings("unchecked")
	public List<ProfileVisitors> findAll(Users visitor, UserProfile visitedProfile){
		final String hqlString = HqlStringCreator.forProfileVisitors(visitor, visitedProfile);
		final Query query = getQuery(hqlString);
		if(visitor != null) {
			query.setParameter("visitor", visitor);
		}
		if(visitedProfile != null) {
			query.setParameter("visitedProfile", visitedProfile);
		}
		final List<ProfileVisitors> profileVisitors = query.getResultList();
		return profileVisitors;
	}
	
	public List<ProfileVisitors> findProfileVisitors(UserProfile visitedProfile) {
		final List<ProfileVisitors> profileVisitors = findAll(null, visitedProfile);
		return profileVisitors;
	}

}