package resource.system.application.model;

import resource.system.model.Resources;

public class ModelSynchronizer {
	
	public static void synchronize(Resources toSynchronize, Resources withImage){
		toSynchronize.setChecksum(withImage.getChecksum());
		toSynchronize.setContent(withImage.getContent());
		toSynchronize.setContentType(withImage.getContentType());
		toSynchronize.setCreated(withImage.getCreated());
		toSynchronize.setDeletedFlag(withImage.isDeletedFlag());
		toSynchronize.setDescription(withImage.getDescription());
		toSynchronize.setFilename(withImage.getFilename());
		toSynchronize.setFilesize(withImage.getFilesize());
	}

}
