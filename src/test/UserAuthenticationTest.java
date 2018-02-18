/**
 * 
 */
package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import core.UserAuthentication;

/**
 * 
 * Testing the login method to call the GET Tickets API
 * 
 * @author Nikhil Deore
 * @version 1.0
 * @date 2018-02-16
 */
public class UserAuthenticationTest {
	@Test
	public void loginWithWrongCredentialsTest() {
		UserAuthentication authentication = new UserAuthentication();
		authentication.setSubdomain("subdomain");
		authentication.setUsername("email");
		authentication.setPassword("password");
		assertEquals(false, authentication.login());
	}

	@Test
	public void loginTest() {
		UserAuthentication authentication = new UserAuthentication();
		authentication.setSubdomain("subdomain");
		authentication.setUsername("email");
		authentication.setPassword("password");
		assertEquals(false, authentication.login());
	}
}
