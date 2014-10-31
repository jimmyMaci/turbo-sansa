create TYPE contactmethodtype as enum (
	'EMAIL', 'MAIL', 'TELEFON', 'FAX', 'MOBILE', 'SMS', 'MESSENGER', 'INTERNET', 'NEWSGROUP'
);
CREATE TYPE educationstate AS ENUM (
	'HAUPTSCHULE', 'REALSCHULE', 'GYMNASIUM', 'ABITUR', 'LEHRE', 'HOCHSCHULE'
);
CREATE TYPE figuretype AS ENUM (
	'SCHLANK', 'SPORTLICH', 'NORMAL', 'MOLLIG', 'FETT'
);
CREATE TYPE friendshiprequeststate AS ENUM (
	'REFUSED', 'AWAITING', 'ACCEPTED'
);
CREATE TYPE gendertype AS ENUM (
	'MALE', 'FEMALE', 'INCORPORATION', 'UNDEFINED'
);
CREATE TYPE haircolortype AS ENUM (
	'BLOND', 'BRAUN', 'SCHWARZ', 'ROT', 'GLATZE', 'OTHER'
);
CREATE TYPE intereststype AS ENUM (
	'MAILFRIENDSHIP', 'FLIRT', 'SOLIDRELATIONSHIP', 'SPORTRELATIONSHIP', 'ADVENTURE'
);
create TYPE messagestatetype as enum (
	'SIGNED', 'CONTACTED', 'EXPELLED', 'UNREPLIED', 'DELETED'
);
create TYPE messagetypetype as enum (
	'MAIL', 'REPLY', 'NOTE'
);
create TYPE visibilitytype as enum (
	'INVISIBLE', 'APPROVED', 'DENIED'
);
CREATE TYPE relationshipstate AS ENUM (
	'LEDIG', 'LEDIGMITPARTNER', 'VERHEIRATET', 'GETRENNT', 'GESCHIEDEN', 'VERWITWET'
);
create TYPE smokerstatetype as enum (
	'SMOKER', 'OCCASIONAL_SMOKER', 'NON_SMOKER'
);
CREATE TYPE zodiacsigntype AS ENUM (
	'WIDDER', 'STIER', 'ZWILLINGE', 'KREBS', 'LOEWE', 'JUNGFRAU', 'WAAGE', 'SKORPION', 'SCHUETZE', 'STEINBOCK', 'WASSERMANN', 'FISCHE'
);

create TYPE ruleviolationreasontype as enum (
	'ABUSE', 'RACIST', 'ADVERTISING', 'OTHER'
);

