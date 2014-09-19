package user.management.daos;

import hbm.dao.jpa.JpaEntityManagerDao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import user.management.model.Users;
import user.management.rowmapper.UsersRowMapper;

@Repository("usersDao")
public class UsersDao extends JpaEntityManagerDao<Users, Integer> {

	/**
	 * The serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	public List<Users> getUsersList() {
		List<Users> userList = new ArrayList<Users>();

		String sql = "select * from users";

		userList = getJdbcTemplate().query(sql, new UsersRowMapper());
		return userList;
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
