package flirt.and.date.hbm.daos;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import flirt.and.date.hbm.model.UserProfile;
import flirt.and.date.hbm.service.api.UserProfileService;

@ContextConfiguration(locations = "classpath:test-applicationContext.xml")
public class UserProfileDaoTest extends AbstractTestNGSpringContextTests {

    @Autowired
	private UserProfileService userProfileService;

	@Test
	public void getAllUserProfile() {
		initUserProfile() ;
		List<UserProfile> list = userProfileService.findAll();
		AssertJUnit.assertEquals(2, list.size());
	}
	
	protected void initUserProfile() {
		UserProfile userProfile = new UserProfile();
		// TODO init model class
		userProfileService.merge(userProfile);

		userProfile = new UserProfile();
		// TODO init model class
		userProfileService.merge(userProfile);

	}

}
