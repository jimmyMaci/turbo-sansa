package flirt.and.date.hbm.service.api;

import flirt.and.date.hbm.model.ProfileVisitors;
import flirt.and.date.hbm.model.UserProfile;
import hbm.service.jpa.BusinessService;

import java.util.List;

import user.management.model.Users;

// TODO: Auto-generated Javadoc
/**
 * The Interface ProfileVisitorsService.
 */
public interface ProfileVisitorsService extends BusinessService<ProfileVisitors, Integer>{
	
	/**
	 * Find the first occurence from the given parameters.
	 *
	 * @param visitor the visitor
	 * @param visitedProfile the visited profile
	 * @return the profile visitors
	 */
	ProfileVisitors find(Users visitor, UserProfile visitedProfile);
	
	/**
	 * Find all from the given parameters.
	 *
	 * @param visitor the visitor
	 * @param visitedProfile the visited profile
	 * @return the list
	 */
	List<ProfileVisitors> findAll(Users visitor, UserProfile visitedProfile);
	
	/**
	 * Find profile visitors from the given profile.
	 *
	 * @param visitedProfile the visited profile
	 * @return the list
	 */
	List<ProfileVisitors> findProfileVisitors(UserProfile visitedProfile);
}