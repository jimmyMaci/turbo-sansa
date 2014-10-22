package db.resource.bundles.service.locator;

import db.resource.bundles.service.api.ResourcebundlesService;

public interface ServiceLocator {

	/**
	 * Gets the resourcebundles service.
	 *
	 * @return the resourcebundles service
	 */
	ResourcebundlesService getResourcebundlesService();
	
	/**
	 * Sets the resourcebundles service.
	 *
	 * @param resourcebundlesService the resourcebundles service
	 */
	void setResourcebundlesService(ResourcebundlesService resourcebundlesService);

}
