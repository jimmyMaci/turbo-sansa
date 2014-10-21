package events.system.service;

import hbm.service.jpa.AbstractBusinessService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import events.system.daos.OfferedEventLocationsDao;
import events.system.model.OfferedEventLocations;
import events.system.service.api.OfferedEventLocationsService;

@Transactional
@Service("offeredEventLocationsService")
public class OfferedEventLocationsBusinessService
		extends
		AbstractBusinessService<OfferedEventLocations, java.lang.Integer, OfferedEventLocationsDao>
		implements OfferedEventLocationsService {

	private static final long serialVersionUID = 1L;

	@Autowired
	public void setOfferedEventLocationsDao(
			OfferedEventLocationsDao offeredEventLocationsDao) {
		setDao(offeredEventLocationsDao);
	}

}