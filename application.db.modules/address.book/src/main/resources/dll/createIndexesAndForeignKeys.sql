create index IDX_FEDERALSTATE_ID on addresses (federalstate_id);
create index IDX_ZIPCODE_ID on addresses (zipcode_id);
alter table addresses add constraint FK_ADDRESSES_FEDERALSTATE_ID foreign key (federalstate_id) references federalstates;
alter table addresses add constraint FK_ADDRESSES_ZIPCODE_ID foreign key (zipcode_id) references zipcodes;
create index IDX_COUNTRY_ID on federalstates (country_id);
alter table federalstates add constraint FK_FEDERAL_STATES_COUNTRY_ID foreign key (country_id) references countries;
create index IDX_ZIP_CODES_COUNTRY_ID on zipcodes (country_id);
alter table zipcodes add constraint FK_ZIP_CODES_COUNTRY_ID foreign key (country_id) references countries;
create sequence hibernate_sequence;
