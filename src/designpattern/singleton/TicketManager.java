package designpattern.singleton;

public class TicketManager {
	private static TicketManager instance;
	static int count;

	private TicketManager() { // private constructor
		count = 0;
	}

	public static TicketManager getInstance() {
		if (instance == null) {
			instance = new TicketManager();
		}
		return instance;
	}

	public Ticket sellTicket() {
		return new Ticket(count++);
	}
}