package user.management.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import user.management.daos.UsersDao;

@ContextConfiguration(locations = "classpath:test-applicationContext.xml")
public class UsersDaoTest extends AbstractTestNGSpringContextTests {
	@Autowired
	private UsersDao usersDao;

	

	@Test
	public void testFindAll() {
		List<Users> all = usersDao.getUsersList();
		System.out.println(all);
	}
}
