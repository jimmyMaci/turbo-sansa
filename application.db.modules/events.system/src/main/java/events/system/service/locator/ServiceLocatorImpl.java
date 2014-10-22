package events.system.service.locator;

import message.system.service.api.MessageRecipientsService;
import message.system.service.api.MessagesService;

import org.springframework.beans.factory.annotation.Autowired;

import de.alpharogroup.scheduler.system.service.api.AppointmentsService;
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
import events.system.service.api.CategoriesService;
import events.system.service.api.EventLocationDataService;
import events.system.service.api.EventLocationsService;
import events.system.service.api.EventMessagesService;
import events.system.service.api.EventRatingsService;
import events.system.service.api.EventTemplateService;
import events.system.service.api.EventTopicsService;
import events.system.service.api.OfferedEventLocationsService;
import events.system.service.api.ProfileFederalstatesService;
import events.system.service.api.ProfileTopicsService;
import events.system.service.api.RatingDescriptionsService;
import events.system.service.api.TopicsService;
import events.system.service.api.UserContactsAllowedContactmethodsService;
import events.system.service.api.UsereventsService;
import flirt.and.date.hbm.service.api.UserCreditsService;

public class ServiceLocatorImpl 
implements ServiceLocator 
{	
	/** The AppointmentsService. */
	@Autowired
	private AppointmentsService appointmentsService;
	/** The AttributesService  */
	@Autowired
	private AttributesService attributesService;
	
	/** The RecommendationsService  */
	@Autowired
	private RecommendationsService recommendationsService;

	/** The addresses service. */
	@Autowired
	private AddressesService addressesService;
	
	/** The RelationPermissions service. */
	@Autowired
	private RelationPermissionsService relationPermissionsService;

	/** The contactmethods service. */
	@Autowired
	private ContactmethodsService contactmethodsService;

	/** The countries service. */
	@Autowired
	private CountriesService countriesService;

	/** The federalstates service. */
	@Autowired
	private FederalstatesService federalstatesService;

	/** The ResourcesService. */
	@Autowired
	private ResourcesService resourcesService;

	/** The message recipients service. */
	@Autowired
	private MessageRecipientsService messageRecipientsService;

	/** The messages service. */
	@Autowired
	private MessagesService messagesService;

	/** The permission service. */
	@Autowired
	private PermissionsService permissionService;

	/** The reset passwords service. */
	@Autowired
	private ResetPasswordsService resetPasswordsService;

	/** The roles service. */
	@Autowired
	private RolesService rolesService;

	/** The UserCredits service. */
	@Autowired
	private UserCreditsService userCreditsService;

	/** The users data service. */
	@Autowired
	private UserDataService userDataService;

	/** The user management service. */
	@Autowired
	private UserManagementService userManagementService;

	/** The users service. */
	@Autowired
	private UsersService usersService;

	/** The zipcodes service. */
	@Autowired
	private ZipcodesService zipcodesService;

	/** The RuleViolations service. */
	@Autowired
	private RuleViolationsService ruleViolationsService;

	/** The Robinsons service. */
	@Autowired
	private RobinsonsService robinsonsService;
	
	/** The CategoriesService. */
	@Autowired
	private CategoriesService categoriesService;
	
	/** The EventLocationDataService. */
	@Autowired
	private EventLocationDataService eventLocationDataService;
	
	/** The EventLocationsService. */
	@Autowired
	private EventLocationsService eventLocationsService;
	
	/** The EventMessagesService. */
	@Autowired
	private EventMessagesService eventMessagesService;
	
	/** The EventRatingsService. */
	@Autowired
	private EventRatingsService eventRatingsService;
	
	/** The EventTemplateService. */
	@Autowired
	private EventTemplateService eventTemplateService;
	
	/** The EventTopicsService. */
	@Autowired
	private EventTopicsService eventTopicsService;
	
	/** The OfferedEventLocationsService. */
	@Autowired
	private OfferedEventLocationsService offeredEventLocationsService;
	
	/** The ProfileFederalstatesService. */
	@Autowired
	private ProfileFederalstatesService profileFederalstatesService;
	
	/** The ProfileTopicsService. */
	@Autowired
	private ProfileTopicsService profileTopicsService;
	
	/** The RatingDescriptionsService. */
	@Autowired
	private RatingDescriptionsService ratingDescriptionsService;
	
	/** The TopicsService. */
	@Autowired
	private TopicsService topicsService;
	
	/** The UserContactsAllowedContactmethodsService. */
	@Autowired
	private UserContactsAllowedContactmethodsService userContactsAllowedContactmethodsService;
	
	/** The UsereventsService. */
	@Autowired
	private UsereventsService usereventsService;

	public AttributesService getAttributesService() {
		return attributesService;
	}

	public void setAttributesService(AttributesService attributesService) {
		this.attributesService = attributesService;
	}

	public RecommendationsService getRecommendationsService() {
		return recommendationsService;
	}

	public void setRecommendationsService(
			RecommendationsService recommendationsService) {
		this.recommendationsService = recommendationsService;
	}

	public AddressesService getAddressesService() {
		return addressesService;
	}

	public void setAddressesService(AddressesService addressesService) {
		this.addressesService = addressesService;
	}

	public RelationPermissionsService getRelationPermissionsService() {
		return relationPermissionsService;
	}

	public void setRelationPermissionsService(
			RelationPermissionsService relationPermissionsService) {
		this.relationPermissionsService = relationPermissionsService;
	}

	public ContactmethodsService getContactmethodsService() {
		return contactmethodsService;
	}

	public void setContactmethodsService(ContactmethodsService contactmethodsService) {
		this.contactmethodsService = contactmethodsService;
	}

	public CountriesService getCountriesService() {
		return countriesService;
	}

	public void setCountriesService(CountriesService countriesService) {
		this.countriesService = countriesService;
	}

	public FederalstatesService getFederalstatesService() {
		return federalstatesService;
	}

	public void setFederalstatesService(FederalstatesService federalstatesService) {
		this.federalstatesService = federalstatesService;
	}

	public ResourcesService getResourcesService() {
		return resourcesService;
	}

	public void setResourcesService(ResourcesService resourcesService) {
		this.resourcesService = resourcesService;
	}

	public MessageRecipientsService getMessageRecipientsService() {
		return messageRecipientsService;
	}

	public void setMessageRecipientsService(
			MessageRecipientsService messageRecipientsService) {
		this.messageRecipientsService = messageRecipientsService;
	}

	public MessagesService getMessagesService() {
		return messagesService;
	}

	public void setMessagesService(MessagesService messagesService) {
		this.messagesService = messagesService;
	}

	public PermissionsService getPermissionService() {
		return permissionService;
	}

	public void setPermissionService(PermissionsService permissionService) {
		this.permissionService = permissionService;
	}

	public ResetPasswordsService getResetPasswordsService() {
		return resetPasswordsService;
	}

	public void setResetPasswordsService(ResetPasswordsService resetPasswordsService) {
		this.resetPasswordsService = resetPasswordsService;
	}

	public RolesService getRolesService() {
		return rolesService;
	}

	public void setRolesService(RolesService rolesService) {
		this.rolesService = rolesService;
	}

	public UserCreditsService getUserCreditsService() {
		return userCreditsService;
	}

	public void setUserCreditsService(UserCreditsService userCreditsService) {
		this.userCreditsService = userCreditsService;
	}

	public UserDataService getUserDataService() {
		return userDataService;
	}

	public void setUserDataService(UserDataService userDataService) {
		this.userDataService = userDataService;
	}

	public UserManagementService getUserManagementService() {
		return userManagementService;
	}

	public void setUserManagementService(UserManagementService userManagementService) {
		this.userManagementService = userManagementService;
	}

	public UsersService getUsersService() {
		return usersService;
	}

	public void setUsersService(UsersService usersService) {
		this.usersService = usersService;
	}

	public ZipcodesService getZipcodesService() {
		return zipcodesService;
	}

	public void setZipcodesService(ZipcodesService zipcodesService) {
		this.zipcodesService = zipcodesService;
	}

	public RuleViolationsService getRuleViolationsService() {
		return ruleViolationsService;
	}

	public void setRuleViolationsService(RuleViolationsService ruleViolationsService) {
		this.ruleViolationsService = ruleViolationsService;
	}

	public RobinsonsService getRobinsonsService() {
		return robinsonsService;
	}

	public void setRobinsonsService(RobinsonsService robinsonsService) {
		this.robinsonsService = robinsonsService;
	}

	public CategoriesService getCategoriesService() {
		return categoriesService;
	}

	public void setCategoriesService(CategoriesService categoriesService) {
		this.categoriesService = categoriesService;
	}

	public EventLocationDataService getEventLocationDataService() {
		return eventLocationDataService;
	}

	public void setEventLocationDataService(
			EventLocationDataService eventLocationDataService) {
		this.eventLocationDataService = eventLocationDataService;
	}

	public EventLocationsService getEventLocationsService() {
		return eventLocationsService;
	}

	public void setEventLocationsService(EventLocationsService eventLocationsService) {
		this.eventLocationsService = eventLocationsService;
	}

	public EventMessagesService getEventMessagesService() {
		return eventMessagesService;
	}

	public void setEventMessagesService(EventMessagesService eventMessagesService) {
		this.eventMessagesService = eventMessagesService;
	}

	public EventRatingsService getEventRatingsService() {
		return eventRatingsService;
	}

	public void setEventRatingsService(EventRatingsService eventRatingsService) {
		this.eventRatingsService = eventRatingsService;
	}

	public EventTemplateService getEventTemplateService() {
		return eventTemplateService;
	}

	public void setEventTemplateService(EventTemplateService eventTemplateService) {
		this.eventTemplateService = eventTemplateService;
	}

	public EventTopicsService getEventTopicsService() {
		return eventTopicsService;
	}

	public void setEventTopicsService(EventTopicsService eventTopicsService) {
		this.eventTopicsService = eventTopicsService;
	}

	public OfferedEventLocationsService getOfferedEventLocationsService() {
		return offeredEventLocationsService;
	}

	public void setOfferedEventLocationsService(
			OfferedEventLocationsService offeredEventLocationsService) {
		this.offeredEventLocationsService = offeredEventLocationsService;
	}

	public ProfileFederalstatesService getProfileFederalstatesService() {
		return profileFederalstatesService;
	}

	public void setProfileFederalstatesService(
			ProfileFederalstatesService profileFederalstatesService) {
		this.profileFederalstatesService = profileFederalstatesService;
	}

	public ProfileTopicsService getProfileTopicsService() {
		return profileTopicsService;
	}

	public void setProfileTopicsService(ProfileTopicsService profileTopicsService) {
		this.profileTopicsService = profileTopicsService;
	}

	public RatingDescriptionsService getRatingDescriptionsService() {
		return ratingDescriptionsService;
	}

	public void setRatingDescriptionsService(
			RatingDescriptionsService ratingDescriptionsService) {
		this.ratingDescriptionsService = ratingDescriptionsService;
	}

	public TopicsService getTopicsService() {
		return topicsService;
	}

	public void setTopicsService(TopicsService topicsService) {
		this.topicsService = topicsService;
	}

	public UserContactsAllowedContactmethodsService getUserContactsAllowedContactmethodsService() {
		return userContactsAllowedContactmethodsService;
	}

	public void setUserContactsAllowedContactmethodsService(
			UserContactsAllowedContactmethodsService userContactsAllowedContactmethodsService) {
		this.userContactsAllowedContactmethodsService = userContactsAllowedContactmethodsService;
	}

	public UsereventsService getUsereventsService() {
		return usereventsService;
	}

	public void setUsereventsService(UsereventsService usereventsService) {
		this.usereventsService = usereventsService;
	}

	public AppointmentsService getAppointmentsService() {
		return appointmentsService;
	}

	public void setAppointmentsService(AppointmentsService appointmentsService) {
		this.appointmentsService = appointmentsService;		
	}

}
