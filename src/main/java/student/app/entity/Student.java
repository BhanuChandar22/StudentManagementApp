package student.app.entity;

public class Student {
	private Integer id;
	private String fname;
	private String lname;
	private String email;
	private String dob;
	private String course;

	public Student() {
		super();
	}
	public Student(Integer id, String fname, String lname, String email, String dob, String course) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.dob = dob;
		this.course = course;
	}
	public Student(String fname, String lname, String email, String dob, String course) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.dob = dob;
		this.course = course;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
}
