package user.management.service;

import java.util.List;

import javax.persistence.Query;

import hbm.service.jpa.AbstractBusinessService;
import net.sourceforge.jaulp.collections.ListUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import user.management.daos.PermissionsDao;
import user.management.factories.UserManagementFactory;
import user.management.model.Permissions;
import user.management.service.api.PermissionsService;
import user.management.service.utils.HqlStringCreator;

@Transactional
@Service("permissionsService")
public class PermissionsBusinessService extends
		AbstractBusinessService<Permissions, Integer, PermissionsDao> implements
		PermissionsService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	public void setPermissionsDao(PermissionsDao permissionsDao) {
		setDao(permissionsDao);
	}

	@Override
	public Permissions createAndSavePermissions(String name, String description) {
		return createAndSavePermissions(name, description, null);
	}

	@Override
	public Permissions createAndSavePermissions(String name,
			String description, String shortcut) {
		Permissions permissions = UserManagementFactory.getInstance()
				.newPermissions(name, description, shortcut);
		permissions = merge(permissions);
		return permissions;
	}
	
	public Permissions findByShortcut(String shortcut) {
		return ListUtils.getFirst(find(null, null, shortcut));
	}
	
	public Permissions findByName(String name) {
		return ListUtils.getFirst(find(null, name, null));
	}
	
	@SuppressWarnings("unchecked")
	public List<Permissions> find(String description, String permissionName, String shortcut) {
		String hqlString = HqlStringCreator.forPermissions(description, permissionName, shortcut);
		final Query query = getQuery(hqlString);
		if(description != null){
			query.setParameter("description", description);
		}
		if(permissionName != null){
			query.setParameter("permissionName", permissionName);
		}
		if(shortcut != null){
			query.setParameter("shortcut", shortcut);			
		}
		final List<Permissions> permissions = query.getResultList();
		return permissions;
	}

}