package resource.system.service.api;

import hbm.service.jpa.BusinessService;

import java.util.List;

import resource.system.model.Resources;

public interface ResourcesService extends BusinessService<Resources, Integer> {
	Resources findByName(String filename);

	List<Resources> find(String description, String filename, String filesize,
			String contentType);

	Resources getManPlaceholder();

	Resources getWomanPlaceholder();
	
	Resources getDefaultPlaceholder();
}