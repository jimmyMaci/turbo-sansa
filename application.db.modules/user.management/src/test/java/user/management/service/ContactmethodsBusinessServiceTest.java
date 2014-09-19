package user.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.testng.annotations.Test;

import user.management.enums.Contactmethod;
import user.management.model.Contactmethods;
import user.management.model.Users;
import user.management.service.api.ContactmethodsService;
import user.management.service.api.UsersService;

@ContextConfiguration(locations = "classpath:test-applicationContext.xml")
public class ContactmethodsBusinessServiceTest {


	/** The contactmethods business service. */
	@Autowired
	private ContactmethodsService contactmethodsService;
	@Autowired
	private UsersService usersService;
	@Test
	public void testFindContactmethod() {
		Users michaelProvider = usersService.findUserWithEmail("michael.knight@gmail.com");
		List<Contactmethods> cms = contactmethodsService.findContactmethod(Contactmethod.INTERNET, michaelProvider);
		for (Contactmethods contactmethods : cms) {
			System.out.println(contactmethods);
		}
	}

}
