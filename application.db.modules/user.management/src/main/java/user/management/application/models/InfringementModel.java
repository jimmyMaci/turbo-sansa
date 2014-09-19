package user.management.application.models;

import java.io.Serializable;

import lombok.Data;

import user.management.enums.RuleViolationReason;
import user.management.model.Users;

@Data
public class InfringementModel implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private RuleViolationReason reason;
	
	private Users detector;
	
	private Users violator;
	
	private String description;

}
