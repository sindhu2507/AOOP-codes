package RideSharingApplication;

public class UserAuth {
	private static UserAuth instance;
    private boolean isLoggedIn = false;

    private UserAuth() {}

    public static UserAuth getInstance() {
        if (instance == null) instance = new UserAuth();
        return instance;
    }

    public void login() { isLoggedIn = true; System.out.println("User logged in."); }
    public void logout() { isLoggedIn = false; System.out.println("User logged out."); }
    public boolean isLoggedIn() { return isLoggedIn; }
}
