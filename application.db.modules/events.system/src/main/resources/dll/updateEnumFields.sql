
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