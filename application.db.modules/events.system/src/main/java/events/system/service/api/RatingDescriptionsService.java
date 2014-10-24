package events.system.service.api;

import hbm.service.jpa.BusinessService;
import events.system.model.EventRatings;
import events.system.model.RatingDescriptions;

public interface RatingDescriptionsService extends
		BusinessService<RatingDescriptions, java.lang.Integer> {
	/**
	 * Find rating description.
	 * 
	 * @param eventRatings
	 *            the event ratings
	 * @return the rating descriptions
	 */
	RatingDescriptions findRatingDescription(EventRatings eventRatings);
}