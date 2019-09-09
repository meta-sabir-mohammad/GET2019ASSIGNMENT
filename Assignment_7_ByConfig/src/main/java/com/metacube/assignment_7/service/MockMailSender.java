package com.metacube.assignment_7.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class represent mock mail sender
 * @author Sabir
 *
 */
public class MockMailSender implements MailSender {

	//This is object of logger
	private static final Logger log = LoggerFactory.getLogger(MockMailSender.class);
	
	/**
	 * This method send mock mail
	 * @return true if mail send else false
	 */
	@Override
	public boolean sendMail() {
		
		log.info("Mail send from mock mail sender");
		return true;
	}

	
}
