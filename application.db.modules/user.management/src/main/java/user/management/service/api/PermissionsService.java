package user.management.service.api;

import hbm.service.jpa.BusinessService;

import java.util.List;

import user.management.model.Permissions;

public interface PermissionsService extends
		BusinessService<Permissions, Integer> {

	Permissions createAndSavePermissions(String name, String description);

	Permissions createAndSavePermissions(String name, String description,
			String shortcut);
	
	Permissions findByShortcut(String shortcut);
	
	Permissions findByName(String name);

	List<Permissions> find(String description, String permissionName,
			String shortcut);
}