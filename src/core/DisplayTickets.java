package core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import model.Ticket;

/**
 * This is controller class for the display logic on console.
 * 
 * @author Nikhil Deore
 *
 */
public class DisplayTickets {

	ConsolePrint print = new ConsolePrint();

	// Display all the tickets from the HashMap, 10 tickets at a time.
	public void displayAllTickets(HashMap<Long, Ticket> ticketMap, Scanner scanner) {

		ArrayList<Ticket> ticketsList = new ArrayList<>(ticketMap.values());
		int input = 1;
		if (ticketsList.size() < 10) {
			print.displayTicketHeader();

			for (Ticket ticket : ticketsList) {
				print.displayTicket(ticket);
			}
		} else {
			int counter = 0;
			int pageLimit = 10;
			boolean flag = true;
			while (counter < ticketsList.size() && input == 1) {
				if (flag) {
					print.displayTicketHeader();
					flag = false;
				}
				print.displayTicket(ticketsList.get(counter));
				counter++;

				if (ticketsList.size() - counter == 0) {
					print.displayMessageForEndOfTickets();
				}
				if (counter > pageLimit) {
					print.displayMessageForNextTicket();
					input = scanner.nextInt();
					pageLimit = pageLimit + 10;
					flag = true;
				}
			}
		}
	}

	// Display ticket with the user input field ID as a key.
	public void displayTicketById(HashMap<Long, Ticket> ticketMap, Long key) {

		if (ticketMap.containsKey(key)) {
			print.displayTicketHeader();
			print.displayTicket(ticketMap.get(key));
		} else {
			print.displayMessageForIdNotFound();
		}
	}

}
