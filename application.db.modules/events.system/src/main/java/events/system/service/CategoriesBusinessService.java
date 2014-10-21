package events.system.service;

import hbm.service.jpa.AbstractBusinessService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import events.system.daos.CategoriesDao;
import events.system.model.Categories;
import events.system.service.api.CategoriesService;

@Transactional
@Service("categoriesService")
public class CategoriesBusinessService extends
		AbstractBusinessService<Categories, java.lang.Integer, CategoriesDao>
		implements CategoriesService {

	private static final long serialVersionUID = 1L;

	@Autowired
	public void setCategoriesDao(CategoriesDao categoriesDao) {
		setDao(categoriesDao);
	}

}