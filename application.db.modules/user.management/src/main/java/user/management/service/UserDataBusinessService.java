package user.management.service;

import hbm.service.jpa.AbstractBusinessService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import user.management.daos.UserDataDao;
import user.management.model.UserData;
import user.management.service.api.UserDataService;

@Transactional
@Service("userDataService")
public class UserDataBusinessService extends AbstractBusinessService<UserData, Integer, UserDataDao> implements UserDataService {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	public void setUserDataDao(UserDataDao userDataDao) {
		setDao(userDataDao);
	}

}