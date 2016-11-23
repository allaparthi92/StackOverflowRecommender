package orga.bhanu.model;

import java.util.Date;

public class Profile {
	
	private long id;
	private String Profilename;
	private String firstName;
	private String lastName;
	
	public Profile(){
		
	}
	
	public Profile(long id, String profilename, String firstName,
			String lastName) {
		super();
		this.id = id;
		Profilename = profilename;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getProfilename() {
		return Profilename;
	}
	public void setProfilename(String profilename) {
		Profilename = profilename;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	private Date created;
	
	
	
}
