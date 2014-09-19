package user.management.service;

import hbm.service.jpa.AbstractBusinessService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import user.management.daos.AttributesDao;
import user.management.model.Attributes;
import user.management.service.api.AttributesService;

@Transactional
@Service("attributesService")
public class AttributesBusinessService extends AbstractBusinessService<Attributes, Integer, AttributesDao> implements AttributesService {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	public void setAttributesDao(AttributesDao attributesDao) {
		setDao(attributesDao);
	}

}