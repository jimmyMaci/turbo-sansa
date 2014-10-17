package flirt.and.date.hbm.factories;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import message.system.enums.MessageState;
import message.system.enums.MessageType;
import message.system.model.MessageRecipients;
import message.system.model.Messages;
import user.management.enums.Contactmethod;
import user.management.enums.Gender;
import user.management.model.Contactmethods;
import resource.system.model.Resources;
import user.management.model.Permissions;
import user.management.model.ResetPasswords;
import user.management.model.Roles;
import user.management.model.UserData;
import user.management.model.Users;
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
 * A factory for creating DomainObject objects.
 */
public class DomainObjectFactory implements Serializable {

	/** The Constant instance. */
	private static final DomainObjectFactory instance = new DomainObjectFactory();

	/**
	 * The serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Gets the single instance of DomainObjectFactory.
	 * 
	 * @return single instance of DomainObjectFactory
	 */
	public static DomainObjectFactory getInstance() {
		return instance;
	}

	/** The seminars24 domain object factory. */
	private FlirtAndDateObjectFactory flirtAndDateObjectFactory = FlirtAndDateObjectFactory
			.getInstance();

	/**
	 * Instantiates a new domain object factory.
	 */
	private DomainObjectFactory() {
		super();
	}

	/**
	 * Gets the addresses.
	 *
	 * @param addressComment the address comment
	 * @param federalstate the federalstate
	 * @param geohash the geohash
	 * @param latitude the latitude
	 * @param longitude the longitude
	 * @param street the street
	 * @param streetnumber the streetnumber
	 * @param zipcode the zipcode
	 * @return the addresses
	 */
	public Addresses newAddresses(final String addressComment,
			final Federalstates federalstate, final String geohash,
			final java.math.BigDecimal latitude,
			final java.math.BigDecimal longitude, final String street,
			final String streetnumber, final Zipcodes zipcode) {
		String lat = (latitude != null) ? latitude.toString() : "";
		String lng = (longitude != null) ? longitude.toString() : "";
		return flirtAndDateObjectFactory.newAddresses(addressComment,
				federalstate, geohash, null, lat, lng, street, streetnumber, zipcode);
	}

	/**
	 * Gets the contacts.
	 * 
	 * @param contactmethod
	 *            the contactmethod
	 * @param contactvalue
	 *            the contactvalue
	 * @return the contacts
	 */
	public Contactmethods newContactmethods(final Contactmethod contactmethod,
			final String contactvalue) {
		return flirtAndDateObjectFactory.newContactmethods(contactmethod,
				contactvalue, null);
	}

	/**
	 * Gets the countries.
	 * 
	 * @param iso3166A2name
	 *            the iso3166 a2name
	 * @param iso3166A3name
	 *            the iso3166 a3name
	 * @param iso3166Number
	 *            the iso3166 number
	 * @param name
	 *            the name
	 * @return the countries
	 */
	public Countries newCountries(final String iso3166A2name,
			final String iso3166A3name, final String iso3166Number,
			final String name) {
		return flirtAndDateObjectFactory.newCountries(null, iso3166A2name, iso3166A3name,
				iso3166Number, name);
	}

	/**
	 * Gets the federalstates.
	 * 
	 * @param country
	 *            the country
	 * @param iso3166A2code
	 *            the iso3166 a2code
	 * @param name
	 *            the name
	 * @param subdivisionCategory
	 *            the subdivision category
	 * @param subdivisionName
	 *            the subdivision name
	 * @return the federalstates
	 */
	public Federalstates newFederalstates(final Countries country,
			final String iso3166A2code, final String name,
			final String subdivisionCategory, final String subdivisionName) {
		return flirtAndDateObjectFactory.newFederalstates(country,
				null, iso3166A2code,
				name, subdivisionCategory, subdivisionName);
	}

	/**
	 * Gets the images.
	 * 
	 * @param description
	 *            the description
	 * @param filename
	 *            the filename
	 * @param filesize
	 *            the filesize
	 * @param filetype
	 *            the filetype
	 * @param image
	 *            the image
	 * @return the images
	 */
	public Resources newResources(final String description, final String filename,
			final String filesize, final String filetype, final Byte[] image, Date created, Boolean deletedFlag, String checksum) {
		return flirtAndDateObjectFactory.newResources(description, filename,
				filesize, filetype, null, image, created, deletedFlag, checksum);
	}

	/**
	 * Gets the message recipients.
	 * 
	 * @param message
	 *            the message
	 * @param recipient
	 *            the recipient
	 * @return the message recipients
	 */
	public MessageRecipients newMessageRecipients(final Messages message,
			final Users recipient) {
		return flirtAndDateObjectFactory.newMessageRecipients(
				null, message,
				recipient);
	}

