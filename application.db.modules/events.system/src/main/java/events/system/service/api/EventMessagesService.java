package events.system.service.api;

import java.util.List;

import hbm.service.jpa.BusinessService;
import message.system.model.Messages;
import events.system.model.EventLocations;
import events.system.model.EventMessages;

public interface EventMessagesService extends
		BusinessService<EventMessages, java.lang.Integer> {

	EventMessages findEventMessagesFromMessage(Messages message);

	EventMessages findEventMessagesFromEventLocation(EventLocations eventLocation);
	
	List<EventMessages> find(Messages message, EventLocations eventLocation);
}