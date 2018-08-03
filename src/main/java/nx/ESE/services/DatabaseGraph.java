package nx.ESE.services;

import java.util.List;

import nx.ESE.entities.Preferences;
import nx.ESE.entities.User;
import nx.ESE.entities.core.Course;
import nx.ESE.entities.core.Subject;

public class DatabaseGraph {

	private List<User> userList;

	private List<Preferences> preferencesList;

	private List<Course> coursesList;

	private List<Subject> subjectsList;

	public DatabaseGraph() {
		// Empty for framework
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public List<Preferences> getPreferencesList() {
		return preferencesList;
	}

	public void setPreferencesList(List<Preferences> preferencesList) {
		this.preferencesList = preferencesList;
	}

	public List<Course> getCoursesList() {
		return coursesList;
	}

	public void setCoursesList(List<Course> coursesList) {
		this.coursesList = coursesList;
	}

	public List<Subject> getSubjectsList() {
		return subjectsList;
	}

	public void setSubjectsList(List<Subject> subjectsList) {
		this.subjectsList = subjectsList;
	}

}
