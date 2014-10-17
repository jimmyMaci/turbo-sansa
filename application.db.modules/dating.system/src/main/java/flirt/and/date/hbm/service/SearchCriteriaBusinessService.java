package flirt.and.date.hbm.service;

import flirt.and.date.hbm.daos.SearchCriteriaDao;
import flirt.and.date.hbm.model.SearchCriteria;
import flirt.and.date.hbm.service.api.SearchCriteriaService;
import hbm.service.jpa.AbstractBusinessService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Service("searchCriteriaService")
public class SearchCriteriaBusinessService extends AbstractBusinessService<SearchCriteria, Integer, SearchCriteriaDao> implements SearchCriteriaService {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	public void setSearchCriteriaDao(SearchCriteriaDao searchCriteriaDao) {
		setDao(searchCriteriaDao);
	}
	
}