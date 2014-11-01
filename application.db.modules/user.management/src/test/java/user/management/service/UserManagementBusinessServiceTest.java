package user.management.service;


import java.io.File;
import java.sql.BatchUpdateException;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import net.sourceforge.jaulp.auth.models.UsernameSignUpModel;
import net.sourceforge.jaulp.date.CreateDateUtils;
import net.sourceforge.jaulp.email.messages.Mimetypes;
import net.sourceforge.jaulp.file.search.PathFinder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import resource.system.application.model.ResourcesModel;
import resource.system.application.util.ModelConverter;
import resource.system.model.Resources;
import user.management.application.models.UserModelConverter;
import user.management.enums.Contactmethod;
import user.management.enums.Gender;
import user.management.factories.UserManagementFactory;
import user.management.factories.UserManagementModelFactory;
import user.management.model.Contactmethods;
import user.management.model.Roles;
import user.management.model.Users;
import user.management.service.api.ContactmethodsService;
import user.management.service.api.RolesService;
import user.management.service.api.UserManagementService;
import user.management.service.api.UsersService;
import user.management.sign.up.SignUpUserResult;
import user.management.sign.up.UserModel;
import address.book.service.api.AddressesService;

@ContextConfiguration(locations = "classpath:test-applicationContext.xml")
public class UserManagementBusinessServiceTest extends AbstractTestNGSpringContextTests {

	/** The Addresses business service. */
	@Autowired
	private AddressesService addressesService;
	@Autowired
	private UserManagementService userManagementService;
	@Autowired
	private RolesService rolesService;
	@Autowired
	private UsersService usersService;
	/** The contactmethods business service. */
	@Autowired
	private ContactmethodsService contactmethodsService;

	@Test(enabled=true)
	public void testSignUpUser() {
		SignUpUserResult result;
		UserManagementModelFactory userManagementModelFactory = UserManagementModelFactory.getInstance();
		UserModel userModel = userManagementModelFactory.newUserModel(
				"Knight",
				CreateDateUtils.createDate(1974, 8, 28),
				"Michael",
				Gender.MALE,
				"127.0.0.1",
				"Knight",
				Locale.GERMAN,
				"01721745676",
				"032325444444",
				"032325444445",
				addressesService.get(30224)); // Ludwigsburg
		
		UsernameSignUpModel model = userManagementModelFactory.newUsernameSignupModel(
				"michael.knight@gmail.com",
				"xxx",
				"xxx",
				Boolean.TRUE,
				"michael.knight");
		
		Set<Roles> roles = createRolesSet();
		
		result = userManagementService.signUpUser(model, roles, userModel);
		
		userModel = userManagementModelFactory.newUserModel(
				"Frankenstein",
				CreateDateUtils.createDate(1974, 8, 28),
				"Adolf",
				Gender.MALE,
				"127.0.0.1",
				"Frankenstein",
				Locale.GERMAN,
				"01741762636",
				"042327445445",
				"042327445446",
				addressesService.get(14178));//Stuttgart
		
		model = userManagementModelFactory.newUsernameSignupModel(
				"adolf.frankenstein@gmail.com",
				"xxx",
				"xxx",
				Boolean.TRUE,
				"frankenstein");
		
		result = userManagementService.signUpUser(model, roles, userModel);
		
		userModel = userManagementModelFactory.newUserModel(
				"Dean",
				CreateDateUtils.createDate(1974, 8, 28),
				"James",
				Gender.MALE,
				"127.0.0.1",
				"Dean",
				Locale.GERMAN,
				"01541662535",
				"072327545348",
				"072327545349",
				addressesService.get(35448));// Worms
		
		model = userManagementModelFactory.newUsernameSignupModel(
				"james.dean@gmail.com",
				"xxx",
				"xxx",
				Boolean.TRUE,
				"james.dean");
		
		result = userManagementService.signUpUser(model, roles, userModel);
		System.out.println(result);
		
		
	}

	public Set<Roles> createRolesSet() {
		List<Roles> r = rolesService.findAll();
		Set<Roles> roles = new HashSet<Roles>();
		if(r != null && !r.isEmpty()) {
			roles.add(r.get(0));
		} else {
			Roles role = rolesService.createAndSaveRole("ADMIN", "The admin role");
			roles.add(role);
		}
		return roles;
	}
	
	@Test(enabled=false)
	public void testFindUserWithEmailOrUsername(){
		String emailOrUsername = "michael.knight";
		Users user = userManagementService
				.findUserWithEmailOrUsername(emailOrUsername);
		
		AssertJUnit.assertNotNull(user);
				
		emailOrUsername = "michael.knight@gmail.com";
		user = userManagementService
				.findUserWithEmailOrUsername(emailOrUsername);
		AssertJUnit.assertNotNull(user);
	}
	
	@Test(enabled=false)
	public void testFindEmailContactFromUser() {
		String emailOrUsername = "michael.knight";
	Users user = userManagementService
			.findUserWithEmailOrUsername(emailOrUsername);
	AssertJUnit.assertNotNull(user);
	Contactmethods cm = userManagementService.findEmailContactFromUser(user);
	AssertJUnit.assertNotNull(cm.getContactmethod());
	}


	@Test(enabled=false)
	public void testSaveUserImage() {
		Users michaelProvider = usersService.findUserWithEmail("michael.knight@gmail.com");
		File testResoureDir = PathFinder.getSrcTestResourcesDir();
		File imgDir = new File(testResoureDir, "images");
		File img = new File(imgDir, "frankenstein.jpeg");
		String mimeType = Mimetypes.getMimeType(img);
		// 
		
		ResourcesModel fileModel = UserModelConverter.toResourceModel(img, mimeType, "A photo from user "+michaelProvider.getUsername());
		for (int i = 0; i < 100; i++) {
			userManagementService.persistResource(fileModel, michaelProvider.getId());
			System.out.println(i);
		}	
	}
	@Test(enabled=false)
	public void testRemoveUserResource() {
		Users michaelProvider = usersService.findUserWithEmail("michael.knight@gmail.com");
		// 
		Set<Resources> resources = michaelProvider.getUserData().getResources();
		System.out.println("resources size:"+resources.size());
		for (Resources resource : resources) {
			userManagementService.deleteResource(ModelConverter.toResourcesModel(resource), michaelProvider.getUserData().getId());			
		}	
	}
	@Test(enabled=false)
	public void testfindContactmethods() throws BatchUpdateException {
		Users michaelProvider = usersService.findUserWithEmail("james.dean@gmail.com");
		Contactmethods contactmethod = UserManagementFactory.getInstance().newContactmethods(Contactmethod.INTERNET, "http://www.jamesdean.gr");
		contactmethod = userManagementService.saveUserWithContactmethod(michaelProvider, contactmethod);
		usersService.refresh(michaelProvider);
		List<Contactmethods> cm = userManagementService.findAllInternetContactmethodsFromUser(michaelProvider);
		AssertJUnit.assertTrue(cm.contains(contactmethod));
	}
	
	
	@Test(enabled=false)
	public void testFindContactmethod() {
		Users michaelProvider = usersService.findUserWithEmail("james.dean@gmail.com");
		List<Contactmethods> cms = contactmethodsService.findContactmethod(Contactmethod.INTERNET, michaelProvider);
		for (Contactmethods contactmethods : cms) {
			System.out.println(contactmethods);
		}
	}
}
