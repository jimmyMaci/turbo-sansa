package events.system.factories;

import java.util.Date;

import rating.system.enums.RatingVisibility;
import message.system.model.Messages;
import address.book.model.Addresses;
import address.book.model.Federalstates;
import user.management.model.Contactmethods;
import user.management.model.Users;
import de.alpharogroup.scheduler.system.model.Appointments;
import events.system.enums.Difficulty;
import events.system.enums.EventType;
import events.system.enums.UsereventsRelationType;
import events.system.model.Categories;
import events.system.model.EventLocationData;
import events.system.model.EventLocations;
import events.system.model.EventMessages;
import events.system.model.EventRatings;
import events.system.model.EventTemplate;
import events.system.model.EventTopics;
import events.system.model.OfferedEventLocations;
import events.system.model.ProfileFederalstates;
import events.system.model.ProfileTopics;
import events.system.model.RatingDescriptions;
import events.system.model.Topics;
import events.system.model.UserContactsAllowedContactmethods;
import events.system.model.Userevents;

public class EventSystemFactory {

	/** The Constant instance. */
	private static final EventSystemFactory instance = new EventSystemFactory();

	public static EventSystemFactory getInstance() {
		return instance;
	}

	private EventSystemFactory() {
	}

	public Categories newCategories(Integer id, String name) {
		Categories categories = new Categories();
		categories.setId(id);
		categories.setName(name);
		return categories;
	}

	public EventLocationData newEventLocationData(Integer availableRooms,
			Integer cateringAbilities, Integer id, Integer nearByRestaurant,
			Boolean offeredEvening, Boolean offeredWeekdays,
			Boolean offeredWeekend, Integer parkingAbilities, String roomtype,
			Integer seatsPerRoom) {
		EventLocationData eventLocationData = new EventLocationData();
		eventLocationData.setAvailableRooms(availableRooms);
		eventLocationData.setCateringAbilities(cateringAbilities);
		eventLocationData.setId(id);
		eventLocationData.setNearByRestaurant(nearByRestaurant);
		eventLocationData.setOfferedEvening(offeredEvening);
		eventLocationData.setOfferedWeekdays(offeredWeekdays);
		eventLocationData.setOfferedWeekend(offeredWeekend);
		eventLocationData.setParkingAbilities(parkingAbilities);
		eventLocationData.setRoomtype(roomtype);
		eventLocationData.setSeatsPerRoom(seatsPerRoom);
		return eventLocationData;
	}

	public EventLocations newEventLocations(Appointments appointment,
			Users contactperson, EventTemplate event, Integer id,
			Addresses userAddress) {
		EventLocations eventLocations = new EventLocations();
		eventLocations.setAppointment(appointment);
		eventLocations.setContactperson(contactperson);
		eventLocations.setEvent(event);
		eventLocations.setId(id);
		eventLocations.setEventLocation(userAddress);
		return eventLocations;
	}

	public EventMessages newEventMessages(EventLocations eventLocation,
			Integer id, Messages message) {
		EventMessages eventMessages = new EventMessages();
		eventMessages.setEventLocation(eventLocation);
		eventMessages.setId(id);
		eventMessages.setMessage(message);
		return eventMessages;
	}

	public EventRatings newEventRatings(Integer contact, EventTemplate event,
			Integer eventlocation, Integer id, Integer material,
			Integer presentation, Users rater, Date ratingDate,
			String ratingDescription, Integer support, String titleRating,
			Integer topic, RatingVisibility visibility) {
		EventRatings eventRatings = new EventRatings();
		eventRatings.setContact(contact);
		eventRatings.setEvent(event);
		eventRatings.setEventlocation(eventlocation);
		eventRatings.setId(id);
		eventRatings.setMaterial(material);
		eventRatings.setPresentation(presentation);
		eventRatings.setRater(rater);
		eventRatings.setRatingDate(ratingDate);
		eventRatings.setRatingDescription(ratingDescription);
		eventRatings.setSupport(support);
		eventRatings.setTitleRating(titleRating);
		eventRatings.setTopic(topic);
		eventRatings.setVisibility(visibility);
		return eventRatings;
	}

