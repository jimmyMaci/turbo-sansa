package events.system.service;


import hbm.service.jpa.AbstractBusinessService;

import java.util.List;

import javax.persistence.Query;

import message.system.enums.MessageState;
import message.system.model.Messages;
import net.sourceforge.jaulp.collections.ListUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import user.management.model.Users;
import events.system.daos.EventMessagesDao;
import events.system.model.EventLocations;
import events.system.model.EventMessages;
import events.system.service.api.EventMessagesService;
import events.system.service.util.HqlStringCreator;

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

	public EventMessages findEventMessagesFromMessage(final Messages message) {
		return ListUtils.getFirst(find(message, null));
	}

	public EventMessages findEventMessagesFromEventLocation(
			final EventLocations eventLocation) {
		return ListUtils.getFirst(find(null, eventLocation));
	}

	/**
	 * {@inheritDoc}.
	 */
	@SuppressWarnings("unchecked")
	public List<EventMessages> find(Messages message, EventLocations eventLocation) {
		String hqlString = HqlStringCreator.forEventMessages(message, eventLocation, EventMessages.class);				
		final Query query = getQuery(hqlString);
		if(message != null){
			query.setParameter("message", message);
		}
		if(eventLocation != null){
			query.setParameter("eventLocation", eventLocation);
		}
		final List<EventMessages> eventMessages = query.getResultList();
		return eventMessages;		
	}

	/**
	 * {@inheritDoc}.
	 */
	@SuppressWarnings("unchecked")
	public List<EventMessages> findMessages(final Users user, final MessageState state) {
		final String hqlString = "select distinct em "
				+ "from EventMessages as em join em.eventLocation as sem, "
				+ "Userevents as usev join usev.event as usem "
				+ "where sem.event.id=usem.id " + "and usev.user=:user "
				+ "and em.message.state=:state "
				+ "and em.message.deletedFlag=:deletedFlag";
		final Query query = getQuery(hqlString);
		query.setParameter("user", user);
		query.setParameter("state", state);
		query.setParameter("deletedFlag", Boolean.FALSE);
		final List<EventMessages> eventMessages = query.getResultList();
		return eventMessages;
	}

	/**
	 * {@inheritDoc}.
	 */
	@SuppressWarnings("unchecked")
	public List<EventMessages> findMessages(final Users provider) {
		final String hqlString = "select distinct em "
				+ "from EventMessages as em join em.eventLocation as sem, "
				+ "Userevents as usev join usev.event as usem  "
				+ "where sem.event.id= usem.id " + "and usev.user=:provider";
		final Query query = getQuery(hqlString);
		query.setParameter("provider", provider);
		final List<EventMessages> eventMessages = query.getResultList();
		return eventMessages;
	}

}