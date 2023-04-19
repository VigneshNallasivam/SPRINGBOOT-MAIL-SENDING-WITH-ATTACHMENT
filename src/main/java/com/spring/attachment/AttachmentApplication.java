package com.spring.attachment;

import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class AttachmentApplication
{
	@Autowired
	private EmailSenderService emailSenderService;

	public static void main(String[] args)
	{
		SpringApplication.run(AttachmentApplication.class, args);
	}
	@EventListener(ApplicationReadyEvent.class)
	public void triggerEmail() throws MessagingException {
		emailSenderService.sendMailWithAttachment("vickyshanehunter@gmail.com","This Is Body of Mail With Some Attachment","Mail Attach Regarding...","C:\\Users\\T50366\\Desktop\\LEARNINGS\\ABSTRACTION-THEORY.txt");

	}

}
