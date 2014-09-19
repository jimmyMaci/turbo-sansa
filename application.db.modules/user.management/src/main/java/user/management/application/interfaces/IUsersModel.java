package user.management.application.interfaces;

import java.io.Serializable;

import user.management.model.Users;

/**
 * The Interface IUsersModel have Methods for get the Users object.
 */
public interface IUsersModel extends Serializable {


	/**
	 * Gets the Users object.
	 * 
	 * @return the Users object.
	 */
	Users getUser();
}
