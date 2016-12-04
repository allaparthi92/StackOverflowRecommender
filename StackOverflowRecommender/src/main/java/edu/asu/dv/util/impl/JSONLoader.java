package edu.asu.dv.util.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import edu.asu.dv.exception.DataLoadException;
import edu.asu.dv.model.Course;
import edu.asu.dv.model.Recommendation;
import edu.asu.dv.model.User;
import edu.asu.dv.util.DataLoader;

@Service
public class JSONLoader implements DataLoader {

	@javax.annotation.Resource(name = "userNameProperties")
	private Map<String, String> properties;

	/**
	 * {@inheritDoc}
	 * 
	 * @throws IOException
	 */
	public HashMap<String, ArrayList<User>> loadUserData() throws DataLoadException, IOException {

		HashMap<String, ArrayList<User>> userMap = new HashMap<String, ArrayList<User>>();
		ObjectMapper mapper1 = new ObjectMapper();
		Resource resource = new ClassPathResource("data/");
		File folder = resource.getFile();
		File[] listOfFiles = folder.listFiles();

		for (int i = 0; i < listOfFiles.length - 1; i++) {
			if (listOfFiles[i].isFile()) {
				try {

					List<User> list = mapper1.readValue(
							new ClassPathResource("data/" + listOfFiles[i].getName()).getFile(),
							new TypeReference<List<User>>() {
							});
					for (User user : list) {
						user.setUser_name(properties.get(user.getUser_id()));
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

	public HashMap<String, String> loadNodesWeight() throws DataLoadException, IOException {

		HashMap<String, String> nodeMap = new HashMap<String, String>();
		ObjectMapper mapper1 = new ObjectMapper();
		Resource resource = new ClassPathResource("data/");
		File folder = resource.getFile();
		File[] listOfFiles = folder.listFiles();

		for (int i = 0; i < listOfFiles.length - 1; i++) {
			if (listOfFiles[i].isFile()) {
				try {

					List<User> list = mapper1.readValue(
							new ClassPathResource("data/" + listOfFiles[i].getName()).getFile(),
							new TypeReference<List<User>>() {
							});
					for (User user : list) {

						if (nodeMap.containsKey(user.getUser_id())) {
							int sum = 0;
							String x = nodeMap.get(user.getUser_id());
							sum = Integer.valueOf(x) + Integer.valueOf(user.getQuestion_count());
							nodeMap.put(user.getUser_id(), String.valueOf(sum));
						} else {

							nodeMap.put(user.getUser_id(), String.valueOf(user.getQuestion_count()));
						}
					}

				} catch (IOException e) {
					throw new DataLoadException(e);

				}
			}
		}

		return nodeMap;
	}

	@SuppressWarnings("unchecked")
	public HashMap<String, LinkedHashSet<Recommendation>> loadCourseData() throws DataLoadException, IOException {

		HashMap<String, LinkedHashSet<Recommendation>> CourseTagMap = new HashMap<String, LinkedHashSet<Recommendation>>();
		ObjectMapper mapper1 = new ObjectMapper();
		Resource resource = new ClassPathResource("mapping/Courses.json");
		File file = resource.getFile();

		try {

			List<Course> list = mapper1.readValue(file, new TypeReference<List<Course>>() {
			});
			for (Course course : list) {
				CourseTagMap.put(course.getName(), (LinkedHashSet<Recommendation>) course.getRecommendations());
			}

		} catch (IOException e) {
			throw new DataLoadException(e);

		}
		System.out.println(CourseTagMap);
		return CourseTagMap;

	}

	// @Override
	// public HashMap<String, String> loadUserName() throws DataLoadException,
	// IOException {
	// HashMap<String, String> userNameMap = new HashMap<String, String>();
	// Resource resource = new ClassPathResource("mapping/userNames.txt");
	// File folder = resource.getFile();
	// try (Scanner scanner = new Scanner(folder)) {
	// while (scanner.hasNextLine()) {
	// String line = scanner.nextLine();
	// String[] userNameArray = line.split(",");
	// userNameMap.put(userNameArray[0], userNameArray[1]);
	// }
	// scanner.close();
	// }
	// return userNameMap;
	// }

}