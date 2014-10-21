package events.system.service;

import hbm.service.jpa.AbstractBusinessService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import events.system.daos.UserContactsAllowedContactmethodsDao;
import events.system.model.UserContactsAllowedContactmethods;
import events.system.service.api.UserContactsAllowedContactmethodsService;

@Transactional
@Service("userContactsAllowedContactmethodsService")
public class UserContactsAllowedContactmethodsBusinessService
		extends
		AbstractBusinessService<UserContactsAllowedContactmethods, java.lang.Integer, UserContactsAllowedContactmethodsDao>
		implements UserContactsAllowedContactmethodsService {

	private static final long serialVersionUID = 1L;

	@Autowired
	public void setUserContactsAllowedContactmethodsDao(
			UserContactsAllowedContactmethodsDao userContactsAllowedContactmethodsDao) {
		setDao(userContactsAllowedContactmethodsDao);
	}

}