package hackathon;

import java.sql.Date;

public class User {
    private String name;
    private static String username;
    private String phoneNumber;
    private Date dob; // Assuming you want to use java.sql.Date
    private String gender;
    private String gmail;
    private String address;

    // No-argument constructor
    public User() {
    }

    // Constructor with parameters (if needed)
    public User(String name, String username, String phoneNumber, Date dob, String gender, String gmail, String address) {
        this.name = name;
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.dob = dob;
        this.gender = gender;
        this.gmail = gmail;
        this.address = address;
    }
    
    private String profilePicPath; 

    // Getter for profilePicPath
    public String getProfilePicPath() {
        return profilePicPath;
    }

    // Setter for profilePicPath
    public void setProfilePicPath(String profilePicPath) {
        this.profilePicPath = profilePicPath;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

	public void setId(int int1) {
		// TODO Auto-generated method stub
		
	}
}
