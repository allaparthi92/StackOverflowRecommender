package edu.asu.dv.service;

import java.util.List;

import edu.asu.dv.exception.DataLoadException;
import edu.asu.dv.model.response.DetailMap;

public interface UserSimilarityService {
	List<DetailMap> getSimilarUsers(String userid) throws DataLoadException;

	List<DetailMap> getUserTags(String userName);
}
