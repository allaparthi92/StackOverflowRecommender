package edu.asu.dv.util;

import java.util.HashMap;
import java.util.List;

import edu.asu.dv.exception.DataLoadException;
import edu.asu.dv.model.User;

public interface DataLoader {

	/**
	 * This method will load User data from a file
	 * 
	 * @return  list of {@link User} object
	 * @throws DataLoadException
	 */
	List<User> loadUserData() throws DataLoadException;
	
}
