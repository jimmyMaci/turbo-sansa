package user.management.application.models;

import java.io.File;

import net.sourceforge.jaulp.date.ConvertDateUtils;
import net.sourceforge.jaulp.file.checksum.Algorithm;
import net.sourceforge.jaulp.file.checksum.ChecksumUtils;
import net.sourceforge.jaulp.file.read.ReadFileUtils;
import resource.system.application.model.ResourcesModel;
import resource.system.factories.ResourceSystemFactory;
import resource.system.model.Resources;

/**
 * The Class ModelConverter.
 */
public class UserModelConverter {

	/**
	 * Convert the given FileModel object to an Resources object.
	 * 
	 * @param resourcesModel
	 *            the upload file model
	 * @return the resources
	 */
	public static Resources convert(final ResourcesModel resourcesModel) {
		Resources resources = ResourceSystemFactory.getInstance().newResources(
				resourcesModel.getDescription(), resourcesModel.getFilename(),
				resourcesModel.getFilesize(), resourcesModel.getContentType(),
				resourcesModel.getContent(), resourcesModel.getCreated(), resourcesModel.isDeletedFlag(), resourcesModel.getChecksum());
		return resources;
	}

	/**
	 * Equalizes the given image with the resourcesModel object so the resourcesModel
	 * object sets the values from resources object.
	 * 
	 * @param resources
	 *            the resources
	 * @param resourcesModel
	 *            the file model
	 */
	public static void equalise(final Resources resources, final ResourcesModel resourcesModel) {		
		resources.setChecksum(resourcesModel.getChecksum());
		resources.setContent(resourcesModel.getContent());
		resources.setContentType(resourcesModel.getContentType());
		resources.setCreated(resourcesModel.getCreated());
		resources.setDeletedFlag(resourcesModel.isDeletedFlag());
		resources.setDescription(resourcesModel.getDescription());
		resources.setFilename(resourcesModel.getFilename());
		resources.setFilesize(resourcesModel.getFilesize());
	}
	
	/**
	 * Converts the given File object to a ResourceModel object.
	 *
	 * @param file the file
	 * @param contentType the content type
	 * @param description the description
	 * @return the ResourceModel
	 */
	public static ResourcesModel toResourceModel(File file, String contentType, String description) {
		ResourcesModel resourcesModel = new ResourcesModel();
		resourcesModel.setContent(ReadFileUtils.getFilecontentAsByteObjectArray(file));
		resourcesModel.setContentType(contentType);
		resourcesModel.setDescription(description);
		resourcesModel.setFilename(file.getName());
		resourcesModel.setFilesize(file.length()+"");
		resourcesModel.setChecksum(ChecksumUtils.getChecksumQuietly(file, Algorithm.SHA_256));
		resourcesModel.setCreated(ConvertDateUtils.toDate(file.lastModified()));
		resourcesModel.setDeletedFlag(Boolean.FALSE);
		return resourcesModel;
	}	

}