package events.system.service;

import java.util.List;

import javax.persistence.Query;

import hbm.service.jpa.AbstractBusinessService;
import net.sourceforge.jaulp.collections.ListUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import events.system.daos.RatingDescriptionsDao;
import events.system.model.EventRatings;
import events.system.model.RatingDescriptions;
import events.system.service.api.RatingDescriptionsService;

@Transactional
@Service("ratingDescriptionsService")
public class RatingDescriptionsBusinessService
		extends
		AbstractBusinessService<RatingDescriptions, java.lang.Integer, RatingDescriptionsDao>
		implements RatingDescriptionsService {

	private static final long serialVersionUID = 1L;

	@Autowired
	public void setRatingDescriptionsDao(
			RatingDescriptionsDao ratingDescriptionsDao) {
		setDao(ratingDescriptionsDao);
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public RatingDescriptions findRatingDescription(
			final EventRatings eventRatings) {
		final String hqlString = "select distinct rd from RatingDescriptions rd where rd.eventRatings=:eventRatings";
		final Query query = getQuery(hqlString);
		query.setParameter("eventRatings", eventRatings);
		List<RatingDescriptions> ratingDescriptions = query.getResultList();
		return ListUtils.getFirst(ratingDescriptions);
	}
}