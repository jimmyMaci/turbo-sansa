alter table addresses drop constraint FK_ADDRESSES_ZIPCODE_ID;
alter table addresses drop constraint FK_ADDRESSES_FEDERALSTATE_ID;
alter table blacklisted_contacts drop constraint FKA1253AB66B955CF9;
alter table blacklisted_contacts drop constraint FKA1253AB6A09C615E;
alter table event_locations drop constraint FK_EVENTLOCATIONS_EVENT_ID;
alter table event_locations drop constraint FK_EVENT_LOCATION_ID;
alter table event_locations drop constraint FK_EVENTLOCATIONS_APPOINTMENT_ID;
alter table event_locations drop constraint FK_EVENTLOCATIONS_CONTACTPERSON_ID;
alter table event_messages drop constraint FK_EVENT_MESSAGES_EVENT_LOCATION_ID;
alter table event_messages drop constraint FK_EVENT_MESSAGES_MESSAGE_ID;
alter table event_ratings drop constraint FK_EVENT_RATINGS_EVENT_ID;
alter table event_ratings drop constraint FK518F61D1B117ECD;
alter table event_topics drop constraint FK_EVENT_TOPICS_EVENT_ID;
alter table event_topics drop constraint FK_EVENT_TOPICS_TOPIC_ID;
alter table events drop constraint FK_EVENTS_CATEGORIES_ID;
alter table federalstates drop constraint FK_FEDERAL_STATES_COUNTRY_ID;
alter table message_attachments drop constraint FK64E05778E812C08D;
alter table message_attachments drop constraint FK64E05778442255DC;
alter table message_recipients drop constraint FK_MESSAGE_RECIPIENTS_RECIPIENT_EMAIL;
alter table message_recipients drop constraint FK_MESSAGE_RECIPIENTS_MESSAGE_ID;
alter table message_recipients drop constraint FK_MESSAGE_RECIPIENTS_RECIPIENT_ID;
alter table messages drop constraint FK_PARENT_MESSAGE_ID;
alter table messages drop constraint FK_MESSAGES_SENDER;
alter table messages drop constraint FK_MESSAGES_SENDER_EMAIL;
alter table offered_event_locations drop constraint FK_OFFERED_EVENT_LOCATIONS_EVENT_LOCATION_DATA_ID;
alter table offered_event_locations drop constraint FK_OFFERED_EVENT_LOCATIONS_CONTACT_PERSON_ID;
alter table offered_event_locations drop constraint FK_OFFERED_EVENT_LOCATIONS_PROVIDER_ID;
alter table offered_event_locations drop constraint FK_OFFERED_EVENT_LOCATIONS_USER_ADDRESS_ID;
alter table profile_federalstates drop constraint FK_PROFILE_FEDERALSTATES_USER_ID;
alter table profile_federalstates drop constraint FK_PROFILE_FEDERALSTATES_FEDERALSTATE_ID;
alter table profile_topics drop constraint FK_PROFILE_TOPICS_USER_ID;
alter table profile_topics drop constraint FK_PROFILE_TOPICS_TOPIC_ID;
alter table rating_descriptions drop constraint FK_RATING_DESCRIPTIONS_EVENT_RATINGS_ID;
alter table recommendations drop constraint FK_RECOMMENDATIONS_USER_ID;
alter table recommendations drop constraint FK_RECOMMENDATIONS_RECOMMENDED_ID;
alter table relation_permissions drop constraint FK_USER_RELATION_PERMISSIONS_SUBSCRIBER_ID;
alter table relation_permissions drop constraint FK_USER_RELATION_PERMISSIONS_PROVIDER_ID;
alter table reset_passwords drop constraint FK_RESET_PASSWORDS_USER_ID;
alter table robinsons drop constraint FK_ROBINSON_USER_ID;
alter table role_permissions drop constraint FKEAD9D23B5682C574;
alter table role_permissions drop constraint FKEAD9D23B70D24902;
alter table rule_violations drop constraint FK_DETECTOR_USER_ID;
alter table rule_violations drop constraint FK_VIOLATOR_USER_ID;
alter table topics drop constraint FK_TOPICS_PARENT_ID;
alter table user_addresses drop constraint FK9188602EA09C615E;
alter table user_addresses drop constraint FK9188602ED634EE8A;
alter table user_contactmethods drop constraint FKA59F5686A09C615E;
alter table user_contactmethods drop constraint FKA59F56868708F8A7;
alter table user_contacts drop constraint FKE130BA475C8835C9;
alter table user_contacts drop constraint FKE130BA47A09C615E;
alter table user_contacts_allowed_contactmethods drop constraint FK_ALLOWED_CONTACTMETHODS_USER_CONTACT_ID;
alter table user_contacts_allowed_contactmethods drop constraint FK_ALLOWED_CONTACTMETHODS_USER_CONTACTMETHOD_ID;
alter table user_credits drop constraint FK_USER_CREDITS_USER_ID;
alter table user_data drop constraint FK_USER_DATA_PRIMARY_ADDRESS_ID;
alter table user_relation_permissions drop constraint FKDBE83EB570D24902;
alter table user_relation_permissions drop constraint FKDBE83EB51DB40057;
alter table user_resources drop constraint FKE734A2B187A1FB16;
alter table user_resources drop constraint FKE734A2B1A09C615E;
alter table user_roles drop constraint FK734299495682C574;
alter table user_roles drop constraint FK73429949FBD81D4A;
alter table userevents drop constraint FK_USEREVENTS_USER_ID;
alter table userevents drop constraint FK_USEREVENTS_EVENT_ID;
alter table users drop constraint FK6A68E083DCC3A0;
alter table zipcodes drop constraint FK_ZIP_CODES_COUNTRY_ID;
drop table addresses;
drop table appointments;
drop table attributes;
drop table blacklisted_contacts;
drop table categories;
drop table contactmethods;
drop table countries;
drop table event_location_data;
drop table event_locations;
drop table event_messages;
drop table event_ratings;
drop table event_topics;
drop table events;
drop table federalstates;
drop table message_attachments;
drop table message_recipients;
drop table messages;
drop table offered_event_locations;
drop table permissions;
drop table profile_federalstates;
drop table profile_topics;
drop table rating_descriptions;
drop table recommendations;
drop table relation_permissions;
drop table reset_passwords;
drop table resources;
drop table robinsons;
drop table role_permissions;
drop table roles;
drop table rule_violations;
drop table topics;
drop table user_addresses;
drop table user_contactmethods;
drop table user_contacts;
drop table user_contacts_allowed_contactmethods;
drop table user_credits;
drop table user_data;
drop table user_relation_permissions;
drop table user_resources;
drop table user_roles;
drop table userevents;
drop table users;
drop table zipcodes;
drop sequence hibernate_sequence;
