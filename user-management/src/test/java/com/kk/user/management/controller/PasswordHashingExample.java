package com.kk.user.management.controller;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.LdapShaPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.util.DigestUtils;

/**
 * 
 * @author korayk
 *
 */
public class PasswordHashingExample {

	private static final String password = "12";
	
	@Test
	public void bcryptPasswordEncoderTest() {
		System.out.println("---------------bcrypt start---------------");
		PasswordEncoder bcrypt = new BCryptPasswordEncoder(15);
		
		String encoded1 = bcrypt.encode(password);
		String encoded2 = bcrypt.encode(password);
		String encoded3 = bcrypt.encode(password);
		
		System.out.println(encoded1);
		System.out.println(encoded2);
		System.out.println(encoded3);
		
		assertTrue(bcrypt.matches(password, encoded1));
		assertTrue(bcrypt.matches(password, encoded2));
		System.out.println("---------------bcrypt end---------------");
	}
	
	@Test
	public void sha256Test() {
		System.out.println("---------------sha256 start---------------");
		PasswordEncoder sha256 = new StandardPasswordEncoder();
		
		String encoded1 = sha256.encode(password);
		String encoded2 = sha256.encode(password);
		System.out.println(encoded1);
		System.out.println(encoded2);
		
		
		
		assertTrue(sha256.matches(password, encoded1));
		assertTrue(sha256.matches(password, encoded2));
		System.out.println("---------------sha256 end---------------");
	}
	
	@Test
	public void ldapPasswordEncoderTest() {
		System.out.println("---------------ldap start---------------");
		PasswordEncoder ldap = new LdapShaPasswordEncoder();
		
		String encoded1 = ldap.encode(password);
		String encoded2 = ldap.encode(password);
		System.out.println(encoded1);
		System.out.println(encoded2);
		
		
		
		assertTrue(ldap.matches(password, encoded1));
		assertTrue(ldap.matches(password, encoded2));
		System.out.println("---------------ldap end---------------");
	}
	
	@Test
	public void noOpPasswordEncoderTest() {
		System.out.println("---------------noop start---------------");
		PasswordEncoder noOp = NoOpPasswordEncoder.getInstance();
		
		String encodedString = noOp.encode(password);
		System.out.println("Noop value: " + encodedString);
		System.out.println("---------------noop end---------------");
	}
	
	@Test
	public void generateHash() {
		System.out.println(DigestUtils.md5DigestAsHex(password.getBytes()));
		
		String salt = "KORAYSALT_123456Example";
		String salt2 = "KORAYSALT_123456example";
		String saltedPass = password + salt;
		String saltedPass2 = password + salt2;
		
		System.out.println(DigestUtils.md5DigestAsHex(saltedPass.getBytes()));
		System.out.println(DigestUtils.md5DigestAsHex(saltedPass2.getBytes()));
	}
}
