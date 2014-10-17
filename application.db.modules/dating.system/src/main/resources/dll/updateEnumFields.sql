
alter table contactmethods drop column contactmethod;    
alter table contactmethods add contactmethod contactmethodType;

alter table friendship_requests drop column state;    
alter table friendship_requests add state friendshipRequestState;

alter table user_data drop column gender;    
alter table user_data add gender genderType;

alter table messages drop column state;    
alter table messages add state messageStateType;

alter table messages drop column messagetype;    
alter table messages add messagetype messageTypeType;

alter table profile_ratings drop column visibility;    
alter table profile_ratings add visibility visibilityType;

alter table search_criteria drop column search_gender;    
alter table search_criteria add search_gender genderType;

alter table user_profile drop column relationship_status;    
alter table user_profile add relationship_status relationshipState;

alter table user_profile drop column smokerstate;    
alter table user_profile add smokerstate smokerstateType;

alter table user_profile drop column zodiac_sign;    
alter table user_profile add zodiac_sign zodiacSignType;

alter table user_profile drop column haircolor;    
alter table user_profile add haircolor haircolorType;

alter table user_profile drop column interests;    
alter table user_profile add interests interestsType;

alter table user_profile drop column education_state;    
alter table user_profile add education_state educationState;

alter table user_profile drop column figure;    
alter table user_profile add figure figureType;

alter table rule_violations drop column reason;    
alter table rule_violations add reason ruleviolationreasontype;