	public EventTemplate newEventTemplate(Categories categories,
			String consultant, String content, Difficulty difficulty,
			Integer duration, EventType eventtype, String head, Integer id,
			String introduction, String locale, Boolean material, String name,
			java.math.BigDecimal price, Users provider,
			String requirements, Integer subscribermax, Integer subscribermin,
			String targetgroup) {
		EventTemplate events = new EventTemplate();
		events.setCategories(categories);
		events.setConsultant(consultant);
		events.setContent(content);
		events.setDifficulty(difficulty);
		events.setDuration(duration);
		events.setEventtype(eventtype);
		events.setHead(head);
		events.setId(id);
		events.setIntroduction(introduction);
		events.setLocale(locale);
		events.setMaterial(material);
		events.setName(name);
		events.setPrice(price);
		events.setProvider(provider);
		events.setRequirements(requirements);
		events.setSubscribermax(subscribermax);
		events.setSubscribermin(subscribermin);
		events.setTargetgroup(targetgroup);
		return events;
	}

	public EventTopics newEventTopics(EventTemplate event, Integer id,
			Topics topic) {
		EventTopics eventTopics = new EventTopics();
		eventTopics.setEvent(event);
		eventTopics.setId(id);
		eventTopics.setTopic(topic);
		return eventTopics;
	}

	public OfferedEventLocations newOfferedEventLocations(
			EventLocationData eventLocationData, Integer id,
			String locationDescription, String locationEquipmentDescription,
			String offeredFromDescription, String supportDescription,
			Addresses userAddress) {
		OfferedEventLocations offeredEventLocations = new OfferedEventLocations();
		offeredEventLocations.setEventLocationData(eventLocationData);
		offeredEventLocations.setId(id);
		offeredEventLocations.setLocationDescription(locationDescription);
		offeredEventLocations
				.setLocationEquipmentDescription(locationEquipmentDescription);
		offeredEventLocations.setOfferedFromDescription(offeredFromDescription);
		offeredEventLocations.setSupportDescription(supportDescription);
		offeredEventLocations.setUserAddress(userAddress);

		return offeredEventLocations;
	}

	public ProfileFederalstates newProfileFederalstates(
			Federalstates federalstate, Integer id, Users user) {
		ProfileFederalstates profileFederalstates = new ProfileFederalstates();
		profileFederalstates.setFederalstate(federalstate);
		profileFederalstates.setId(id);
		profileFederalstates.setUser(user);
		return profileFederalstates;
	}

	public ProfileTopics newProfileTopics(Integer id, Topics topic, Users user) {
		ProfileTopics profileTopics = new ProfileTopics();
		profileTopics.setId(id);
		profileTopics.setTopic(topic);
		profileTopics.setUser(user);

		return profileTopics;
	}

	public RatingDescriptions newRatingDescriptions(EventRatings eventRatings,
			Integer id, String lessLikeRating, String mostLikeRating,
			String recommendConsultant, String recommendEvent) {
		RatingDescriptions ratingDescriptions = new RatingDescriptions();
		ratingDescriptions.setEventRatings(eventRatings);
		ratingDescriptions.setId(id);
		ratingDescriptions.setLessLikeRating(lessLikeRating);
		ratingDescriptions.setMostLikeRating(mostLikeRating);
		ratingDescriptions.setRecommendConsultant(recommendConsultant);
		ratingDescriptions.setRecommendEvent(recommendEvent);

		return ratingDescriptions;
	}

	public Topics newTopics(Integer id, String name, Boolean node, Topics parent) {
		Topics topics = new Topics();
		topics.setId(id);
		topics.setName(name);
		topics.setNode(node);
		topics.setParent(parent);
		return topics;
	}
	
    public UserContactsAllowedContactmethods newUserContactsAllowedContactmethods(
            Integer id, Users userContact,
            Contactmethods userContactmethod ) {
        UserContactsAllowedContactmethods userContactsAllowedContactmethods = new UserContactsAllowedContactmethods();
        userContactsAllowedContactmethods.setId( id );
        userContactsAllowedContactmethods.setUserContact( userContact );
        userContactsAllowedContactmethods.setUserContactmethod( userContactmethod );
        return userContactsAllowedContactmethods;
    }
    
    public Userevents newUserevents( EventTemplate event, Integer id,
    		UsereventsRelationType relationtype, Users user ) {
        Userevents userevents = new Userevents();
        userevents.setEvent( event );
        userevents.setId( id );
        userevents.setRelationtype( relationtype );
        userevents.setUser( user );
        return userevents;
    }

}
