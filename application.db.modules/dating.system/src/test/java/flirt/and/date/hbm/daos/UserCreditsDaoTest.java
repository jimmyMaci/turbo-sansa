package flirt.and.date.hbm.daos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import flirt.and.date.hbm.model.UserCredits;

@ContextConfiguration(locations = "classpath:test-applicationContext.xml")
public class UserCreditsDaoTest extends AbstractTestNGSpringContextTests {
	@Autowired
	private UserCreditsDao userCreditsDao;

	

	@Test
	public void testFindAll() {
		List<UserCredits> all = userCreditsDao.findAll();
		System.out.println(all);
	}
}
