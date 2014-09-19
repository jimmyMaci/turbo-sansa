package message.system.service;

import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import message.system.application.models.BaseMessageModel;
import message.system.application.models.send.MessageContentModel;
import message.system.application.models.send.SendInformationModel;
import message.system.application.models.send.api.IBaseMessageModel;
import message.system.application.models.send.api.IMessageContentModel;
import message.system.application.models.send.api.ISendInformationModel;
import message.system.enums.MessageState;
import message.system.enums.MessageType;
import message.system.model.Messages;
import message.system.service.api.MessagesService;
import net.sourceforge.jaulp.auth.models.UsernameSignUpModel;
import net.sourceforge.jaulp.auth.models.ValidationErrors;
import net.sourceforge.jaulp.date.CreateDateUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import user.management.enums.Gender;
import user.management.factories.UserManagementModelFactory;
import user.management.model.Roles;
import user.management.model.Users;
import user.management.service.api.RolesService;
import user.management.service.api.UserManagementService;
import user.management.sign.up.SignUpUserResult;
import user.management.sign.up.UserModel;
import address.book.service.api.AddressesService;

@ContextConfiguration(locations = "classpath:test-applicationContext.xml")
public class MessagesBusinessServiceTest extends AbstractTestNGSpringContextTests {
	@Autowired
	private UserManagementService userManagementService;
	@Autowired
	private RolesService rolesService;
	@Autowired
	private MessagesService messagesService;
	@Autowired
	private AddressesService addressesService;
	
	@Test
	public void testSaveMessageWithRecipients() {
		IMessageContentModel messageModel = new MessageContentModel();
		ISendInformationModel sendInformationModel = new SendInformationModel();		
		messageModel.setContent("Hello guys,\n\nhow are you?\n\nCheers\n\nAsterios");
		messageModel.setSubject("Hi guys");
		IBaseMessageModel model = new BaseMessageModel();
		model.setMessageContentModel(messageModel);
		model.setSendInformationModel(sendInformationModel);
		model.setMessageState(MessageState.UNREPLIED);
		model.setMessageType(MessageType.MAIL);

		Users sender = getUser("Michael", "Knight", "michael.knight@gmail.com", "knight");
		Set<Users> recipients = new HashSet<Users>();
		
		Users recipient = getUser("Anton", "Einstein", "anton.einstein@gmail.com", "einstein");
		recipients.add(recipient);
		model.getSendInformationModel().setRecipients(recipients);
		model.getSendInformationModel().setSender(sender);
		model.getSendInformationModel().setSentDate(new Date(System.currentTimeMillis()));
		Messages message = messagesService.saveMessageWithRecipients(model);
		AssertJUnit.assertTrue(messagesService.exists(message.getId()));
		Set<Users> r = messagesService.getRecipients(message);
		AssertJUnit.assertTrue(r != null && !r.isEmpty());
		AssertJUnit.assertTrue(r.iterator().next().equals(recipient));		
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
	
	public Users getUser(String firstname, String lastname, String email, String username){
	
		UserManagementModelFactory userManagementModelFactory = UserManagementModelFactory.getInstance();
		UserModel userModel = userManagementModelFactory.createUserModel(
				lastname,
				CreateDateUtils.createDate(1974, 8, 28),
				firstname,
				Gender.MALE,
				"127.0.0.1",
				lastname,
				Locale.GERMAN,
				"01721745676",
				"032325444444",
				addressesService.get(30224)); // Ludwigsburg
		
		UsernameSignUpModel usernameSignUpModel = userManagementModelFactory.createUsernameSignupModel(
				email,
				"xxx",
				"xxx",
				Boolean.TRUE,
				username);
		
		Set<Roles> roles = createRolesSet();
		SignUpUserResult result = userManagementService.signUpUser(usernameSignUpModel, roles, userModel);
		if(result.getUser() == null){
			ValidationErrors errors = result.getValidationErrors();
			if(errors.equals(ValidationErrors.EMAIL_EXISTS_ERROR)){
				return userManagementService.findUserWithEmailOrUsername(email);
			}
			if(errors.equals(ValidationErrors.USERNAME_EXISTS_ERROR)){
				return userManagementService.findUserWithEmailOrUsername(username);
			}
		}
		return result.getUser();
	}

}
