package events.system.service;

import hbm.service.jpa.AbstractBusinessService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import events.system.daos.ProfileTopicsDao;
import events.system.model.ProfileTopics;
import events.system.service.api.ProfileTopicsService;

@Transactional
@Service("profileTopicsService")
public class ProfileTopicsBusinessService
		extends
		AbstractBusinessService<ProfileTopics, java.lang.Integer, ProfileTopicsDao>
		implements ProfileTopicsService {

	private static final long serialVersionUID = 1L;

	@Autowired
	public void setProfileTopicsDao(ProfileTopicsDao profileTopicsDao) {
		setDao(profileTopicsDao);
	}

}