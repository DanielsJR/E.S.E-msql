package nx.ESE.repositories;



import org.springframework.data.jpa.repository.JpaRepository;

import nx.ESE.entities.core.Course;



public interface CourseRepository extends JpaRepository<Course, String> {
	
	public Course findByName(String name);
	
	public Course findByChiefTeacher(String teacher);
	
	//@Query()
	//public List<CourseDto> findCoursesFullAll();
	
	//public List<CourseDto> findByPeriodGreaterThan(Date date);
	
	
	

}
