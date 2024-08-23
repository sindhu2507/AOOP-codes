package browsingHistoryUsingDeque;

public class Main {
	public static void main(String[] args) {
        BrowserHistory browserHistory = new BrowserHistory();
        browserHistory.visitPage("example.com");
        browserHistory.visitPage("example.org");
        browserHistory.displayCurrentPage();
        
        browserHistory.goBack();
        browserHistory.goForward();
        browserHistory.displayCurrentPage();
    }
}
