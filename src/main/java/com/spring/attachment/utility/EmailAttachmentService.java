package com.spring.attachment.utility;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class EmailAttachmentService
{
        @Autowired
        private JavaMailSender javaMailSender;
        public void sendMailWithAttachment(String toEmail,
                                           String body,
                                           String subject,
                                           String attachment) throws MessagingException {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,true);
            mimeMessageHelper.setFrom("vickyshanestark@gmail.com");
            mimeMessageHelper.setTo(toEmail);
            mimeMessageHelper.setText(body);
            mimeMessageHelper.setSubject(subject);

            FileSystemResource fileSystemResource = new FileSystemResource(new File(attachment));
            mimeMessageHelper.addAttachment(fileSystemResource.getFilename(),fileSystemResource);
            javaMailSender.send(mimeMessage);
            System.out.println("Mail with Attachment Sent Successfully......!!");
        }
}
