package db.resource.bundles.init;
import hbm.init.AbstractDatabaseInitialization;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


public class DatabaseInitialization extends AbstractDatabaseInitialization {

	public DatabaseInitialization(Properties databaseProperties) {
		super(databaseProperties);
	}

	protected List<File> getScriptFiles() {
		return new ArrayList<>();
	}

}