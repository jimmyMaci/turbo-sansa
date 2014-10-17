package flirt.and.date.hbm.service;

import flirt.and.date.hbm.daos.ProfileRatingsDao;
import flirt.and.date.hbm.model.ProfileRatings;
import flirt.and.date.hbm.service.api.ProfileRatingsService;
import hbm.service.jpa.AbstractBusinessService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("profileRatingsService")
public class ProfileRatingsBusinessService extends AbstractBusinessService<ProfileRatings, Integer, ProfileRatingsDao> implements ProfileRatingsService {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	public void setProfileRatingsDao(ProfileRatingsDao profileRatingsDao) {
		setDao(profileRatingsDao);
	}

}