
    create table addresses (
        id int4 not null,
        address_comment varchar(100),
        geohash varchar(16),
        latitude varchar(12),
        longitude varchar(12),
        street varchar(64),
        streetnumber varchar(5),
        federalstate_id int4,
        zipcode_id int4,
        primary key (id)
    );
create table appointments (
        id int4 not null,
        endtime timestamp,
        nexttime timestamp,
        rhythm varchar(255),
        starttime timestamp,
        primary key (id)
    );
create table attributes (
        id int4 not null,
        name varchar(64),
        type varchar(256),
        value varchar(2048),
        primary key (id)
    );
create table blacklisted_contacts (
        user_data_id int4 not null,
        blacklisted_id int4 not null,
        primary key (user_data_id, blacklisted_id)
    );
create table categories (
        id int4 not null,
        name varchar(40),
        primary key (id)
    );
create table contactmethods (
        id int4 not null,
        contactmethod varchar(255),
        contactvalue varchar(1024),
        primary key (id)
    );
create table countries (
        id int4 not null,
        iso3166_a2name varchar(2),
        iso3166_a3name varchar(3),
        iso3166_number varchar(3),
        name varchar(128),
        primary key (id)
    );
create table event_location_data (
        id int4 not null,
        available_rooms int4,
        catering_abilities int4,
        near_by_restaurant int4,
        offered_evening bool,
        offered_weekdays bool,
        offered_weekend bool,
        parking_abilities int4,
        roomtype varchar(256),
        seats_per_room int4,
        primary key (id)
    );
create table event_locations (
        id int4 not null,
        appointment_id int4,
        contactperson_id int4,
        event_id int4,
        event_location_id int4,
        primary key (id)
    );
create table event_messages (
        id int4 not null,
        event_location_id int4,
        message_id int4,
        primary key (id)
    );
create table event_ratings (
        id int4 not null,
        rating_date timestamp,
        rating_description varchar(1024),
        ratingpoints int4,
        title_rating varchar(256),
        visibility varchar(255),
        contact int4,
        eventlocation int4,
        material int4,
        presentation int4,
        support int4,
        topic int4,
        rater int4,
        event_id int4,
        primary key (id)
    );
create table event_topics (
        id int4 not null,
        event_id int4,
        topic_id int4,
        primary key (id)
    );
create table events (
        id int4 not null,
        consultant varchar(64),
        content varchar(21845),
        difficulty varchar(255),
        duration int4,
        eventtype varchar(255),
        head varchar(21845),
        introduction varchar(21845),
        locale varchar(3),
        material bool,
        name varchar(64),
        price numeric(19, 2),
        provider_id int4,
        requirements varchar(21845),
        subscribermax int4,
        subscribermin int4,
        targetgroup varchar(21845),
        categories_id int4,
        primary key (id)
    );
create table federalstates (
        id int4 not null,
        iso3166_a2code varchar(6),
        name varchar(128),
        subdivision_category varchar(128),
        subdivision_name varchar(56),
        country_id int4,
        primary key (id)
    );
create table message_attachments (
        message_id int4 not null,
        resource_id int4 not null,
        primary key (message_id, resource_id)
    );
create table message_recipients (
        id int4 not null,
        message_id int4,
        recipient_id int4,
        recipient_email int4,
        primary key (id)
    );
create table messages (
        id int4 not null,
        failed2sentemail bool,
        folder varchar(64),
        messageContent varchar(21845),
        messagetype varchar(255),
        read_flag bool,
        recipient_deleted_flag bool,
        sender_deleted_flag bool,
        sent_date timestamp,
        spam_flag bool,
        state varchar(255),
        subject varchar(1000),
        parent int4,
        sender int4,
        sender_email int4,
        primary key (id)
    );
create table offered_event_locations (
        id int4 not null,
        location_description varchar(21845),
        location_equipment_description varchar(21845),
        offered_from_description varchar(21845),
        support_description varchar(21845),
        user_id int4,
        event_location_data_id int4,
        user_address_id int4,
        primary key (id)
    );
create table permissions (
        id int4 not null,
        description varchar(64),
        permissionName varchar(64) unique,
        shortcut varchar(10) unique,
        primary key (id)
    );
create table profile_federalstates (
        id int4 not null,
        federalstate_id int4,
        user_id int4,
        primary key (id)
    );
