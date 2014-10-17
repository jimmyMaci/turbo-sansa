package flirt.and.date.hbm.service.locator;


import message.system.service.api.MessageRecipientsService;
import message.system.service.api.MessagesService;
import resource.system.service.api.ResourcesService;
import user.management.service.api.AttributesService;
import user.management.service.api.ContactmethodsService;
import user.management.service.api.PermissionsService;
import user.management.service.api.RecommendationsService;
import user.management.service.api.RelationPermissionsService;
import user.management.service.api.ResetPasswordsService;
import user.management.service.api.RobinsonsService;
import user.management.service.api.RolesService;
import user.management.service.api.RuleViolationsService;
import user.management.service.api.UserDataService;
import user.management.service.api.UserManagementService;
import user.management.service.api.UsersService;
import address.book.service.api.AddressesService;
import address.book.service.api.CountriesService;
import address.book.service.api.FederalstatesService;
import address.book.service.api.ZipcodesService;
import db.resource.bundles.service.api.ResourcebundlesService;
import flirt.and.date.hbm.service.api.FavoriteMembersService;
import flirt.and.date.hbm.service.api.FriendshipRequestsService;
import flirt.and.date.hbm.service.api.ProfileNoticeService;
import flirt.and.date.hbm.service.api.ProfileRatingsService;
import flirt.and.date.hbm.service.api.ProfileVisitorsService;
import flirt.and.date.hbm.service.api.SearchCriteriaService;
import flirt.and.date.hbm.service.api.UserCreditsService;
import flirt.and.date.hbm.service.api.UserProfileService;

/**
 * The Interface ServiceLocator.
 */
public interface ServiceLocator {
	RelationPermissionsService getRelationPermissionsService();
	void setRelationPermissionsService(
			RelationPermissionsService relationPermissionsService);
	/**
	 * Gets the RecommendationsService.
	 * 
	 * @return the RecommendationsService. 
	 */
	RecommendationsService getRecommendationsService();
	/**
	 * Gets the addresses business service.
	 * 
	 * @return the addresses business service
	 */
	AddressesService getAddressesService();

	/**
	 * Gets the contactmethods business service.
	 * 
	 * @return the contactmethods business service
	 */
	ContactmethodsService getContactmethodsService();

	/**
	 * Gets the countries business service.
	 * 
	 * @return the countries business service
	 */
	CountriesService getCountriesService();

	/**
	 * Gets the favorite members service.
	 *
	 * @return the favorite members service
	 */
	FavoriteMembersService getFavoriteMembersService();

	/**
	 * Gets the federalstates business service.
	 * 
	 * @return the federalstates business service
	 */
	FederalstatesService getFederalstatesService();

	/**
	 * Gets the friendship requests service.
	 *
	 * @return the friendship requests service
	 */
	FriendshipRequestsService getFriendshipRequestsService();

	/**
	 * Gets the images business service.
	 * 
	 * @return the images business service
	 */
	ResourcesService getResourcesService();

	/**
	 * Gets the message recipients business service.
	 * 
	 * @return the message recipients business service
	 */
	MessageRecipientsService getMessageRecipientsService();

	/**
	 * Gets the messages business service.
	 * 
	 * @return the messages business service
	 */
	MessagesService getMessagesService();

	/**
	 * Gets the permission business service.
	 * 
	 * @return the permission business service
	 */
	PermissionsService getPermissionService();

	/**
	 * Gets the profile notice service.
	 *
	 * @return the profile notice service
	 */
	ProfileNoticeService getProfileNoticeService();

	/**
	 * Gets the profile ratings service.
	 *
	 * @return the profile ratings service
	 */
	ProfileRatingsService getProfileRatingsService();
	
	/**
	 * Gets the profile visitors service.
	 *
	 * @return the profile visitors service
	 */
	ProfileVisitorsService getProfileVisitorsService();

	/**
	 * Gets the reset passwords business service.
	 * 
	 * @return the reset passwords business service
	 */
	ResetPasswordsService getResetPasswordsService();

	/**
	 * Gets the resourcebundles service.
	 *
	 * @return the resourcebundles service
	 */
	ResourcebundlesService getResourcebundlesService();

	/**
	 * Gets the roles business service.
	 * 
	 * @return the roles business service
	 */
	RolesService getRolesService();

	/**
	 * Gets the search criteria service.
	 *
	 * @return the search criteria service
	 */
	SearchCriteriaService getSearchCriteriaService();

	/**
	 * Gets the user credits service.
	 *
	 * @return the user credits service
	 */
	UserCreditsService getUserCreditsService();

	/**
	 * Gets the user data service.
	 *
	 * @return the user data service
	 */
	UserDataService getUserDataService();

	/**
	 * Gets the user management business service.
	 * 
	 * @return the user management business service
	 */
	UserManagementService getUserManagementService();

	/**
	 * Gets the user profile service.
	 *
	 * @return the user profile service
	 */
	UserProfileService getUserProfileService();

	/**
	 * Gets the users business service.
	 * 
	 * @return the users business service
	 */
	UsersService getUsersService();

	/**
	 * Gets the zipcodes business service.
	 * 
	 * @return the zipcodes business service
	 */
	ZipcodesService getZipcodesService();

