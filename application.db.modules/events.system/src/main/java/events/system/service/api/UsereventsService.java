package events.system.service.api;

import java.util.List;

import user.management.model.Users;
import events.system.enums.UsereventsRelationType;
import events.system.model.EventTemplate;
import events.system.model.Userevents;
import hbm.service.jpa.BusinessService;

public interface UsereventsService extends
		BusinessService<Userevents, java.lang.Integer> {
	/**
	 * Find user.
	 * 
	 * @param eventtemplateToFind
	 *            the seminar to find
	 * @param relationtype
	 *            the relationtype
	 * @return the users
	 */
	Users findUser(final EventTemplate eventtemplateToFind,
			final UsereventsRelationType relationtype);

	List<Userevents> findUserevents(final EventTemplate event);
}