
import java.util.Scanner;

import core.ConsolePrint;
import core.DisplayTickets;
import core.UserAuthentication;

public class Master {

	/**
	 * Main Method : entry point of the program.
	 * 
	 * @param
	 * @author Nikhil Deore
	 * @version 1.0
	 * @date 2018-02-16
	 */
	public static void main(String[] args) {

		// Authentication class to make REST API call with basic authorization.
		UserAuthentication auth = new UserAuthentication();

		// ConsolePrint contains all the console output messages.
		ConsolePrint printer = new ConsolePrint();
		Scanner scanner = new Scanner(System.in);

		// DisplayTickets contains controller logic for the UI.
		DisplayTickets displayTickets = new DisplayTickets();

		boolean exit = false;

		printer.displaySubdomainMenu();
		auth.setSubdomain(scanner.nextLine());

		printer.displayUsernameMenu();
		auth.setUsername(scanner.nextLine());

		printer.displayPasswordMenu();
		auth.setPassword(scanner.nextLine());

		if (!auth.login()) {
			printer.displayInvalidLogin();

		} else {
			while (!exit) {

				printer.displayMainMenu();

				switch (scanner.nextInt()) {
				case 1:
					// Display all the tickets in HashMap.
					displayTickets.displayAllTickets(auth.getParser().getTicketsHashMap(), scanner);
					break;
				case 2:
					printer.displayMessageForIdInput();
					Long id = scanner.nextLong();

					// Search the Ticket for the ID in HashMap and Display.
					displayTickets.displayTicketById(auth.getParser().getTicketsHashMap(), id);
					break;
				case 3:
					// Exit the application.
					printer.displayThankYou();
					scanner.close();
					exit = true;
					break;
				default:
					// message for wrong input.
					printer.displayMessageForWrongInput();
					break;
				}

			}
		}

	}
}
