package StudentInformationSystem;

public class SimpleEnrollmentService implements EnrollmentService{
	@Override
    public void enroll(Student student, Course course) {
        student.enrollInCourse(course);
        System.out.println("Enrolled " + student.getName() + " in " + course.getCourseName());
    }
}
