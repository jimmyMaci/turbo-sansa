package flirt.and.date.hbm.service.api;

import flirt.and.date.hbm.model.FavoriteMembers;
import flirt.and.date.hbm.model.UserProfile;
import hbm.service.jpa.BusinessService;

import java.util.List;

import user.management.model.Users;

/**
 * The Interface FavoriteMembersService.
 */
public interface FavoriteMembersService extends BusinessService<FavoriteMembers, Integer> {
	
	/**
	 * Gets a FavoriteMembers object from the given parameters that can be
	 * null if they shell be ignored in the query. If no result is found null
	 * will be returned.
	 *
	 * @param owner the owner
	 * @param favorite the favorite
	 * @return the favorite members
	 */
	FavoriteMembers find(Users owner, UserProfile favorite);
	
	/**
	 * Gets a List from FavoriteMembers with the given parameters that can be
	 * null if they shell be ignored in the query.
	 *
	 * @param owner the owner
	 * @param favorite the favorite
	 * @return the list
	 */
	List<FavoriteMembers> findAll(Users owner, UserProfile favorite);
	
	/**
	 * Gets  a List from FavoriteMembers that own the given Users object.
	 *
	 * @param owner the owner
	 * @return the list
	 */
	List<FavoriteMembers> find(Users owner);
}