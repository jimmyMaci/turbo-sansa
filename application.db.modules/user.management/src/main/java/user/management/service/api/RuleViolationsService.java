package user.management.service.api;

import hbm.service.jpa.BusinessService;

import java.util.List;

import user.management.application.models.InfringementModel;
import user.management.enums.RuleViolationReason;
import user.management.model.RuleViolations;
import user.management.model.Users;

public interface RuleViolationsService extends BusinessService<RuleViolations, Integer>{

	RuleViolations save(InfringementModel model);
	
	List<RuleViolations> find(Users detector, Users violator, RuleViolationReason reason, String description);
}