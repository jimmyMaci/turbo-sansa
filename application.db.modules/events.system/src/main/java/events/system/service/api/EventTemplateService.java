package events.system.service.api;

import hbm.service.jpa.BusinessService;

import java.util.List;

import user.management.model.Users;
import events.system.model.Categories;
import events.system.model.EventTemplate;

public interface EventTemplateService extends
		BusinessService<EventTemplate, java.lang.Integer> {

	/**
	 * Delete event and all references.
	 *
	 * @param event
	 *            the event
	 */
	public EventTemplate deleteEventAndAllReferences(final EventTemplate event);

	/**
	 * Find seminar.
	 *
	 * @param provider
	 *            the provider
	 * @param id
	 *            the id
	 * @return the seminars
	 */
	EventTemplate findEvent(final Users provider, final Integer id);

	/**
	 * Find seminars.
	 *
	 * @param eventname
	 *            the eventname
	 * @param category
	 *            the category
	 * @param condition
	 *            the condition
	 * @return the list
	 */
	List<EventTemplate> findEvents(final String eventname,
			final Categories category, final boolean condition);

	/**
	 * Find seminars.
	 *
	 * @param provider
	 *            the provider
	 * @return the list
	 */
	List<EventTemplate> findEvents(final Users provider);
}