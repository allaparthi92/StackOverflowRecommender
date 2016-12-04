package edu.asu.dv.datascrape;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import edu.asu.dv.model.Recommendation;
import edu.asu.dv.model.RecommendationJson;

public class CourseParser {

	static HashMap<String, List<Recommendation>> map = new HashMap<String, List<Recommendation>>();
	static int i = 1;
	static List<RecommendationJson> recommendationJson = new ArrayList<>();

	public static void main(String[] args) throws JsonGenerationException,
			JsonMappingException, IOException {
		try {

			String[] arr = { ".net", "accessibility", "actionmailer",
					"actionscript-3", "activerecord", "akka", "algorithm",
					"amazon-s3", "android", "angularjs", "apache-spark", "api",
					"arrays", "asp.net", "asp.net-mvc", "asp.net-mvc-3",
					"asp.net-mvc-4", "bash", "boost", "browser", "c", "c#",
					"c++", "c++11", "ckeditor", "clearcase", "coldfusion",
					"collections", "computer-science", "cross-browser", "css",
					"css3", "csv", "cxf", "data-binding", "database", "date",
					"design-patterns", "devise", "dictionary", "django",
					"django-forms", "django-models", "django-views", "dll",
					"dvcs", "eclipse", "ef-code-first", "emacs",
					"entity-framework", "escaping", "excel", "excel-vba",
					"exception", "expression-blend", "extjs", "ffmpeg", "file",
					"firefox", "flash", "flex", "gcc", "git", "github",
					"graphics", "gwt", "h.264", "haskell", "header", "heroku",
					"hibernate", "html", "html5", "http", "iis", "image",
					"intellij-idea", "ios", "iphone", "java", "java-8",
					"java-ee", "java-stream", "javascript",
					"javascript-events", "jaxb", "jersey", "jpa", "jqgrid",
					"jquery", "jquery-plugins", "jquery-ui", "jsf", "json",
					"junit", "liferay", "liferay-6", "linq", "linux", "log4j",
					"log4j2", "logging", "math", "maven", "maven-3", "mef",
					"mercurial", "mobile-website", "mongodb", "mongoose",
					"ms-access", "multithreading", "mvvm", "mysql",
					"nhibernate", "node.js", "objective-c", "oop", "opencv",
					"opengl", "paperclip", "parsing", "performance", "php",
					"plugins", "postgresql", "postgresql-9.1", "python",
					"razor", "regex", "reporting-services", "rest", "rspec",
					"rtc", "ruby", "ruby-on-rails", "ruby-on-rails-3", "scala",
					"screen-readers", "security", "semantic-markup",
					"silverlight", "soap", "spring", "spring-batch",
					"spring-boot", "spring-data-jpa", "spring-mvc", "sql",
					"sql-server", "sql-server-2005", "sql-server-2008",
					"sqlite", "stl", "string", "struts2", "styles", "svn",
					"syntax", "templates", "text", "tomcat", "tsql", "unix",
					"url", "user-interface", "vaadin", "validation", "vb.net",
					"vba", "vector", "video", "vim", "visual-studio",
					"visual-studio-2008", "visual-studio-2010",
					"visual-studio-2012", "w3c", "wcf", "web-services",
					"web-standards", "winapi", "windows", "winforms",
					"wordpress", "wpf", "xaml", "xhtml", "xml" };
			String[] arr1 = { "java" };
			for (String tag : arr1) {
				RecommendationJson json = new RecommendationJson();
				json.setName(tag);

				List<Recommendation> list = new ArrayList<Recommendation>();
				getCourses(tag, "udacity", list);
				getCourses(tag, "udemy", list);
				getCourses(tag, "coursera", list);
				if (list.size() == 6) {
					list.remove(list.size() - 1);
				}

				json.setRecommendations(list);
				map.put(tag, list);
				recommendationJson.add(json);
			}
			System.out.println(map);
			ObjectMapper mapper = new ObjectMapper();

			// Object to JSON in file
			mapper.writerWithDefaultPrettyPrinter().writeValue(
					new File("filepretty.json"), recommendationJson);
			mapper.writeValue(new File("file.json"), recommendationJson);

		} catch (Exception e) {
			System.out.println(map);
			ObjectMapper mapper = new ObjectMapper();

			// Object to JSON in file
			mapper.writerWithDefaultPrettyPrinter().writeValue(
					new File("filepretty.json"), recommendationJson);
			mapper.writeValue(new File("file.json"), recommendationJson);

		}

	}

	public static void getCourses(String tag, String website,
			List<Recommendation> list) {

		System.setProperty("webdriver.chrome.driver",
				"F:\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("http://www.google.com");

		driver.switchTo().defaultContent();

		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys(tag + " " + website); // send also a "\n"
		element.submit();

		// wait until the google page shows the result
		(new WebDriverWait(driver, 10)).until(ExpectedConditions
				.presenceOfElementLocated(By.id("resultStats")));

		List<WebElement> findElements = driver.findElements(By
				.xpath("//*[@id='rso']//h3/a"));

		List<String> URLsList = new ArrayList<String>();

		// this are all the links you like to visit
		for (WebElement webElement : findElements) {
			String x = webElement.getAttribute("href");
			URLsList.add(x);
		}

		for (int j = 0; j < 2; j++) {
			String x = URLsList.get(j);
			if (!x.contains("?")) {
				driver.get(x);
				System.out.println(x);
				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				driver.switchTo().defaultContent();
				Recommendation recommendation = new Recommendation();
				recommendation.setId(String.valueOf(i++));

				if (driver.getTitle().contains("Specialization | Coursera")) {
					recommendation.setName("java " + driver.getTitle());
				} else {
					recommendation.setName(driver.getTitle());
				}
				recommendation.setPreviewLink(x);
				list.add(recommendation);
			}
		}
		driver.close();
	}

}
