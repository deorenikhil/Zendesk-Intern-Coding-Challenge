/**
 * 
 */
package test;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

import org.junit.Test;

import core.TicketParser;
import model.Ticket;

/**
 * TicketParserTest class tests from InputStream of response to creation of
 * Ticket Objects into ticketHashMap
 *
 * @author Nikhil Deore
 * @version 1.0
 * @date 2018-02-16
 */
public class TicketParserTest {

	TicketParser parser = new TicketParser();

	@Test
	public void ticketDataParserTest() {
		Ticket ticket = new Ticket();
		ticket.setId(new Long(100));
		ticket.setSubject("Test Ticket");

		HashMap<Long, Ticket> hashMap = new HashMap<>();
		hashMap.put(new Long(100), ticket);

		String exampleString = new String(
				"{ \"tickets\": [{ \"url\": \"https://nikhil1991.zendesk.com/api/v2/tickets/1.json\", \"id\": 1, \"external_id\": null, \"via\": { \"channel\": \"sample_ticket\", \"source\": { \"from\": {}, \"to\": {}, \"rel\": null } }, \"created_at\": \"2018-02-16T04:32:02Z\", \"updated_at\": \"2018-02-16T04:32:04Z\", \"type\": \"incident\", \"subject\": \"Sample ticket: Meet the ticket\", \"raw_subject\": \"Sample ticket: Meet the ticket\", \"description\": \"Hi deorenik,\\n\\nEmails, chats, voicemails, and tweets are captured in Zendesk Support as tickets. Start typing above to respond and click Submit to send. To test how an email becomes a ticket, send a message to support@nikhil1991.zendesk.com.\\n\\nCurious about what your customers will see when you reply? Check out this video:\\nhttps://demos.zendesk.com/hc/en-us/articles/202341799\\n\", \"priority\": \"normal\", \"status\": \"open\", \"recipient\": null, \"requester_id\": 360556155514, \"submitter_id\": 360553213333, \"assignee_id\": 360553213333, \"organization_id\": null, \"group_id\": 360000243673, \"collaborator_ids\": [], \"follower_ids\": [], \"forum_topic_id\": null, \"problem_id\": null, \"has_incidents\": false, \"is_public\": true, \"due_at\": null, \"tags\": [\"sample\", \"support\", \"zendesk\"], \"custom_fields\": [], \"satisfaction_rating\": null, \"sharing_agreement_ids\": [], \"fields\": [], \"followup_ids\": [], \"brand_id\": 360000169013, \"allow_channelback\": false }] }");
		InputStream stream = new ByteArrayInputStream(exampleString.getBytes(StandardCharsets.UTF_8));
		parser.ticketDataParser(stream);
		assertEquals(1, parser.getTicketsHashMap().get(new Long(1)).getId());

	}

}
