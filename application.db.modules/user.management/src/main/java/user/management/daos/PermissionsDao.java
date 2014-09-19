package user.management.daos;

import hbm.dao.jpa.JpaEntityManagerDao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import user.management.model.Permissions;
import user.management.rowmapper.PermissionsRowMapper;

@Repository("permissionsDao")
public class PermissionsDao extends JpaEntityManagerDao<Permissions, Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public List<Permissions> getPermissionsList() {
		List<Permissions> permissionList = new ArrayList<Permissions>();

		String sql = "select * from Permissions";

		permissionList = getJdbcTemplate().query(sql, new PermissionsRowMapper());
		return permissionList;
	}

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public EntityManager getEntityManager() {
		return entityManager;
	}

	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;		
	}

}
