package edu.asu.dv.util.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import edu.asu.dv.exception.DataLoadException;
import edu.asu.dv.model.User;
import edu.asu.dv.util.DataLoader;

@Service
public class JSONLoader implements DataLoader {

	/**
	 * {@inheritDoc}
	 * 
	 * @throws IOException
	 */
	public HashMap<String, ArrayList<User>> loadUserData() throws DataLoadException, IOException {

		HashMap<String, ArrayList<User>> userMap = new HashMap<String, ArrayList<User>>();
		ObjectMapper mapper1 = new ObjectMapper();
		Resource resource = new ClassPathResource("");
		File folder = resource.getFile();
		File[] listOfFiles = folder.listFiles();

		for (int i = 0; i < listOfFiles.length - 1; i++) {
			if (listOfFiles[i].isFile()) {
				try {

					List<User> list = mapper1.readValue(new ClassPathResource(listOfFiles[i].getName()).getFile(),
							new TypeReference<List<User>>() {
							});
					for (User user : list) {
						if (userMap.containsKey(user.getUser_id())) {
							userMap.get(user.getUser_id()).add(user);
						} else {
							ArrayList<User> userlist = new ArrayList<User>();
							userlist.add(user);
							userMap.put(user.getUser_id(), userlist);
						}
					}

				} catch (IOException e) {
					throw new DataLoadException(e);

				}
			}
		}

		return userMap;
	}

}