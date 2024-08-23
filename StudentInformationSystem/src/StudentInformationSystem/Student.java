package StudentInformationSystem;
import java.util.ArrayList;
import java.util.List;
public class Student {
	private String name;
    private String studentID;
    private List<Course> courses = new ArrayList<>();

    public Student(String name, String studentID) {
        this.name = name;
        this.studentID = studentID;
    }

    public String getName() {
        return name;
    }

    public String getStudentID() {
        return studentID;
    }

    public void enrollInCourse(Course course) {
        courses.add(course);
        course.addStudent(this);
    }

    public List<Course> getCourses() {
        return courses;
    }
}
