package de.alpharogroup.scheduler.system.enums;

public enum Rhythm {
	
	DOES_NOT_REPEAT, DAILY, WEEKLY, MONTHLY, YEARLY, CUSTOM;
	
	public String getValue(){
		return this.name();
	}
	
}