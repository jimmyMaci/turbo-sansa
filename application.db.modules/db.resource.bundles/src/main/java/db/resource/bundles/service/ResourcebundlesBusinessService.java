package db.resource.bundles.service;

import hbm.service.jpa.AbstractBusinessService;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;

import javax.persistence.Query;

import net.sourceforge.jaulp.collections.ListUtils;
import net.sourceforge.jaulp.locale.LocaleUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import db.resource.bundles.daos.ResourcebundlesDao;
import db.resource.bundles.factories.ResourceBundlesDomainObjectFactory;
import db.resource.bundles.model.Resourcebundles;
import db.resource.bundles.service.api.ResourcebundlesService;
import db.resource.bundles.service.util.HqlStringCreator;

@Transactional
@Service("resourcebundlesService")
public class ResourcebundlesBusinessService extends AbstractBusinessService<Resourcebundles, Integer, ResourcebundlesDao> implements ResourcebundlesService {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	public void setResourcebundlesDao(ResourcebundlesDao resourcebundlesDao) {
		setDao(resourcebundlesDao);
	}

	/**
     * {@inheritDoc}
     */
	public List<Resourcebundles> findResourceBundles(String baseName, Locale locale) {
		return find(baseName, LocaleUtils.getLocaleFilenameSuffix(locale), null, null);		
	}

	/**
     * {@inheritDoc}
     */
	public List<Resourcebundles> findResourceBundles(String baseName, Locale locale, String key) {
		return find(baseName, LocaleUtils.getLocaleFilenameSuffix(locale), key, null);		
	}

	/**
     * {@inheritDoc}
     */
	public Resourcebundles getKey(String baseName, Locale locale, String key) {
		return ListUtils.getFirst(findResourceBundles(baseName, locale, key));		
	}

	/**
     * {@inheritDoc}
     */	
	public void updateProperties(Properties properties, String baseName, Locale locale) {
		if(baseName == null || baseName.isEmpty()) {
			throw new IllegalArgumentException("Parameter baseName should not be null or empty.");
		}
		String localeName = LocaleUtils.getLocaleFilenameSuffix(locale);
		for (Map.Entry<Object,Object> element : properties.entrySet()) {
			String key = element.getKey().toString().trim();
			String value = element.getValue().toString().trim();
			Resourcebundles resourcebundle = getKey(baseName, locale, key);
			if(resourcebundle != null){
				resourcebundle.setValue(value);
			} else {
				resourcebundle = ResourceBundlesDomainObjectFactory
				.getInstance().newResourcebundles(baseName,
						localeName, key , value);
			}					
			merge(resourcebundle);
		}		
	}

	/**
     * {@inheritDoc}
     */	
	@SuppressWarnings("unchecked")
	public List<Resourcebundles> find(String baseName, String locale,String key, String value) {
		String hqlString = HqlStringCreator.forResourcebundles(baseName, locale, key, value);
		final Query query = getQuery(hqlString);
		if(baseName != null && !baseName.isEmpty()){
			query.setParameter("baseName", baseName);
		}
		if(locale != null && !locale.isEmpty()){
			query.setParameter("locale", locale);
		}
		if(key != null && !key.isEmpty()){
			query.setParameter("key", key);			
		}
		if(value != null && !value.isEmpty()){
			query.setParameter("value", value);			
		}
		final List<Resourcebundles> resourcebundles = query.getResultList();
		return resourcebundles;
	}

}