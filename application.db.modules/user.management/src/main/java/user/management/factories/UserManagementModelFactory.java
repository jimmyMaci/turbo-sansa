package user.management.factories;

import java.io.Serializable;
import java.util.Date;
import java.util.Locale;

import net.sourceforge.jaulp.auth.models.BaseUsernameSignUpModel;
import net.sourceforge.jaulp.auth.models.UsernameSignUpModel;
import user.management.enums.Gender;
import user.management.sign.up.UserModel;
import address.book.model.Addresses;

public class UserManagementModelFactory implements Serializable {
	/** The Constant instance. */
	private static final UserManagementModelFactory instance = new UserManagementModelFactory();
	/**
	 * The serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Gets the single instance of UserManagementModelFactory.
	 * 
	 * @return single instance of UserManagementModelFactory
	 */
	public static UserManagementModelFactory getInstance() {
		return instance;
	}	
	private UserManagementModelFactory() {
	}

	public UserModel newUserModel(
			String birthname,
			Date dateOfBirth,
			String firstname,
			Gender gender,
			String ipAddress,
			String lastname,
			Locale locale,
			String mobile,
			String telefon,
			String fax,
			Addresses address) {
		UserModel userModel = new UserModel();
		userModel.setBirthname(birthname);
		userModel.setDateofbirth(dateOfBirth);
		userModel.setFirstname(firstname);
		userModel.setGender(gender);
		userModel.setIpAddress(ipAddress);
		userModel.setLastname(lastname);
		userModel.setLocale(locale);
		userModel.setMobile(mobile);
		userModel.setTelefon(telefon);
		userModel.setFax(fax);
		userModel.setAddress(address);
		return userModel;
	}
	
	public UsernameSignUpModel newUsernameSignupModel(
			String email, 
			String pw, 
			String repeatPw, 
			Boolean termOfUseAccepted,
			String username) {
		UsernameSignUpModel model = new BaseUsernameSignUpModel();
		model.setEmail(email);
		model.setPassword(pw);
		model.setRepeatPassword(repeatPw);
		model.setTermOfUseAccepted(termOfUseAccepted);
		model.setUsername(username);
		return model;
	}
}
