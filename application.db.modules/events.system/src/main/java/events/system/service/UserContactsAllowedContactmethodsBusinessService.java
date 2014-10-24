package events.system.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import hbm.service.jpa.AbstractBusinessService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import user.management.model.Contactmethods;
import user.management.model.Users;
import events.system.daos.UserContactsAllowedContactmethodsDao;
import events.system.factories.DomainObjectFactory;
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

	/**
	 * {@inheritDoc}
	 */
	public List<UserContactsAllowedContactmethods> saveUserContactsAllowedContactmethods(
			final List<Contactmethods> userContactmethods,
			final Users userContact) {
		List<UserContactsAllowedContactmethods> userContactsAllowedContactmethods = new ArrayList<UserContactsAllowedContactmethods>();
		for (final Iterator<Contactmethods> iterator = userContactmethods
				.iterator(); iterator.hasNext();) {
			final Contactmethods userContactmethod = iterator.next();
			UserContactsAllowedContactmethods userContactsAllowedContactmethod = DomainObjectFactory
					.getInstance().getUserContactsAllowedContactmethods(
							userContact, userContactmethod);
			userContactsAllowedContactmethod = 
					merge(userContactsAllowedContactmethod);
			userContactsAllowedContactmethods
					.add(userContactsAllowedContactmethod);
		}
		return userContactsAllowedContactmethods;
	}

}