package flirt.and.date.hbm.service;

import flirt.and.date.hbm.daos.FavoriteMembersDao;
import flirt.and.date.hbm.model.FavoriteMembers;
import flirt.and.date.hbm.model.UserProfile;
import flirt.and.date.hbm.service.api.FavoriteMembersService;
import flirt.and.date.hbm.service.utils.HqlStringCreator;
import hbm.service.jpa.AbstractBusinessService;

import java.util.List;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import user.management.model.Users;

@Transactional
@Service("favoriteMembersService")
public class FavoriteMembersBusinessService extends AbstractBusinessService<FavoriteMembers, Integer, FavoriteMembersDao> implements FavoriteMembersService {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	public void setFavoriteMembersDao(FavoriteMembersDao favoriteMembersDao) {
		setDao(favoriteMembersDao);
	}
	@Transactional
	public FavoriteMembers find(Users owner, UserProfile favorite) {
		final List<FavoriteMembers> favoriteMembers = findAll(owner, favorite);
		if(favoriteMembers != null && !favoriteMembers.isEmpty()){
			return favoriteMembers.get(0);
		}
		return null;	
	}
	@Transactional
	@SuppressWarnings("unchecked")	
	public List<FavoriteMembers> findAll(Users owner, UserProfile favorite) {
		final String hqlString = HqlStringCreator.forFavoriteMembers(owner, favorite);
		final Query query = getQuery(hqlString);
		if(owner != null) {
			query.setParameter("owner", owner);
		}
		if(favorite != null) {
			query.setParameter("favorite", favorite);
		}
		final List<FavoriteMembers> favoriteMembers = query.getResultList();
		return favoriteMembers;
	}
	
	@SuppressWarnings("unchecked")
	public List<FavoriteMembers> find(Users owner){
		final String hqlString = HqlStringCreator.forFavoriteMembers(owner, null);
		final Query query = getQuery(hqlString);
		query.setParameter("owner", owner);
		final List<FavoriteMembers> favoriteMembers = query.getResultList();
		return favoriteMembers;
	}

}