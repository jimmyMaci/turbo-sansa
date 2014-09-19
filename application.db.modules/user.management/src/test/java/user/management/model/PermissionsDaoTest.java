package user.management.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.transaction.annotation.Transactional;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import user.management.daos.PermissionsDao;
import user.management.factories.UserManagementFactory;
import user.management.rowmapper.PermissionsRowMapper;
import user.management.service.api.PermissionsService;

@ContextConfiguration(locations = "classpath:test-applicationContext.xml")
public class PermissionsDaoTest extends AbstractTestNGSpringContextTests {

	@Autowired
	private PermissionsDao permissionsDao;
	@Autowired
	private PermissionsService permissionsService;

	@Test(enabled = false)
	public void getAllPermissions() {
		List<Permissions> list = permissionsService.findAll();
		AssertJUnit.assertEquals(2, list.size());

	}

	@Test(enabled = true)
	public void getPermissionList() {
		List<Permissions> all = permissionsDao.getPermissionsList();
		AssertJUnit.assertEquals(2, all.size());
	}

	@Test
	@Transactional
	public void updatePermission() {
		List<Permissions> all = permissionsDao.getJdbcTemplate().query(
				"select * from Permissions p where p.shortcut=?",
				new Object[] { "r" }, new PermissionsRowMapper());
		if(!all.isEmpty()){
			Permissions p=all.get(0);
			p.setDescription("xy");
			permissionsDao.update(p);
			p = permissionsDao.get(p.getId());
			AssertJUnit.assertEquals("xy", p.getDescription());
		}
		
	}

	@BeforeMethod
	private void initPermissions() {
		List<Permissions> list = permissionsDao.getJdbcTemplate().query(
				"select * from Permissions p where p.shortcut=?",
				new Object[] { "r" }, new PermissionsRowMapper());
		if(list.isEmpty()) {
			Permissions permission = UserManagementFactory.getInstance()
					.newPermissions("read", "The permission to read", "r");
			permission = permissionsService.merge(permission);			
		}
		list = permissionsDao.getJdbcTemplate().query(
				"select * from Permissions p where p.shortcut=?",
				new Object[] { "w" }, new PermissionsRowMapper());
		if(list.isEmpty()) {
			Permissions permission = UserManagementFactory.getInstance().newPermissions(
					"write", "The permission to write", "w");
			permission = permissionsService.merge(permission);			
		}
		
	}

}
