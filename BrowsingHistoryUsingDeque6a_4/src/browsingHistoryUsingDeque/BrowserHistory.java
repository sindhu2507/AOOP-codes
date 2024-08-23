package browsingHistoryUsingDeque;
import java.util.ArrayDeque;
import java.util.Deque;
public class BrowserHistory {
	private Deque<String> history = new ArrayDeque<>();
    private Deque<String> forwardStack = new ArrayDeque<>();

    public void visitPage(String url) {
        history.push(url);
        forwardStack.clear();
        System.out.println("Visited: " + url);
    }

    public void goBack() {
        if (history.size() > 1) {
            forwardStack.push(history.pop());
            System.out.println("Went back to: " + history.peek());
        } else {
            System.out.println("No previous page.");
        }
    }

    public void goForward() {
        if (!forwardStack.isEmpty()) {
            history.push(forwardStack.pop());
            System.out.println("Went forward to: " + history.peek());
        } else {
            System.out.println("No forward page.");
        }
    }

    public void displayCurrentPage() {
        if (!history.isEmpty()) {
            System.out.println("Current page: " + history.peek());
        } else {
            System.out.println("No pages in history.");
        }
    }
}
