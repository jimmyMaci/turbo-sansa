package events.system.service;

import hbm.service.jpa.AbstractBusinessService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import events.system.daos.RatingDescriptionsDao;
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

}