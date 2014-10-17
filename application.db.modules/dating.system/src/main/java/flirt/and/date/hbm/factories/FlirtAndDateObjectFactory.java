package flirt.and.date.hbm.factories;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import message.system.enums.MessageState;
import message.system.enums.MessageType;
import message.system.factories.MessageSystemFactory;
import message.system.model.MessageRecipients;
import message.system.model.Messages;
import user.management.enums.Contactmethod;
import user.management.enums.Gender;
import user.management.factories.UserManagementFactory;
import user.management.model.Contactmethods;
import resource.system.factories.ResourceSystemFactory;
import resource.system.model.Resources;
import user.management.model.Permissions;
import user.management.model.ResetPasswords;
import user.management.model.Roles;
import user.management.model.UserData;
import user.management.model.Users;
import address.book.factories.AddressBookFactory;
import address.book.model.Addresses;
import address.book.model.Countries;
import address.book.model.Federalstates;
import address.book.model.Zipcodes;
import flirt.and.date.hbm.enums.EducationState;
import flirt.and.date.hbm.enums.FigureType;
import flirt.and.date.hbm.enums.FriendshipRequestsState;
import flirt.and.date.hbm.enums.HaircolorType;
import flirt.and.date.hbm.enums.InterestsType;
import flirt.and.date.hbm.enums.RelationshipState;
import flirt.and.date.hbm.enums.SmokerState;
import flirt.and.date.hbm.enums.ZodiacSignType;
import flirt.and.date.hbm.model.FavoriteMembers;
import flirt.and.date.hbm.model.FriendshipRequests;
import flirt.and.date.hbm.model.ProfileNotice;
import flirt.and.date.hbm.model.ProfileVisitors;
import flirt.and.date.hbm.model.SearchCriteria;
import flirt.and.date.hbm.model.UserProfile;

/**
 * DAO factory implementation author: auto-generated
 */