	/**
	 * Sets the addresses business service.
	 * 
	 * @param addressesService
	 *            the new addresses business service
	 */
	void setAddressesService(
			AddressesService addressesService);

	/**
	 * Sets the contactmethods business service.
	 * 
	 * @param contactmethodsService
	 *            the new contactmethods business service
	 */
	void setContactmethodsService(
			ContactmethodsService contactmethodsService);

	/**
	 * Sets the countries business service.
	 * 
	 * @param countriesService
	 *            the new countries business service
	 */
	void setCountriesService(
			CountriesService countriesService);

	/**
	 * Sets the favorite members service.
	 *
	 * @param favoriteMembersService the favorite members service
	 */
	void setFavoriteMembersService(FavoriteMembersService favoriteMembersService);
	
	/**
	 * Sets the federalstates business service.
	 * 
	 * @param federalstatesService
	 *            the new federalstates business service
	 */
	void setFederalstatesService(
			FederalstatesService federalstatesService);

	/**
	 * Sets the friendship requests service.
	 *
	 * @param friendshipRequestsService the friendship requests service
	 */
	void setFriendshipRequestsService(FriendshipRequestsService friendshipRequestsService);

	/**
	 * Sets the images business service.
	 * 
	 * @param imagesService
	 *            the new images business service
	 */
	void setResourcesService(
			ResourcesService imagesService);
	
	/**
	 * Sets the message recipients business service.
	 * 
	 * @param messageRecipientsService
	 *            the new message recipients business service
	 */
	void setMessageRecipientsService(
			MessageRecipientsService messageRecipientsService);
	
	/**
	 * Sets the messages business service.
	 * 
	 * @param messagesService
	 *            the new messages business service
	 */
	void setMessagesService(
			MessagesService messagesService);
	
	/**
	 * Sets the permission business service.
	 * 
	 * @param permissionService
	 *            the new permission business service
	 */
	void setPermissionService(
			PermissionsService permissionService);
	
	/**
	 * Sets the profile notice service.
	 *
	 * @param profileNoticeService the profile notice service
	 */
	void setProfileNoticeService(ProfileNoticeService profileNoticeService);
	
	/**
	 * Sets the profile ratings service.
	 *
	 * @param profileRatingsService the profile ratings service
	 */
	void setProfileRatingsService(ProfileRatingsService profileRatingsService);
	
	/**
	 * Sets the profile visitors service.
	 *
	 * @param profileVisitorsService the profile visitors service
	 */
	void setProfileVisitorsService(ProfileVisitorsService profileVisitorsService);
	
	/**
	 * Sets the reset passwords business service.
	 * 
	 * @param resetPasswordsService
	 *            the new reset passwords business service
	 */
	void setResetPasswordsService(
			ResetPasswordsService resetPasswordsService);
	
	/**
	 * Sets the resourcebundles service.
	 *
	 * @param resourcebundlesService the resourcebundles service
	 */
	void setResourcebundlesService(ResourcebundlesService resourcebundlesService);
	
	/**
	 * Sets the roles business service.
	 * 
	 * @param rolesService
	 *            the new roles business service
	 */
	void setRolesService(
			RolesService rolesService);
	
	/**
	 * Sets the search criteria service.
	 *
	 * @param searchCriteriaService the search criteria service
	 */
	void setSearchCriteriaService(SearchCriteriaService searchCriteriaService);
	
	/**
	 * Sets the user credits service.
	 *
	 * @param userCreditsService the user credits service
	 */
	void setUserCreditsService(UserCreditsService userCreditsService);
	
	/**
	 * Sets the user data service.
	 *
	 * @param userDataService the user data service
	 */
	void setUserDataService(UserDataService userDataService);
	
	/**
	 * Sets the user management business service.
	 * 
	 * @param userManagementService
	 *            the new user management business service
	 */
	void setUserManagementService(
			UserManagementService userManagementService);
	
	/**
	 * Sets the user profile business service.
	 * 
	 * @param userProfileService
	 *            the new user profile business service
	 */
	void setUserProfileService(UserProfileService userProfileService );
	
	/**
	 * Sets the users business service.
	 * 
	 * @param usersService
	 *            the new users business service
	 */
	void setUsersService(
			UsersService usersService);
	
	/**
	 * Sets the zipcodes business service.
	 * 
	 * @param zipcodesService
	 *            the new zipcodes business service
	 */
	void setZipcodesService(
			ZipcodesService zipcodesService);
	
	/**
	 * Gets the rule violations service.
	 *
	 * @return the rule violations service
	 */
	RuleViolationsService getRuleViolationsService();

	/**
	 * Sets the rule violations service.
	 *
	 * @param ruleViolationsService the new rule violations service
	 */
	void setRuleViolationsService(RuleViolationsService ruleViolationsService);

	/**
	 * Gets the robinsons service.
	 *
	 * @return the robinsons service
	 */
	RobinsonsService getRobinsonsService();

	/**
	 * Sets the robinsons service.
	 *
	 * @param robinsonsService the new robinsons service
	 */
	void setRobinsonsService(RobinsonsService robinsonsService);

	/**
	 * Sets the RecommendationsService.
	 *
	 * @param recommendationsService the new RecommendationsService
	 */
	void setRecommendationsService(RecommendationsService recommendationsService);
	
	AttributesService getAttributesService();
	
	void setAttributesService(AttributesService attributesService);

}
