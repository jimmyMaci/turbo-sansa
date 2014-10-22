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