create table profile_topics (
        id int4 not null,
        topic_id int4,
        user_id int4,
        primary key (id)
    );
create table rating_descriptions (
        id int4 not null,
        less_like_rating varchar(1024),
        most_like_rating varchar(1024),
        recommend_consultant varchar(1024),
        recommend_event varchar(1024),
        event_ratings_id int4,
        primary key (id)
    );
create table recommendations (
        id int4 not null,
        email varchar(1024),
        invitation_text varchar(1024),
        sent bool,
        recommended_id int4,
        user_id int4,
        primary key (id)
    );
create table relation_permissions (
        id int4 not null,
        provider_id int4,
        subscriber_id int4,
        primary key (id)
    );
create table reset_passwords (
        id int4 not null,
        expiry_date timestamp,
        generated_password varchar(1024),
        starttime timestamp,
        user_id int4,
        primary key (id)
    );
create table resources (
        id int4 not null,
        checksum varchar(255),
        content BYTEA,
        contentType varchar(64),
        created timestamp,
        deleted_flag bool,
        description varchar(1024),
        filename varchar(1024),
        filesize varchar(64),
        primary key (id)
    );
create table robinsons (
        id int4 not null,
        robinson_user_id int4,
        primary key (id)
    );
create table role_permissions (
        role_id int4 not null,
        permission_id int4 not null,
        primary key (role_id, permission_id)
    );
create table roles (
        id int4 not null,
        description varchar(64),
        rolename varchar(64) unique,
        primary key (id)
    );
create table rule_violations (
        id int4 not null,
        description varchar(1000),
        reason varchar(255),
        detector_user_id int4,
        violator_user_id int4,
        primary key (id)
    );
create table topics (
        id int4 not null,
        name varchar(1024),
        node bool,
        parent_id int4,
        primary key (id)
    );
create table user_addresses (
        user_data_id int4 not null,
        addresses_id int4 not null,
        primary key (user_data_id, addresses_id)
    );
create table user_contactmethods (
        user_data_id int4 not null,
        contactmethods_id int4 not null,
        primary key (user_data_id, contactmethods_id)
    );
create table user_contacts (
        user_data_id int4 not null,
        user_contact_id int4 not null,
        primary key (user_data_id, user_contact_id)
    );
create table user_contacts_allowed_contactmethods (
        id int4 not null,
        user_contact_id int4,
        user_contactmethod_id int4,
        primary key (id)
    );
create table user_credits (
        id int4 not null,
        credits int4,
        user_id int4,
        primary key (id)
    );
create table user_data (
        id int4 not null,
        birthname varchar(64),
        dateofbirth timestamp,
        firstname varchar(64),
        gender varchar(255),
        ip_address varchar(16),
        lastname varchar(64),
        locale varchar(12),
        primary_address_id int4,
        primary key (id)
    );
create table user_relation_permissions (
        user_relation_permission_id int4 not null,
        permission_id int4 not null,
        primary key (user_relation_permission_id, permission_id)
    );
create table user_resources (
        user_data_id int4 not null,
        resources_id int4 not null,
        primary key (user_data_id, resources_id)
    );
create table user_roles (
        user_id int4 not null,
        role_id int4 not null,
        primary key (user_id, role_id)
    );
create table userevents (
        id int4 not null,
        relationtype varchar(255),
        event_id int4,
        user_id int4,
        primary key (id)
    );
create table users (
        id int4 not null,
        active bool,
        locked bool,
        pw varchar(1024),
        salt varchar(8),
        username varchar(256) unique,
        user_data int4,
        primary key (id)
    );
create table zipcodes (
        id int4 not null,
        city varchar(128),
        zipcode varchar(10) not null,
        country_id int4,
        primary key (id)
    );


