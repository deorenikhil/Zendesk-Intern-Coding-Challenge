/**
 * 
 */
package test;

import static org.junit.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.junit.Test;

/**
 * @author niksMachine
 *
 */
public class UserAuthenticationTest {
	@Test
	public void loginTest() {

		Properties prop = new Properties();
		InputStream input = null;
		try {
			input = new FileInputStream(".././test.resources/config.properties");

			prop.load(input);
			System.out.println(prop.getProperty("subdomain"));
			assertEquals(10, 10);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// input = new FileInputStream("config.properties");

	}
}
