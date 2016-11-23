package KaratIntuit;

public class Employee {
	
	private int employee_id;
	
	private String name;
	
	private String department;
	
	public Employee(){
		
	}
	
	public Employee(int employee_id, String name, String department) {
		super();
		this.employee_id = employee_id;
		this.name = name;
		this.department = department;
	}

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
	

}
