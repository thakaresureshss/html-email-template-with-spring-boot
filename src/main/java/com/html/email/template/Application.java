package com.html.email.template;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * 
 * @author SURESH
 *
 */
@SpringBootApplication
public class Application implements ApplicationRunner {

	@Autowired
	private EmailService emailService;

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(ApplicationArguments applicationArguments) throws Exception {
		Mail mail = new Mail();
		mail.setFrom("thakaresureshss@gmail.com");
		mail.setTo("thakaresureshss@gmail.com");
		mail.setSubject("Sending Email with Freemarker HTML Template Example");
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("name", "Memorynotfound.com");
		model.put("location", "Belgium");
		model.put("signature", "http://xyz.com");
		mail.setModel(model);
		emailService.sendSimpleMessage(mail);
	}
}
