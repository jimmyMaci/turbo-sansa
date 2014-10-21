package events.system.daos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import events.system.model.ProfileFederalstates;

@ContextConfiguration(locations = "classpath:test-applicationContext.xml")
public class ProfileFederalstatesDaoTest extends AbstractTestNGSpringContextTests {

    @Autowired
	private ProfileFederalstatesDao profileFederalstatesDao;

	@Test
	public void testFindAll() {
		List<ProfileFederalstates> list = profileFederalstatesDao.findAll();
	}

}