create type contactmethodType as enum (
	'EMAIL', 'MAIL', 'TELEFON', 'FAX', 'MOBILE', 'SMS', 'MESSENGER', 'INTERNET', 'NEWSGROUP'
);
create type difficultyType as enum (
	'BEGINNER','ADVANCED', 'EXPERT'
);
create type eventlocationType as enum (
	'INHOUSE', 'EVENTLOCATION'
);
create type genderType as enum (
	'MALE', 'FEMALE', 'INCORPORATION'
);
create type messageStateType as enum (
	'SIGNED', 'CONTACTED', 'EXPELLED', 'UNREPLIED', 'DELETED'
);
create type messageTypeType as enum (
	'MAIL', 'REPLY', 'NOTE'
);
create type visibilityType as enum (
	'INVISIBLE', 'APPROVED', 'DENIED'
);
create type rhythmType as enum (
	'DOES_NOT_REPEAT', 'DAILY', 'WEEKLY', 'MONTHLY', 'YEARLY', 'CUSTOM'
);
create type relationTypeType as enum (
	'REQUESTED', 'PROVIDED', 'SUBSCRIBED'
);

alter table contactmethods drop column contactmethod;    
alter table contactmethods add contactmethod contactmethodType;

alter table events drop column difficulty;    
alter table events add difficulty difficultyType;

alter table events drop column eventtype;    
alter table events add eventtype eventlocationType;

alter table user_data drop column gender;    
alter table user_data add gender genderType;

alter table messages drop column state;    
alter table messages add state messageStateType;

alter table messages drop column messagetype;    
alter table messages add messagetype messageTypeType;

alter table event_ratings drop column visibility;    
alter table event_ratings add visibility visibilityType;

alter table appointments drop column rhythm;    
alter table appointments add rhythm rhythmType;

