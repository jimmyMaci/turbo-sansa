package events.system.service;

import java.util.List;

import javax.persistence.Query;

import hbm.service.jpa.AbstractBusinessService;
import net.sourceforge.jaulp.collections.ListUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import events.system.daos.CategoriesDao;
import events.system.model.Categories;
import events.system.service.api.CategoriesService;
import events.system.service.util.HqlStringCreator;

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

	@Override
	public boolean existsCategory(String name) {
		return findCategory(name) != null;
	}

	@Override
	public Categories findCategory(String name) {
		return ListUtils.getFirst(find(name));
	}
	
	@SuppressWarnings("unchecked")
	public List<Categories> find(String name) {
		String hqlString = HqlStringCreator.forCategories(name, Categories.class);
		final Query query = getQuery(hqlString);
		if(name != null){
			query.setParameter("name", name);
		}
		final List<Categories> categories = query.getResultList();
		return categories;
	}

}