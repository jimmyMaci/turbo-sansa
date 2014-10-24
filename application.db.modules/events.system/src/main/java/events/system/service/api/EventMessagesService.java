package events.system.service.api;

import hbm.service.jpa.BusinessService;

import java.util.List;

import message.system.enums.MessageState;
import message.system.model.Messages;
import user.management.model.Users;
import events.system.model.EventLocations;
import events.system.model.EventMessages;

public interface EventMessagesService extends
		BusinessService<EventMessages, java.lang.Integer> {

	EventMessages findEventMessagesFromMessage(Messages message);

	EventMessages findEventMessagesFromEventLocation(EventLocations eventLocation);
	
	List<EventMessages> find(Messages message, EventLocations eventLocation);

	/**
	 * Find messages from the given user in the given state.
	 * 
	 * @param user
	 *            the user
	 * @param state
	 *            the state
	 * @return the list
	 */
	List<EventMessages> findMessages(Users user, MessageState state);

	/**
	 * Find all messages from the given provider.
	 * 
	 * @param provider
	 *            the provider
	 * @return the list
	 */
	List<EventMessages> findMessages(final Users provider);
}