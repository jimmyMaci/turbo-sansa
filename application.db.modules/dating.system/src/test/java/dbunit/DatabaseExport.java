package dbunit;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.sql.SQLException;

import net.sourceforge.jaulp.file.search.PathFinder;

import org.dbunit.DatabaseUnitException;
import org.dbunit.database.DatabaseSequenceFilter;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.FilteredDataSet;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.filter.ITableFilter;
import org.dbunit.dataset.xml.FlatDtdDataSet;
import org.dbunit.dataset.xml.FlatXmlWriter;

/**
 * The Class DatabaseExport.
 * 
 * @author Asterios Raptis
 */
public class DatabaseExport {

	/**
	 * The main method.
	 * 
	 * @param args
	 *            the arguments
	 * @throws IOException
	 * @throws FileNotFoundException
	 * @throws Exception
	 *             the exception
	 */
	public static void main(final String[] args) throws ClassNotFoundException,
			SQLException, DatabaseUnitException, FileNotFoundException,
			IOException {

		final IDatabaseConnection connection = PostgresqlDatabaseConnectionSingleton.getInstance();
		
		// automatically order tables by their foreign keys
		final ITableFilter filter = new DatabaseSequenceFilter(connection);
		final IDataSet dataset = new FilteredDataSet(filter,
				connection.createDataSet());
		// The resources destination dir
		final File srcTestResourcesDir = PathFinder.getSrcTestResourcesDir();
		File dbunitDir = new File(srcTestResourcesDir, "dbunit");
		File datasetDtd = new File(dbunitDir, "dataset.dtd");
		File datasetXml = new File(dbunitDir, "dataset.xml");
		// write DTD file
		FlatDtdDataSet.write(dataset, new FileOutputStream(datasetDtd));
		// write XML file
		FileOutputStream fos = new FileOutputStream(datasetXml);
		BufferedOutputStream bos = new BufferedOutputStream( fos );
		OutputStreamWriter osw = new OutputStreamWriter( bos, "UTF-8" );
		final FlatXmlWriter datasetWriter = new FlatXmlWriter(
				osw, "UTF-8");
		datasetWriter.setDocType("dataset.dtd");
		datasetWriter.write(dataset);

	}

}
