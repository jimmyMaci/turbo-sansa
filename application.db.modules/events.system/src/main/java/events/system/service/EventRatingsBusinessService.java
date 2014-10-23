package events.system.service;

import hbm.service.jpa.AbstractBusinessService;

import java.util.List;

import javax.persistence.Query;

import net.sourceforge.jaulp.collections.ListUtils;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rating.system.enums.RatingVisibility;
import user.management.model.Users;
import events.system.daos.EventRatingsDao;
import events.system.model.EventRatings;
import events.system.model.EventTemplate;
import events.system.model.RatingDescriptions;
import events.system.service.api.EventRatingsService;

@Transactional
@Service("eventRatingsService")
public class EventRatingsBusinessService
		extends
		AbstractBusinessService<EventRatings, java.lang.Integer, EventRatingsDao>
		implements EventRatingsService {

	private static final long serialVersionUID = 1L;

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public List<Users> findAllUsersForRatedEvent(final EventTemplate event) {
		final String hqlString = "select distinct er.rater from EventRatings er where er.event=:event";
		final Query query = getQuery(hqlString);
		query.setParameter("event", event);
		List<Users> foundUsers = query.getResultList();
		return foundUsers;
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public List<EventRatings> findEventRatings(final EventTemplate event) {
		final String hqlString = "select er from EventRatings er where er.event=:event";
		final Query query = getQuery(hqlString);
		query.setParameter("event", event);
		List<EventRatings> foundEventRatings = query.getResultList();
		return foundEventRatings;
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public List<EventRatings> findEventRatings(final Users subscriber) {
		final String hqlString = "select er from EventRatings er where er.rater=:rater";
		final Query query = getQuery(hqlString);
		query.setParameter("rater", subscriber);
		List<EventRatings> foundEventRatings = query.getResultList();
		return foundEventRatings;
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public List<EventRatings> findRatedEvents(final Users provider) {
		final String hqlString = "select er from EventRatings er where er.event.providerId=:providerId  and er.visibility=:visibility";
		final Query query = getQuery(hqlString);
		query.setParameter("providerId", provider.getId());
		query.setParameter("visibility", RatingVisibility.INVISIBLE);
		List<EventRatings> eventRatings = query.getResultList();
		return eventRatings;
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public RatingDescriptions findRatingDescription(
			final EventRatings eventRating) {
		final String hqlString = "select rd from RatingDescriptions rd where rd.eventRatings=:eventRating";
		final Query query = getQuery(hqlString);
		query.setParameter("eventRating", eventRating);
		List<RatingDescriptions> ratingDescriptions = query.getResultList();

		return ListUtils.getFirst(ratingDescriptions);
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public List<EventRatings> getEventRatingsForEvent(final EventTemplate event) {
		final String hqlString = "select distinct er from EventRatings er where er.event=:event";
		final Query query = getQuery(hqlString);
		query.setParameter("event", event);
		List<EventRatings> foundEventRatings = query.getResultList();
		return foundEventRatings;
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public List<EventRatings> getEventRatingsForEventFromSubscriber(
			final EventTemplate event, final Users subscriber) {
		final String hqlString = "select distinct er from EventRatings er where er.event=:event and er.rater=:subscriber";
		final Query query = getQuery(hqlString);
		query.setParameter("event", event);
		query.setParameter("subscriber", subscriber);
		List<EventRatings> foundEventRatings = query.getResultList();
		return foundEventRatings;
	}

}