package customerSupportTicketSystemUsingQueueInterface;

public class Main {
	public static void main(String[] args) {
        SupportTicketSystem supportSystem = new SupportTicketSystem();
        supportSystem.addTicket("Issue with login");
        supportSystem.addTicket("Cannot reset password");
        supportSystem.displayPendingTickets();
        
        supportSystem.processNextTicket();
        supportSystem.displayPendingTickets();
    }
}