public class FlirtAndDateObjectFactory implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** The Constant instance. */
	private static final FlirtAndDateObjectFactory instance = new FlirtAndDateObjectFactory();

	/**
	 * Gets the single instance of DomainObjectFactory.
	 * 
	 * @return single instance of DomainObjectFactory
	 */
	public static FlirtAndDateObjectFactory getInstance() {
		return instance;
	}

	/**
	 * Instantiates a new domain object factory.
	 */
	private FlirtAndDateObjectFactory() {
		super();
	}

	/**
	 * Data pool factory for Addresses
	 * 
	 * @param federalstate
	 *            A valid Federalstates object
	 * @param zipcode
	 *            A valid Zipcodes object
	 * @return Addresses A Addresses object
	 */
	public Addresses newAddresses(String addressComment,
			Federalstates federalstate, String geohash, Integer id,
			String latitude, String longitude, String street,
			String streetnumber, Zipcodes zipcode) {
		return AddressBookFactory.getInstance().newAddresses(addressComment,
				federalstate, geohash, id, latitude, longitude, street,
				streetnumber, zipcode);
	}

	/**
	 * Domain object factory for Contactmethods
	 * 
	 * @return ContactmethodsA Contactmethods object
	 */
	public Contactmethods newContactmethods(Contactmethod contactmethod,
			String contactvalue, Integer id) {
		return UserManagementFactory.getInstance().newContactmethods(
				contactmethod, contactvalue, id);
	}

	/**
	 * Domain object factory for Countries
	 * 
	 * @return CountriesA Countries object
	 */
	public Countries newCountries(Integer id, String iso3166A2name,
			String iso3166A3name, String iso3166Number, String name) {
		return AddressBookFactory.getInstance().newCountries(id,
				iso3166A2name, iso3166A3name, iso3166Number, name);
	}

	/**
	 * Data pool factory for Federalstates
	 * 
	 * @param country
	 *            A valid Countries object
	 * @return Federalstates A Federalstates object
	 */
	public Federalstates newFederalstates(Countries country, Integer id,
			String iso3166A2code, String name, String subdivisionCategory,
			String subdivisionName) {
		return AddressBookFactory.getInstance().newFederalstates(country,
				id, iso3166A2code, name, subdivisionCategory, subdivisionName);
	}

	/**
	 * Domain object factory for Images
	 * 
	 * @return ImagesA Images object
	 */
	public Resources newResources(String description, String filename,
			String filesize, String filetype, Integer id, Byte[] image, Date created, Boolean deletedFlag, String checksum) {
		return ResourceSystemFactory.getInstance().newResources(id, description,
				filename, filesize, filetype, image, created, deletedFlag, checksum);
	}

	/**
	 * Data pool factory for Messages
	 * 
	 * @param sender
	 *            A valid Users object
	 * @return Messages A Messages object
	 */
	public Messages newMessages(Boolean deletedFlag, Boolean failed2sentemail,
			String folder, Integer id, String messageContent,
			MessageType messagetype, Boolean readFlag, Users sender,
			Date sentDate, Boolean spamFlag, MessageState state, String subject, Messages parent) {
		return MessageSystemFactory.getInstance().newMessages(deletedFlag,
				failed2sentemail, folder, id, messageContent, messagetype,
				readFlag, sender, sentDate, spamFlag, state, subject, parent, Boolean.FALSE);
	}

	/**
	 * Data pool factory for MessageRecipients
	 * 
	 * @param message
	 *            A valid Messages object
	 * @param recipient
	 *            A valid Users object
	 * @return MessageRecipients A MessageRecipients object
	 */
	public MessageRecipients newMessageRecipients(Integer id, Messages message,
			Users recipient) {
		return MessageSystemFactory.getInstance().newMessageRecipients(id,
				message, recipient);
	}

	/**
	 * Domain object factory for Permissions
	 * 
	 * @return PermissionsA Permissions object
	 */
	public Permissions newPermissions(String description, Integer id,
			String permission, String shortcut) {
		return UserManagementFactory.getInstance().newPermissions(id,
				permission, description, shortcut);
	}

	/**
	 * Data pool factory for ResetPasswords
	 * 
	 * @param user
	 *            A valid Users object
	 * @return ResetPasswords A ResetPasswords object
	 */
	public ResetPasswords newResetPasswords(Integer id, Date expiryDate,
			String generatedPassword, Date starttime, Users user) {
		return UserManagementFactory.getInstance().newResetPasswords(id,
				expiryDate, generatedPassword, starttime, user);
	}

	/**
	 * Domain object factory for Roles
	 * 
	 * @return RolesA Roles object
	 */
	public Roles newRoles(String description, Integer id, String rolename,
			Set<Permissions> permissions) {
		return UserManagementFactory.getInstance().newRoles(id, rolename,
				description, permissions);
	}

	/**
	 * Domain object factory for Users
	 * 
	 * @return UsersA Users object
	 */
	public Users newUsers(Boolean active, String pw, String salt,
			String username, Boolean locked, UserData userData, Set<Roles> roles) {
		return UserManagementFactory.getInstance().newUsers(active, pw, salt,
				username, locked, userData, roles);
	}

	public UserProfile newUserProfile(Integer age,
			EducationState educationState, FigureType figure,
			HaircolorType haircolor, Integer height, InterestsType interests,
			String occupation, String profileText,
			RelationshipState relationshipState, SmokerState smokerstate,
			Users user, Resources userImage, Integer weight,
			ZodiacSignType zodiacSign, SearchCriteria searchCriteria) {
		UserProfile userProfile = new UserProfile();
		userProfile.setAge(age);
		userProfile.setEducationState(educationState);
		userProfile.setFigure(figure);
		userProfile.setHaircolor(haircolor);
		userProfile.setHeight(height);
		userProfile.setInterests(interests);
		userProfile.setOccupation(occupation);
		userProfile.setProfileText(profileText);
		userProfile.setRelationshipState(relationshipState);
		userProfile.setSmokerstate(smokerstate);
		userProfile.setUser(user);
		userProfile.setUserImage(userImage);
		userProfile.setWeight(weight);
		userProfile.setZodiacSign(zodiacSign);
		userProfile.setSearchCriteria(searchCriteria);
		return userProfile;
	}

	public SearchCriteria newSearchCriteria(Integer fromAge, Integer untilAge,
			Gender searchGender) {
		SearchCriteria searchCriteria = new SearchCriteria();
		searchCriteria.setFromAge(fromAge);
		searchCriteria.setUntilAge(untilAge);
		searchCriteria.setSearchGender(searchGender);
		return searchCriteria;
	}

	/**
	 * Domain object factory for Zipcodes
	 * 
	 * @return ZipcodesA Zipcodes object
	 */
	public Zipcodes newZipcodes(Integer id, Countries country, String city, String zipcode) {
		return AddressBookFactory.getInstance().newZipcodes( id, country, city,
				zipcode);
	}

	public ProfileNotice newProfileNotice(String notice, Users user,
			UserProfile userProfile) {
		ProfileNotice profileNotice = new ProfileNotice();
		profileNotice.setNotice(notice);
		profileNotice.setUser(user);
		profileNotice.setUserProfile(userProfile);
		return profileNotice;
	}
	
	public FavoriteMembers newFavoriteMembers(UserProfile favorite, Users owner){
		FavoriteMembers favoriteMembers = new FavoriteMembers();
		favoriteMembers.setFavorite(favorite);
		favoriteMembers.setOwner(owner);
		return favoriteMembers;
	}
	
	public FriendshipRequests newFriendshipRequests(Users requestor, Users requestedUser, FriendshipRequestsState state){
		FriendshipRequests friendshipRequests = new FriendshipRequests();
		friendshipRequests.setRequestor(requestor);
		friendshipRequests.setRequestedUser(requestedUser);
		friendshipRequests.setState(state);
		return friendshipRequests;
	}
	
	public ProfileVisitors newProfileVisitors(Date visitingDate, Users visitor, UserProfile visitedProfile, Integer count){
		ProfileVisitors profileVisitors = new ProfileVisitors();
		profileVisitors.setVisitor(visitor);
		profileVisitors.setVisitedProfile(visitedProfile);
		profileVisitors.setVisitingDate(visitingDate);
		profileVisitors.setCount(count);
		return profileVisitors;
	}
}
