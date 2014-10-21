package events.system.service;

import hbm.service.jpa.AbstractBusinessService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import events.system.daos.ProfileFederalstatesDao;
import events.system.model.ProfileFederalstates;
import events.system.service.api.ProfileFederalstatesService;

@Transactional
@Service("profileFederalstatesService")
public class ProfileFederalstatesBusinessService
		extends
		AbstractBusinessService<ProfileFederalstates, java.lang.Integer, ProfileFederalstatesDao>
		implements ProfileFederalstatesService {

	private static final long serialVersionUID = 1L;

	@Autowired
	public void setProfileFederalstatesDao(
			ProfileFederalstatesDao profileFederalstatesDao) {
		setDao(profileFederalstatesDao);
	}

}