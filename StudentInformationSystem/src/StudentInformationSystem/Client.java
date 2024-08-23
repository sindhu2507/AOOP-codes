package StudentInformationSystem;

public class Client {

	public static void main(String[] args) {
		
		Student student1 = new Student("Alice", "S001");
        Student student2 = new AdvancedStudent("Bob", "S002", 3.8);

        
        Course course1 = new Course("C001", "Mathematics");
        Course course2 = new Course("C002", "Physics");

       
        EnrollmentService enrollmentService = new SimpleEnrollmentService();

       
        enrollmentService.enroll(student1, course1);
        enrollmentService.enroll(student2, course2);

        
        for (Course course : student1.getCourses()) {
            System.out.println(student1.getName() + " is enrolled in " + course.getCourseName());
        }

       
        for (Student student : course2.getStudents()) {
            System.out.println(student.getName() + " is enrolled in " + course2.getCourseName());
        }

	}

}
