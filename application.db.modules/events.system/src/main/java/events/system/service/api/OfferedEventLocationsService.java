package events.system.service.api;

import hbm.service.jpa.BusinessService;

import java.util.List;

import user.management.model.Users;
import events.system.model.OfferedEventLocations;

public interface OfferedEventLocationsService extends
		BusinessService<OfferedEventLocations, java.lang.Integer> {

	
	List<OfferedEventLocations> findOfferedEventLocationsFromUser(Users user);
	
	List<OfferedEventLocations> findOfferedEventLocationsFromZipcodeAndCity(String zipcode, String city);
}