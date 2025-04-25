package mylab.student.di.xml;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

import javax.annotation.Resource;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:mylab-student-di.xml")
public class StudentSpringTest {
	@Autowired
	Course course;
	
	@Resource(name = "gradeService")
	GradeService service;
	
	@Test
	void testService() {
		assertNotNull(service);
		assertEquals("C001", service.getCourse().getCourseId());
		assertEquals("A", service.calculateGrade("S001"));
		assertEquals(2, service.getHighScoreStudents(80).size());
		
		for(Student student: service.getHighScoreStudents(80)) {
			System.out.println(student);
		}
	}
	
	@Test
	void testCourse() {
		assertNotNull(course);
		assertEquals("Java Programming", course.getCourseName());
		assertEquals(3, course.getStudents().size());
		/*
		 * course.getStudent() : List<Student> 타입
		 * course.getStudent().get(0) : Student 타입
		 * course.getStudent().get(0).getName() : String 타입
		 */
		assertEquals("엠마", course.getStudents().get(0).getName());
		
		//System.out.println(course.getAverageScore());
		assertEquals(83.333, course.getAverageScore(), 0.001);
	}

}
