package customerSupportTicketSystemUsingQueueInterface;
import java.util.LinkedList;
import java.util.Queue;
public class SupportTicketSystem {
	private Queue<String> ticketQueue = new LinkedList<>();

    public void addTicket(String ticket) {
        ticketQueue.add(ticket);
    }

    public void processNextTicket() {
        if (!ticketQueue.isEmpty()) {
            System.out.println("Processing ticket: " + ticketQueue.poll());
        } else {
            System.out.println("No tickets to process.");
        }
    }

    public void displayPendingTickets() {
        System.out.println("Pending tickets:");
        for (String ticket : ticketQueue) {
            System.out.println(ticket);
        }
    }
}
