package flirt.and.date.hbm.daos;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import flirt.and.date.hbm.model.FriendshipRequests;
import flirt.and.date.hbm.service.api.FriendshipRequestsService;

@ContextConfiguration(locations = "classpath:test-applicationContext.xml")
public class FriendshipRequestsDaoTest extends AbstractTestNGSpringContextTests {

    @Autowired
	private FriendshipRequestsService friendshipRequestsService;

	@Test
	public void getAllFriendshipRequests() {
		initFriendshipRequests();
		List<FriendshipRequests> list = friendshipRequestsService.findAll();
		AssertJUnit.assertEquals(2, list.size());
	}
	
	protected void initFriendshipRequests() {
		FriendshipRequests friendshipRequests = new FriendshipRequests();
		// TODO init model class
		friendshipRequestsService.merge(friendshipRequests);

		friendshipRequests = new FriendshipRequests();
		// TODO init model class
		friendshipRequestsService.merge(friendshipRequests);

	}

}
