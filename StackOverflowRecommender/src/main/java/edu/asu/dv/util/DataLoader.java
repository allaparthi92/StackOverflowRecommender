package edu.asu.dv.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;

import edu.asu.dv.exception.DataLoadException;
import edu.asu.dv.model.Recommendation;
import edu.asu.dv.model.User;

public interface DataLoader {

	/**
	 * This method will load User data from a file
	 * 
	 * @return list of {@link User} object
	 * @throws DataLoadException
	 * @throws IOException
	 */
	HashMap<String, ArrayList<User>> loadUserData() throws DataLoadException,
			IOException;

	HashMap<String, LinkedHashSet<Recommendation>> loadCourseData()
			throws DataLoadException, IOException;
	
	HashMap<String, String> loadNodesWeight()
			throws DataLoadException, IOException;

}
