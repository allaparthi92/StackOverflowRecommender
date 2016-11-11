package edu.asu.dv.service;

import java.util.List;

import edu.asu.dv.exception.DataLoadException;

public interface UserSimilarityService {
	List<String> getSimilarUsers(String userid) throws DataLoadException;
}
