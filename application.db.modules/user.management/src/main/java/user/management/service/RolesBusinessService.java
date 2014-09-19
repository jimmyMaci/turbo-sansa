package user.management.service;

import hbm.service.jpa.AbstractBusinessService;

import java.util.List;
import java.util.Set;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import user.management.daos.RolesDao;
import user.management.factories.UserManagementFactory;
import user.management.model.Permissions;
import user.management.model.Roles;
import user.management.service.api.RolesService;

@Transactional
@Service("rolesService")
public class RolesBusinessService extends
		AbstractBusinessService<Roles, Integer, RolesDao> implements
		RolesService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	public void setRolesDao(RolesDao rolesDao) {
		setDao(rolesDao);
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Permissions> findAllPermissions(final Roles role) {
		final String hqlString = "select rp.permission from RolePermissions rp where rp.role=:role";
		final Query query = getQuery(hqlString);
		query.setParameter("role", role);
		final List<Permissions> permissions = query.getResultList();
		return permissions;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Roles createAndSaveRole(String rolename, String description) {
		return createAndSaveRole(rolename, description, null);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Roles createAndSaveRole(String rolename, String description,
			Set<Permissions> permissions) {
		Roles role = findRole(rolename);
		if (role == null) {
			role = UserManagementFactory.getInstance().newRoles(rolename,
					description, permissions);
			role = merge(role);
		}
		return role;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Roles findRole(final String rolename) {
		final String hqlString = "select r from Roles r where r.rolename=:rolename";
		final Query query = getQuery(hqlString);
		query.setParameter("rolename", rolename);
		final List<Roles> roles = query.getResultList();
		if (roles != null && !roles.isEmpty()) {
			return roles.get(0);
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean exists(final String rolename) {
		return findRole(rolename) != null;
	}

}