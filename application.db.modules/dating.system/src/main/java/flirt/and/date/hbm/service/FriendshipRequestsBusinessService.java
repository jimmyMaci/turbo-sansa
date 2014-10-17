package flirt.and.date.hbm.service;

import flirt.and.date.hbm.daos.FriendshipRequestsDao;
import flirt.and.date.hbm.enums.FriendshipRequestsState;
import flirt.and.date.hbm.model.FriendshipRequests;
import flirt.and.date.hbm.service.api.FriendshipRequestsService;
import flirt.and.date.hbm.service.utils.HqlStringCreator;
import hbm.service.jpa.AbstractBusinessService;

import java.util.List;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import user.management.model.Users;

@Transactional
@Service("friendshipRequestsService")
public class FriendshipRequestsBusinessService extends AbstractBusinessService<FriendshipRequests, Integer, FriendshipRequestsDao> implements FriendshipRequestsService {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	public void setFriendshipRequestsDao(FriendshipRequestsDao friendshipRequestsDao) {
		setDao(friendshipRequestsDao);
	}
	
	public FriendshipRequests find(Users requestor, Users requestedUser) {
		return find(requestor, requestedUser, null);	
	}
	
	public FriendshipRequests find(Users requestor, Users requestedUser, FriendshipRequestsState state) {
		final List<FriendshipRequests> friendshipRequests = findAll(requestor, requestedUser, state);
		if(friendshipRequests != null && !friendshipRequests.isEmpty()){
			return friendshipRequests.get(0);
		}
		return null;	
	}
	
	@SuppressWarnings("unchecked")
	public List<FriendshipRequests> findAll(Users requestor, Users requestedUser, FriendshipRequestsState state) {
		final String hqlString = HqlStringCreator.forFriendshipRequests(requestor, requestedUser, state);
		final Query query = getQuery(hqlString);
		if(requestor != null){
			query.setParameter("requestor", requestor);
		}
		if(requestedUser != null){
			query.setParameter("requestedUser", requestedUser);
		}
		if(state != null) {
			query.setParameter("state", state);
		}
		final List<FriendshipRequests> friendshipRequests = query.getResultList();
		return friendshipRequests;
	}
}