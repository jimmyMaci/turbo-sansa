package resource.system.application.util;

import java.util.ArrayList;
import java.util.List;

import net.sourceforge.jaulp.lang.ObjectUtils;
import resource.system.application.model.ResourcesModel;
import resource.system.model.Resources;

public class ModelConverter {
	
	public static List<ResourcesModel> toResourcesModel(List<Resources> resources) {
		List<ResourcesModel> rml = new ArrayList<ResourcesModel>();
		for (Resources resource : resources) {
			rml.add(toResourcesModel(resource));
		}
		return rml;
	}
	
	public static ResourcesModel toResourcesModel(Resources resource) {
		return ObjectUtils.copyQuietly(new ResourcesModel(), resource);
	}
}
