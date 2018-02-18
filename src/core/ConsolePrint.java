package core;

import model.Ticket;

public class ConsolePrint {

	public void displaySubdomainMenu() {
		System.out.println("\t Welcome to Ticket Viewer Application");
		System.out.print("\n Please Enter Subdomain : ");
	}

	public void displayUsernameMenu() {
		System.out.print("\n Please Enter the E-mail : ");
	}

	public void displayPasswordMenu() {
		System.out.print("\n Please Enter the password : ");
	}

	public void displayMainMenu() {
		System.out.println("\n\t Zendesk Ticket Viewing Application");
		System.out.println("\t 1. View All Tickets");
		System.out.println("\t 2. Search Ticket by ID");
		System.out.println("\t 3. exit");
		System.out.print("\n\nPlease Enter the number from the Menu : ");
	}

	public void displayTicketHeader() {
		System.out.format("\n%-4s| %-50s | %-4s | %s", "ID", "SUBJECT", "STATUS", "GROUP ID");
		System.out.println("\n--------------------------------------------------------------------------------");
	}

	public void displayTicket(Ticket ticket) {

		long id = ticket.getId();
		String subject = ticket.getSubject();
		String status = ticket.getStatus().toUpperCase();
		long groupId = ticket.getGroup_id();
		System.out.format("%-4d| %-50s |  %-5s | %d\n", id, subject, status, groupId);
	}

	public void displayMessageForIdInput() {
		System.out.print("\n Please Enter The ID for the Ticket :  ");
	}

	public void displayMessageForIdNotFound() {
		System.out.println("Ticket ID not found in the account");
	}

	public void displayMessageForNextTicket() {
		System.out.print("\n\n For more tickets enter 1 to exit press 2 : ");
	}

	public void displayMessageForWrongInput() {
		System.out.println("Invalid Input");
	}

	public void displayThankYou() {
		System.out.println("Exiting the application, Thank You !");
	}

	public void displayInvalidLogin() {
		System.out.println("Please re-run the application with correct information");
	}

	public void displayMessageForEndOfTickets() {
		System.out.println("\n End of tickets for the account");
	}
}