alter table userevents drop column relationtype;    
alter table userevents add relationtype relationTypeType;
create index IDX_FEDERALSTATE_ID on addresses (federalstate_id);
create index IDX_ZIPCODE_ID on addresses (zipcode_id);
alter table addresses add constraint FK_ADDRESSES_FEDERALSTATE_ID foreign key (federalstate_id) references federalstates;
alter table addresses add constraint FK_ADDRESSES_ZIPCODE_ID foreign key (zipcode_id) references zipcodes;
alter table blacklisted_contacts add constraint FKA1253AB66B955CF9 foreign key (blacklisted_id) references users;
alter table blacklisted_contacts add constraint FKA1253AB6A09C615E foreign key (user_data_id) references user_data;
create index IDX_APPOINTMENT_ID on event_locations (appointment_id);
create index IDX_EVENTLOCATIONS_ID on event_locations (event_id);
create index IDX_EVENT_LOCATION_ID on event_locations (event_location_id);
create index IDX_CONTACTPERSON_ID on event_locations (contactperson_id);
alter table event_locations add constraint FK_EVENT_LOCATION_ID foreign key (event_location_id) references addresses;
alter table event_locations add constraint FK_EVENTLOCATIONS_EVENT_ID foreign key (event_id) references events;
alter table event_locations add constraint FK_EVENTLOCATIONS_APPOINTMENT_ID foreign key (appointment_id) references appointments;
alter table event_locations add constraint FK_EVENTLOCATIONS_CONTACTPERSON_ID foreign key (contactperson_id) references users;
create index IDX_EVENT_MESSAGES_EVENT_LOCATION_ID on event_messages (event_location_id);
create index IDX_EVENT_MESSAGES_ID on event_messages (message_id);
alter table event_messages add constraint FK_EVENT_MESSAGES_EVENT_LOCATION_ID foreign key (event_location_id) references event_locations;
alter table event_messages add constraint FK_EVENT_MESSAGES_MESSAGE_ID foreign key (message_id) references messages;
create index IDX_EVENT_RATINGS_ID on event_ratings (event_id);
alter table event_ratings add constraint FK_EVENT_RATINGS_EVENT_ID foreign key (event_id) references events;
alter table event_ratings add constraint FK518F61D1B117ECD foreign key (rater) references users;
create index IDX_EVENT_TOPICS_TOPIC_ID on event_topics (topic_id);
create index IDX_EVENT_TOPICS_ID on event_topics (event_id);
alter table event_topics add constraint FK_EVENT_TOPICS_EVENT_ID foreign key (event_id) references events;
alter table event_topics add constraint FK_EVENT_TOPICS_TOPIC_ID foreign key (topic_id) references topics;
create index IDX_CATEGORIES_ID on events (categories_id);
alter table events add constraint FK_EVENTS_CATEGORIES_ID foreign key (categories_id) references categories;
create index IDX_COUNTRY_ID on federalstates (country_id);
alter table federalstates add constraint FK_FEDERAL_STATES_COUNTRY_ID foreign key (country_id) references countries;
alter table message_attachments add constraint FK64E05778442255DC foreign key (message_id) references messages;
alter table message_attachments add constraint FK64E05778E812C08D foreign key (resource_id) references resources;
create index IDX_RECIPIENT_ID on message_recipients (recipient_id);
create index IDX_MESSAGE_RECIPIENTS_ID on message_recipients (message_id);
create index IDX_RECIPIENT_EMAIL on message_recipients (recipient_email);
alter table message_recipients add constraint FK_MESSAGE_RECIPIENTS_RECIPIENT_EMAIL foreign key (recipient_email) references contactmethods;
alter table message_recipients add constraint FK_MESSAGE_RECIPIENTS_RECIPIENT_ID foreign key (recipient_id) references users;
alter table message_recipients add constraint FK_MESSAGE_RECIPIENTS_MESSAGE_ID foreign key (message_id) references messages;
create index IDX_PARENT_MESSAGE_ID on messages (parent);
create index IDX_SENDER on messages (sender);
create index IDX_SENDER_EMAIL on messages (sender_email);
alter table messages add constraint FK_MESSAGES_SENDER foreign key (sender) references users;
alter table messages add constraint FK_MESSAGES_SENDER_EMAIL foreign key (sender_email) references contactmethods;
alter table messages add constraint FK_PARENT_MESSAGE_ID foreign key (parent) references messages;
create index IDX_OFFERED_EVENT_LOCATIONS_USER_ADDRESS_ID on offered_event_locations (user_address_id);
create index IDX_OFFERED_EVENT_LOCATIONS_CONTACT_PERSON_ID on offered_event_locations (user_id);
create index IDX_EVENT_LOCATION_DATA_ID on offered_event_locations (event_location_data_id);
alter table offered_event_locations add constraint FK_OFFERED_EVENT_LOCATIONS_EVENT_LOCATION_DATA_ID foreign key (event_location_data_id) references event_location_data;
alter table offered_event_locations add constraint FK_OFFERED_EVENT_LOCATIONS_CONTACT_PERSON_ID foreign key (user_id) references users;
alter table offered_event_locations add constraint FK_OFFERED_EVENT_LOCATIONS_USER_ADDRESS_ID foreign key (user_address_id) references addresses;
create index IDX_PROFILE_FEDERALSTATES_USER_ID on profile_federalstates (user_id);
create index IDX_PROFILE_FEDERALSTATES_ID on profile_federalstates (federalstate_id);
alter table profile_federalstates add constraint FK_PROFILE_FEDERALSTATES_FEDERALSTATE_ID foreign key (federalstate_id) references federalstates;
alter table profile_federalstates add constraint FK_PROFILE_FEDERALSTATES_USER_ID foreign key (user_id) references users;
create index IDX_PROFILE_TOPICS_TOPIC_ID on profile_topics (topic_id);
create index IDX_PROFILE_TOPICS_USER_ID on profile_topics (user_id);
alter table profile_topics add constraint FK_PROFILE_TOPICS_USER_ID foreign key (user_id) references users;
alter table profile_topics add constraint FK_PROFILE_TOPICS_TOPIC_ID foreign key (topic_id) references topics;
create index IDX_RATING_DESCRIPTIONS_EVENT_RATINGS_ID on rating_descriptions (event_ratings_id);
alter table rating_descriptions add constraint FK_RATING_DESCRIPTIONS_EVENT_RATINGS_ID foreign key (event_ratings_id) references event_ratings;
create index IDX_RECOMMENDATIONS_USER_ID on recommendations (user_id);
create index IDX_RECOMMENDATIONS_RECOMMENDED_ID on recommendations (recommended_id);
alter table recommendations add constraint FK_RECOMMENDATIONS_USER_ID foreign key (user_id) references users;
alter table recommendations add constraint FK_RECOMMENDATIONS_RECOMMENDED_ID foreign key (recommended_id) references users;
create index IDX_PROVIDER_ID on relation_permissions (provider_id);
create index IDX_SUBSCRIBER_ID on relation_permissions (subscriber_id);
alter table relation_permissions add constraint FK_USER_RELATION_PERMISSIONS_PROVIDER_ID foreign key (provider_id) references users;
alter table relation_permissions add constraint FK_USER_RELATION_PERMISSIONS_SUBSCRIBER_ID foreign key (subscriber_id) references users;
create index IDX_RESET_PASSWORDS_USER_ID on reset_passwords (user_id);
alter table reset_passwords add constraint FK_RESET_PASSWORDS_USER_ID foreign key (user_id) references users;
create index IDX_ROBINSON_USER_ID on robinsons (robinson_user_id);
alter table robinsons add constraint FK_ROBINSON_USER_ID foreign key (robinson_user_id) references users;
alter table role_permissions add constraint FKEAD9D23B5682C574 foreign key (role_id) references roles;
alter table role_permissions add constraint FKEAD9D23B70D24902 foreign key (permission_id) references permissions;
create index IDX_VIOLATOR_USER_ID on rule_violations (violator_user_id);
create index IDX_DETECTOR_USER_ID on rule_violations (detector_user_id);
alter table rule_violations add constraint FK_DETECTOR_USER_ID foreign key (detector_user_id) references users;
alter table rule_violations add constraint FK_VIOLATOR_USER_ID foreign key (violator_user_id) references users;
create index IDX_PARENT_ID on topics (parent_id);
alter table topics add constraint FK_TOPICS_PARENT_ID foreign key (parent_id) references topics;
alter table user_addresses add constraint FK9188602EA09C615E foreign key (user_data_id) references user_data;
alter table user_addresses add constraint FK9188602ED634EE8A foreign key (addresses_id) references addresses;
alter table user_contactmethods add constraint FKA59F56868708F8A7 foreign key (contactmethods_id) references contactmethods;
alter table user_contactmethods add constraint FKA59F5686A09C615E foreign key (user_data_id) references user_data;
alter table user_contacts add constraint FKE130BA47A09C615E foreign key (user_data_id) references user_data;
alter table user_contacts add constraint FKE130BA475C8835C9 foreign key (user_contact_id) references users;
create index IDX_USER_CONTACTMETHOD_ID on user_contacts_allowed_contactmethods (user_contactmethod_id);
create index IDX_USER_CONTACT_ID on user_contacts_allowed_contactmethods (user_contact_id);
alter table user_contacts_allowed_contactmethods add constraint FK_ALLOWED_CONTACTMETHODS_USER_CONTACTMETHOD_ID foreign key (user_contactmethod_id) references contactmethods;
alter table user_contacts_allowed_contactmethods add constraint FK_ALLOWED_CONTACTMETHODS_USER_CONTACT_ID foreign key (user_contact_id) references users;
create index IDX_USER_CREDITS_USER_ID on user_credits (user_id);
alter table user_credits add constraint FK_USER_CREDITS_USER_ID foreign key (user_id) references users;
create index IDX_PRIMARY_ADDRESS_ID on user_data (primary_address_id);
alter table user_data add constraint FK_USER_DATA_PRIMARY_ADDRESS_ID foreign key (primary_address_id) references addresses;
alter table user_relation_permissions add constraint FKDBE83EB570D24902 foreign key (permission_id) references permissions;
alter table user_relation_permissions add constraint FKDBE83EB51DB40057 foreign key (user_relation_permission_id) references relation_permissions;
alter table user_resources add constraint FKE734A2B1A09C615E foreign key (user_data_id) references user_data;
alter table user_resources add constraint FKE734A2B187A1FB16 foreign key (resources_id) references resources;
alter table user_roles add constraint FK734299495682C574 foreign key (role_id) references roles;
alter table user_roles add constraint FK73429949FBD81D4A foreign key (user_id) references users;
create index IDX_USEREVENTS_USER_ID on userevents (event_id);
create index IDX_USEREVENTS_ID on userevents (user_id);
alter table userevents add constraint FK_USEREVENTS_USER_ID foreign key (event_id) references events;
alter table userevents add constraint FK_USEREVENTS_EVENT_ID foreign key (user_id) references users;
alter table users add constraint FK6A68E083DCC3A0 foreign key (user_data) references user_data;
create index IDX_ZIP_CODES_COUNTRY_ID on zipcodes (country_id);
alter table zipcodes add constraint FK_ZIP_CODES_COUNTRY_ID foreign key (country_id) references countries;
create sequence hibernate_sequence;
