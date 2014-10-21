package events.system.service;

import hbm.service.jpa.AbstractBusinessService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import events.system.daos.EventMessagesDao;
import events.system.model.EventMessages;
import events.system.service.api.EventMessagesService;

@Transactional
@Service("eventMessagesService")
public class EventMessagesBusinessService
		extends
		AbstractBusinessService<EventMessages, java.lang.Integer, EventMessagesDao>
		implements EventMessagesService {

	private static final long serialVersionUID = 1L;

	@Autowired
	public void setEventMessagesDao(EventMessagesDao eventMessagesDao) {
		setDao(eventMessagesDao);
	}

}