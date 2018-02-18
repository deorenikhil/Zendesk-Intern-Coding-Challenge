package core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONObject;

import model.Source;
import model.Ticket;
import model.Via;

public class TicketParser {

	private HashMap<Long, Ticket> ticketsHashMap = new HashMap<>();
	StringBuilder responseString;

	/**
	 * Takes the argument as InputStream from the GET API call to parse the String
	 * into Ticket Object
	 *
	 * @author Nikhil Deore
	 * @version 1.0
	 * @date 2018-02-16
	 */
	public void ticketDataParser(InputStream responseStream) {
		BufferedReader responseTicketStream = new BufferedReader(new InputStreamReader((responseStream)));
		String stringToAppend;
		responseString = new StringBuilder();

		try {
			while ((stringToAppend = responseTicketStream.readLine()) != null) {
				responseString.append(stringToAppend);
			}

			responseTicketStream.close();
			this.saveTicketsJsonString();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * saving the Array of Ticket JSON Objects as HashMap of Tickets object.
	 * 
	 * @author Nikhil Deore
	 * @version 1.0
	 * @date 2018-02-16
	 */
	public void saveTicketsJsonString() {

		JSONObject mainObject = new JSONObject(responseString.toString());
		JSONArray arrayOfTickets = mainObject.getJSONArray("tickets");

		for (int i = 0; i < arrayOfTickets.length(); i++) {
			JSONObject ticketJson = arrayOfTickets.getJSONObject(i);
			long id = ticketJson.optLong("id");
			Ticket ticket = this.convertToTicketObject(ticketJson);
			getTicketsHashMap().put(id, ticket);
		}
	}

	/**
	 * Populates the Ticket Object with JSON data.
	 *
	 * @author Nikhil Deore
	 * @version 1.0
	 * @date 2018-02-16
	 */
	private Ticket convertToTicketObject(JSONObject ticketJson) {

		Ticket ticket = new Ticket();

		ticket.setUrl(ticketJson.optString("url"));
		ticket.setId(ticketJson.optLong("id"));
		ticket.setExternal_id(ticketJson.optString("external_id"));

		Via via = new Via();
		JSONObject viaJsonObject = ticketJson.getJSONObject("via");
		via.setChannel(viaJsonObject.optString("channel"));

		Source source = new Source();
		JSONObject sourceObject = viaJsonObject.getJSONObject("source");
		source.setRel(sourceObject.optString("rel"));
		via.setSource(source);

		ticket.setVia(via);
		ticket.setCreated_at(ticketJson.optString("created_at"));
		ticket.setUpdated_at(ticketJson.optString("updated_at"));
		ticket.setType(ticketJson.optString("type"));
		ticket.setSubject(ticketJson.optString("subject"));
		ticket.setRaw_subject(ticketJson.optString("raw_subject"));
		ticket.setDescription(ticketJson.optString("description"));
		ticket.setPriority(ticketJson.optString("priority"));
		ticket.setStatus(ticketJson.optString("status"));
		ticket.setRecipient(ticketJson.optString("recipient"));
		ticket.setRequester_id(ticketJson.getLong("requester_id"));
		ticket.setSubmitter_id(ticketJson.optLong("submitter_id"));
		ticket.setAssignee_id(ticketJson.optLong("assignee_id"));
		ticket.setOrganization_id(ticketJson.optLong("organization_id"));
		ticket.setGroup_id(ticketJson.optLong("group_id"));
		ticket.setCollaborator_id(getArrayListInt(ticketJson, "collaborator_ids"));
		ticket.setFollower_ids(getArrayListInt(ticketJson, "follower_ids"));
		ticket.setForum_topic_id(ticketJson.optLong("forum_topic_id"));
		ticket.setProblem_id(ticketJson.optLong("problem_id"));
		ticket.setHas_incidents(ticketJson.optBoolean("has_incidents"));
		ticket.setIs_public(ticketJson.optBoolean("is_public"));
		ticket.setDue_at(ticketJson.optString("due_at"));
		ticket.setTags(getArrayListString(ticketJson, "tags"));
		ticket.setCustom_fields(getArrayListString(ticketJson, "custom_fields"));
		ticket.setSatisfaction_rating(ticketJson.optString("satisfaction_rating"));
		ticket.setSharing_agreement_ids(getArrayListInt(ticketJson, "sharing_agreement_ids"));
		ticket.setFields(getArrayListString(ticketJson, "fields"));
		ticket.setFollowup_ids(getArrayListInt(ticketJson, "followup_ids"));
		ticket.setBrand_id(ticketJson.optLong("brand_id"));
		ticket.setAllow_channelback(ticketJson.optBoolean("allow_channelback"));

		return ticket;
	}

	/**
	 * Method to parse JSON object as ArrayList of integers.
	 *
	 * @author Nikhil Deore
	 * @version 1.0
	 * @date 2018-02-16
	 */
	private ArrayList<Integer> getArrayListInt(JSONObject ticketJson, String key) {
		JSONArray arrayValues = ticketJson.getJSONArray(key);
		ArrayList<Integer> list = new ArrayList<>();

		for (int i = 0; i < arrayValues.length(); i++) {
			list.add(Integer.parseInt(arrayValues.get(i).toString()));
		}

		return list;
	}

	/**
	 * Method to parse JSON object as ArrayList of Strings.
	 *
	 * @author Nikhil Deore
	 * @version 1.0
	 * @date 2018-02-16
	 */
	private ArrayList<String> getArrayListString(JSONObject ticketJson, String key) {
		JSONArray arrayValues = ticketJson.getJSONArray(key);
		ArrayList<String> list = new ArrayList<>();

		for (int i = 0; i < arrayValues.length(); i++) {
			list.add(arrayValues.get(i).toString());
		}

		return list;
	}

	/**
	 * @return the ticketsHashMap
	 */
	public HashMap<Long, Ticket> getTicketsHashMap() {
		return ticketsHashMap;
	}

	/**
	 * @param ticketsHashMap
	 *            the ticketsHashMap to set
	 */
	public void setTicketsHashMap(HashMap<Long, Ticket> ticketsHashMap) {
		this.ticketsHashMap = ticketsHashMap;
	}

}
