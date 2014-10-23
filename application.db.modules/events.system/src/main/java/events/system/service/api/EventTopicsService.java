package events.system.service.api;

import hbm.service.jpa.BusinessService;

import java.util.List;

import events.system.model.EventTemplate;
import events.system.model.EventTopics;
import events.system.model.Topics;

public interface EventTopicsService extends
		BusinessService<EventTopics, java.lang.Integer> {	

	/**
	 * Contains.
	 * 
	 * @param topic
	 *            the topic
	 * @param event
	 *            the event
	 * @return true, if successful
	 */
	boolean contains(final Topics topic, final EventTemplate event);

	/**
	 * Find event topic.
	 * 
	 * @param topic
	 *            the topic
	 * @param event
	 *            the event
	 * @return the event topics
	 */
	EventTopics findEventTopic(final Topics topic, final EventTemplate event);

	/**
	 * Find event topics.
	 * 
	 * @param event
	 *            the event
	 * @return the list
	 */
	List<EventTopics> findEventTopics(final EventTemplate event);
}