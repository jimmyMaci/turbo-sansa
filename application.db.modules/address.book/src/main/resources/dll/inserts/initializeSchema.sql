
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
create table countries (
        id int4 not null,
        iso3166_a2name varchar(2),
        iso3166_a3name varchar(3),
        iso3166_number varchar(3),
        name varchar(128),
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
create table zipcodes (
        id int4 not null,
        city varchar(128),
        zipcode varchar(10) not null,
        country_id int4,
        primary key (id)
    );


create index IDX_FEDERALSTATE_ID on addresses (federalstate_id);
create index IDX_ZIPCODE_ID on addresses (zipcode_id);
alter table addresses add constraint FK_ADDRESSES_FEDERALSTATE_ID foreign key (federalstate_id) references federalstates;
alter table addresses add constraint FK_ADDRESSES_ZIPCODE_ID foreign key (zipcode_id) references zipcodes;
create index IDX_COUNTRY_ID on federalstates (country_id);
alter table federalstates add constraint FK_FEDERAL_STATES_COUNTRY_ID foreign key (country_id) references countries;
create index IDX_ZIP_CODES_COUNTRY_ID on zipcodes (country_id);
alter table zipcodes add constraint FK_ZIP_CODES_COUNTRY_ID foreign key (country_id) references countries;
create sequence hibernate_sequence;