	/**
	 * Gets the messages.
	 *
	 * @param deletedFlag the deleted flag
	 * @param failed2sentemail the failed2sentemail
	 * @param folder the folder
	 * @param messageContent the message content
	 * @param messagetype the messagetype
	 * @param readFlag the read flag
	 * @param sender the sender
	 * @param sentDate the sent date
	 * @param spamFlag the spam flag
	 * @param state the state
	 * @param subject the subject
	 * @return the messages
	 */
	public Messages newMessages(final Boolean deletedFlag,
			final Boolean failed2sentemail, final String folder,
			final String messageContent, final MessageType messagetype,
			final Boolean readFlag, final Users sender, final Date sentDate,
			final Boolean spamFlag, final MessageState state,
			final String subject, Messages parent) {
		return flirtAndDateObjectFactory.newMessages(deletedFlag,
				failed2sentemail, folder, null, messageContent, messagetype, readFlag,
				sender, sentDate, spamFlag, state, subject, parent);
	}

	/**
	 * Gets the permissions.
	 * 
	 * @param description
	 *            the description
	 * @param permission
	 *            the permission
	 * @param shortcut
	 *            the shortcut
	 * @return the permissions
	 */
	public Permissions newPermissions(final String description,
			final String permission, final String shortcut) {
		return flirtAndDateObjectFactory.newPermissions(description,
				null, permission,
				shortcut);
	}

	/**
	 * Gets the reset passwords.
	 *
	 * @param expiryDate the expiry date
	 * @param generatedPassword the generated password
	 * @param starttime the starttime
	 * @param user the user
	 * @return the reset passwords
	 */
	public ResetPasswords newResetPasswords(final Date expiryDate,
			final String generatedPassword, final Date starttime,
			final Users user) {
		return flirtAndDateObjectFactory.newResetPasswords(null, expiryDate,
				generatedPassword, starttime, user);
	}

	/**
	 * Gets the roles.
	 * 
	 * @param description
	 *            the description
	 * @param rolename
	 *            the rolename
	 * @return the roles
	 */
	public Roles newRoles(final String description, final String rolename,
			Set<Permissions> permissions) {
		return flirtAndDateObjectFactory.newRoles(description,
				null, rolename, permissions);
	}

	/**
	 * Gets the user profile.
	 *
	 * @param age the age
	 * @param educationState the education state
	 * @param figure the figure
	 * @param haircolor the haircolor
	 * @param height the height
	 * @param interests the interests
	 * @param occupation the occupation
	 * @param profileText the profile text
	 * @param relationshipState the relationship state
	 * @param smokerstate the smokerstate
	 * @param user the user
	 * @param userImage the user image
	 * @param weight the weight
	 * @param zodiacSign the zodiac sign
	 * @return the user profile
	 */
	public UserProfile newUserProfile(Integer age,
			EducationState educationState, FigureType figure,
			HaircolorType haircolor, Integer height,
			InterestsType interests, String occupation, String profileText,
			RelationshipState relationshipState, SmokerState smokerstate,
			Users user, Resources userImage, Integer weight,
			ZodiacSignType zodiacSign, SearchCriteria searchCriteria) {
		return flirtAndDateObjectFactory.newUserProfile(age, educationState,
				figure, haircolor, height, interests, occupation,
				profileText, relationshipState, smokerstate, user, userImage,
				weight, zodiacSign, searchCriteria);
	}
	
	 public SearchCriteria newSearchCriteria(Integer fromAge, Integer untilAge, Gender searchGender){
		 return flirtAndDateObjectFactory.newSearchCriteria(fromAge, untilAge, searchGender);
	 }

		public Users newUsers(Boolean active, String pw, String salt,
				String username, Boolean locked, UserData userData, Set<Roles> roles) {
		return flirtAndDateObjectFactory.newUsers(active, pw, salt, username, locked, userData, roles);
	}

	/**
	 * Gets the zipcodes.
	 * 
	 * @param city
	 *            the city
	 * @param zipcode
	 *            the zipcode
	 * @return the zipcodes
	 */
	public Zipcodes newZipcodes(Countries country, String city, String zipcode) {
		return flirtAndDateObjectFactory.newZipcodes(null, country, city,
				zipcode);
	}
	
	public ProfileNotice newProfileNotice(String notice, Users user,
			UserProfile userProfile) {
		return flirtAndDateObjectFactory.newProfileNotice(notice, user, userProfile);		
	}
	
	public FavoriteMembers newFavoriteMembers(UserProfile favorite, Users owner){
		return flirtAndDateObjectFactory.newFavoriteMembers(favorite, owner);
	}
	
	public FriendshipRequests newFriendshipRequests(Users requestor, Users requestedUser, FriendshipRequestsState state){
		return flirtAndDateObjectFactory.newFriendshipRequests(requestor, requestedUser, state);
	}
	
	public ProfileVisitors newProfileVisitors(Date visitingDate, Users visitor, UserProfile visitedProfile, Integer count){
		return flirtAndDateObjectFactory.newProfileVisitors(visitingDate, visitor, visitedProfile, count);
	}

}
