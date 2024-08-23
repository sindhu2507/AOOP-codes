package StudentInformationSystem;

public class AdvancedStudent extends Student{
	private double gpa;

    public AdvancedStudent(String name, String studentID, double gpa) {
        super(name, studentID);
        this.gpa = gpa;
    }

    public double getGPA() {
        return gpa;
    }

}
