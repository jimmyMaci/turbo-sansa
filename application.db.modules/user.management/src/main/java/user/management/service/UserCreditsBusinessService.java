package user.management.service;


import hbm.service.jpa.AbstractBusinessService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import user.management.daos.UserCreditsDao;
import user.management.model.UserCredits;
import user.management.service.api.UserCreditsService;

@Transactional
@Service("userCreditsService")
public class UserCreditsBusinessService extends AbstractBusinessService<UserCredits, Integer, UserCreditsDao> implements UserCreditsService {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	public void setUserCreditsDao(UserCreditsDao userCreditsDao) {
		setDao(userCreditsDao);
	}

}