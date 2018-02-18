package core;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Base64;

public class UserAuthentication {

	private String subdomain;
	private String username;
	private String password;
	private TicketParser parser = new TicketParser();

	public TicketParser getParser() {
		return parser;
	}

	public String getSubdomain() {
		return subdomain;
	}

	public void setSubdomain(String subdomain) {
		this.subdomain = subdomain;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Login using the GET API request with Basic Authentication to Zendesk account
	 * and get all the Tickets in JSON Array String pass it to TicketParser class to
	 * populate the Ticket(POJO) classes.
	 * 
	 * @param
	 * @author Nikhil Deore
	 * @version 1.0
	 * @exception MalformedURLException,
	 *                IOException
	 * @date 2018-02-16
	 */
	public boolean login() {
		try {
			URL url = new URL("https://" + subdomain + ".zendesk.com/api/v2/tickets.json");

			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Accept", "application/json");

			String authString = "" + username + ":" + password + "";
			String authStringEnc = new String(Base64.getEncoder().encodeToString(authString.getBytes()));
			connection.setRequestProperty("Authorization", "Basic " + authStringEnc);

			if (connection.getResponseCode() != 200) {
				System.out.println("Unable to connect to the subdomain HTTP Error Code : " + connection.getResponseCode());
				return false;
			} else {

				// Sending the received InputStream to TicketParser to parse and populate the
				// Ticket class.
				parser.ticketDataParser(connection.getInputStream());
			}

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;
	}

}
