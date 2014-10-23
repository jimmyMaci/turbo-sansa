package events.system.service;

import java.util.List;

import javax.persistence.Query;

import hbm.service.jpa.AbstractBusinessService;
import net.sourceforge.jaulp.collections.ListUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import events.system.daos.EventTopicsDao;
import events.system.model.EventTemplate;
import events.system.model.EventTopics;
import events.system.model.Topics;
import events.system.service.api.EventTopicsService;

@Transactional
@Service("eventTopicsService")
public class EventTopicsBusinessService extends
		AbstractBusinessService<EventTopics, java.lang.Integer, EventTopicsDao>
		implements EventTopicsService {

	private static final long serialVersionUID = 1L;

	@Autowired
	public void setEventTopicsDao(EventTopicsDao eventTopicsDao) {
		setDao(eventTopicsDao);
	}


	/**
	 * {@inheritDoc}
	 */
	public boolean contains(final Topics topic, final EventTemplate event) {
		return findEventTopic(topic, event) != null;
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public EventTopics findEventTopic(final Topics topic, final EventTemplate event) {
		final String hqlString = "select et from EventTopics et where et.event=:event and et.topic=:topic";
		final Query query = getQuery(hqlString);
		query.setParameter("event", event);
		query.setParameter("topic", topic);
		List<EventTopics> eventTopics = query.getResultList();
		return ListUtils.getFirst(eventTopics);
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public List<EventTopics> findEventTopics(final EventTemplate event) {
		final String hqlString = "select et from EventTopics et where et.event=:event";
		final Query query = getQuery(hqlString);
		query.setParameter("event", event);
		List<EventTopics> eventTopics = query.getResultList();
		return eventTopics;
	}


}