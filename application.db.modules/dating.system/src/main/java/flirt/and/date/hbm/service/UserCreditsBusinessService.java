package flirt.and.date.hbm.service;

import flirt.and.date.hbm.daos.UserCreditsDao;
import flirt.and.date.hbm.model.UserCredits;
import flirt.and.date.hbm.service.api.UserCreditsService;
import hbm.service.jpa.AbstractBusinessService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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