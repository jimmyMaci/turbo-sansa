package flirt.and.date.hbm.daos;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import flirt.and.date.hbm.model.ProfileVisitors;
import flirt.and.date.hbm.service.api.ProfileVisitorsService;

@ContextConfiguration(locations = "classpath:test-applicationContext.xml")
public class ProfileVisitorsDaoTest extends AbstractTestNGSpringContextTests {

    @Autowired
	private ProfileVisitorsService profileVisitorsService;

	@Test
	public void getAllProfileVisitors() {
		initProfileVisitors();
		List<ProfileVisitors> list = profileVisitorsService.findAll();
		AssertJUnit.assertEquals(2, list.size());
	}
	
	protected void initProfileVisitors() {
		ProfileVisitors profileVisitors = new ProfileVisitors();
		// TODO init model class
		profileVisitorsService.merge(profileVisitors);

		profileVisitors = new ProfileVisitors();
		// TODO init model class
		profileVisitorsService.merge(profileVisitors);

	}

}
