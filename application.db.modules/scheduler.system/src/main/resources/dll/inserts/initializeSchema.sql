
    create table appointments (
        id int4 not null,
        endtime timestamp,
        nexttime timestamp,
        rhythm varchar(255),
        starttime timestamp,
        primary key (id)
    );


create type rhythmType as enum (
	'DOES_NOT_REPEAT', 'DAILY', 'WEEKLY', 'MONTHLY', 'YEARLY', 'CUSTOM'
);
alter table appointments drop column rhythm;    
alter table appointments add rhythm rhythmType;
create sequence hibernate_sequence;
