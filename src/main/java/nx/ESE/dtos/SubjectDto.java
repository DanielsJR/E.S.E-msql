package nx.ESE.dtos;


import nx.ESE.entities.User;
import nx.ESE.entities.core.Course;
import nx.ESE.entities.core.Subject;
import nx.ESE.entities.core.SubjectName;

public class SubjectDto {
	
	private String id;

	private SubjectName name;

	private User teacher;

	private Course course;
	
	

	public SubjectDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public SubjectDto(String id, SubjectName name, User teacher, Course course) {
		super();
		this.id = id;
		this.name = name;
		this.teacher = teacher;
		this.course = course;
	}


	public SubjectDto(Subject subject) {
		this.id = subject.getId();
		this.name = subject.getName();
		this.teacher = subject.getTeacher();
		this.course = subject.getCourse();
	}


	public SubjectName getName() {
		return name;
	}

	public void setName(SubjectName name) {
		this.name = name;
	}

	public User getTeacher() {
		return teacher;
	}

	public void setTeacher(User teacher) {
		this.teacher = teacher;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public String getId() {
		return id;
	}
	
	

}
