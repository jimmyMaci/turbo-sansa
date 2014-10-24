package events.system.service.api;

import java.util.List;

import user.management.model.Contactmethods;
import user.management.model.Users;
import events.system.model.UserContactsAllowedContactmethods;
import hbm.service.jpa.BusinessService;

/**
 * The Interface UserContactsAllowedContactmethodsService.
 */
public interface UserContactsAllowedContactmethodsService extends
		BusinessService<UserContactsAllowedContactmethods, java.lang.Integer> {

	/**
	 * Saves for the given user the list from the given allowed contactmethods.
	 *
	 * @param userContactmethods the user contactmethods
	 * @param userContact the user contact
	 * @return the list
	 */
	List<UserContactsAllowedContactmethods> saveUserContactsAllowedContactmethods(
			List<Contactmethods> userContactmethods, Users userContact);
}