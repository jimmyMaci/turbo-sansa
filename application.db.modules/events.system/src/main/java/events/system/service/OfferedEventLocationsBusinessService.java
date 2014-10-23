package events.system.service;

import java.util.List;

import javax.persistence.Query;

import hbm.service.jpa.AbstractBusinessService;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import user.management.model.Users;
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
	
	@SuppressWarnings("unchecked")
	public List<OfferedEventLocations> findOfferedEventLocationsFromUser(Users user){
		String hqlString = "select distinct oel from OfferedEventLocations oel where oel.userAddress.user=:user";
		final Query query = getQuery(hqlString);
		query.setParameter("user", user);
		final List<OfferedEventLocations> offeredEventLocations = query.getResultList();
		return offeredEventLocations;		
	}
	
	@SuppressWarnings("unchecked")	
	public  List<OfferedEventLocations> findOfferedEventLocationsFromZipcodeAndCity(String zipcode, String city) {
		StringBuilder sb = new StringBuilder();
		sb.append("select distinct oel from OfferedEventLocations oel");
		if(StringUtils.isNotEmpty(zipcode) || StringUtils.isNotEmpty(city)) {
			sb.append(" where");
		}
		if(StringUtils.isNotEmpty(zipcode)) {
			sb.append(" oel.userAddress.address.zipcode.zipcode=:zipcode");
		}
		if(StringUtils.isNotEmpty(zipcode) && StringUtils.isNotEmpty(city)) {
			sb.append(" or");
		}
		if(StringUtils.isNotEmpty(city)) {
			sb.append(" oel.userAddress.address.zipcode.city=:city");
		}
		final Query query = getQuery(sb.toString());
		if(StringUtils.isNotEmpty(zipcode)) {
			query.setParameter("zipcode", zipcode);
		}
		if(StringUtils.isNotEmpty(city)) {
			query.setParameter("city", city);
		}
		final List<OfferedEventLocations> offeredEventLocations = query.getResultList();
		return offeredEventLocations;
	}


}