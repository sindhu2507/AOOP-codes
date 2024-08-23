package StudentInformationSystem;
import java.util.ArrayList;
import java.util.List;
public class Course {
	private String courseID;
    private String courseName;
    private List<Student> students = new ArrayList<>();

    public Course(String courseID, String courseName) {
        this.courseID = courseID;
        this.courseName = courseName;
    }

    public String getCourseID() {
        return courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public List<Student> getStudents() {
        return students;
    }
}
