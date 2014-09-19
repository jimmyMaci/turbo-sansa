package user.management.service.api;

import hbm.service.jpa.BusinessService;
import user.management.model.ResetPasswords;
import user.management.model.Users;

public interface ResetPasswordsService extends BusinessService<ResetPasswords, Integer>{

	/**
	 * Find reset password.
	 *
	 * @param user the user
	 * @param generatedPassword the generated password(hashed) is the confirmationCode from the url query string
	 * @return the reset passwords
	 */
	ResetPasswords findResetPassword(Users user, String generatedPassword);

	/**
	 * Finds the reseted password from the given {@link Users} object.
	 *
	 * @param user the user
	 * @return the reset passwords
	 */
	ResetPasswords findResetPassword(Users user);
}