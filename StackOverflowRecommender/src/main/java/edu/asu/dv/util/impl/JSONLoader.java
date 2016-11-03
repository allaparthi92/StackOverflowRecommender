package edu.asu.dv.util.impl;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import edu.asu.dv.exception.DataLoadException;
import edu.asu.dv.model.User;
import edu.asu.dv.util.DataLoader;

public class JSONLoader implements DataLoader {

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<User> loadUserData() throws DataLoadException {
		
		ArrayList<User> userList = new ArrayList<User>();
		ObjectMapper mapper1 = new ObjectMapper();
		URL url = ClassLoader.getSystemResource("");
		File folder = new File(url.getPath());
		File[] listOfFiles = folder.listFiles();

		for (int i = 0; i < listOfFiles.length-1; i++) {
			if (listOfFiles[i].isFile()) {
				try {
					List<User> list = mapper1.readValue(new File(ClassLoader
							.getSystemResource(listOfFiles[i].getName())
							.getPath()), ArrayList.class);
					userList.addAll(list);

				} catch (IOException e) {
					throw new DataLoadException(e);

				}
			}
		}

		return userList;
	}

	public static void main(String[] args) throws DataLoadException {
		JSONLoader loader = new JSONLoader();
		ArrayList<User> list = loader.loadUserData();
		HashMap<String,ArrayList<User>>  userMap = new HashMap<String,ArrayList<User>>();
		for(User user : list){
			if(userMap.containsKey(user.getUserId())){
				userMap.get(user.getUserId()).add(user);
			}
			else{
				ArrayList<User> userlist = new ArrayList<User>();
				userlist.add(user);
				userMap.put(user.getUserId(), userlist);
			}
		}
	}

}