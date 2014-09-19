alter table addresses drop constraint FK_ADDRESSES_FEDERALSTATE_ID;
alter table addresses drop constraint FK_ADDRESSES_ZIPCODE_ID;
alter table federalstates drop constraint FK_FEDERAL_STATES_COUNTRY_ID;
alter table zipcodes drop constraint FK_ZIP_CODES_COUNTRY_ID;
drop table addresses;
drop table countries;
drop table federalstates;
drop table zipcodes;
drop sequence hibernate_sequence;
